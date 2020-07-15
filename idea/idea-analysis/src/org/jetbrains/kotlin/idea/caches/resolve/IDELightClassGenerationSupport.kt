/*
 * Copyright 2010-2019 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.idea.caches.resolve

import com.intellij.openapi.module.ModuleUtilCore
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiManager
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.util.CachedValue
import com.intellij.psi.util.CachedValueProvider
import com.intellij.psi.util.CachedValuesManager
import com.intellij.psi.util.PsiModificationTracker
import com.intellij.util.containers.ConcurrentFactoryMap
import org.jetbrains.kotlin.asJava.LightClassBuilder
import org.jetbrains.kotlin.asJava.LightClassGenerationSupport
import org.jetbrains.kotlin.asJava.builder.InvalidLightClassDataHolder
import org.jetbrains.kotlin.asJava.builder.LightClassDataHolder
import org.jetbrains.kotlin.asJava.classes.*
import org.jetbrains.kotlin.asJava.finder.JavaElementFinder
import org.jetbrains.kotlin.codegen.ClassBuilderMode
import org.jetbrains.kotlin.codegen.JvmCodegenUtil
import org.jetbrains.kotlin.codegen.state.KotlinTypeMapper
import org.jetbrains.kotlin.config.JvmTarget
import org.jetbrains.kotlin.config.LanguageFeature
import org.jetbrains.kotlin.descriptors.DeclarationDescriptor
import org.jetbrains.kotlin.descriptors.annotations.AnnotationDescriptor
import org.jetbrains.kotlin.idea.caches.lightClasses.IDELightClassContexts
import org.jetbrains.kotlin.idea.caches.lightClasses.LazyLightClassDataHolder
import org.jetbrains.kotlin.idea.project.languageVersionSettings
import org.jetbrains.kotlin.idea.resolve.frontendService
import org.jetbrains.kotlin.idea.stubindex.KotlinTypeAliasShortNameIndex
import org.jetbrains.kotlin.lexer.KtTokens
import org.jetbrains.kotlin.name.FqName
import org.jetbrains.kotlin.name.Name
import org.jetbrains.kotlin.psi.*
import org.jetbrains.kotlin.resolve.BindingContext
import org.jetbrains.kotlin.resolve.constants.evaluate.ConstantExpressionEvaluator
import org.jetbrains.kotlin.resolve.deprecation.DeprecationResolver
import org.jetbrains.kotlin.resolve.lazy.BodyResolveMode
import org.jetbrains.kotlin.resolve.lazy.NoDescriptorForDeclarationException
import org.jetbrains.kotlin.types.KotlinType
import java.util.concurrent.ConcurrentMap

class IDELightClassGenerationSupport(private val project: Project) : LightClassGenerationSupport() {

    private class KtUltraLightSupportImpl(private val element: KtElement) : KtUltraLightSupport {

        private val module = ModuleUtilCore.findModuleForPsiElement(element)

        private val languageVersionSettings
            get() = module?.languageVersionSettings ?: KotlinTypeMapper.LANGUAGE_VERSION_SETTINGS_DEFAULT

        override val isReleasedCoroutine
            get() = languageVersionSettings.supportsFeature(LanguageFeature.ReleaseCoroutines) ?: true

        override fun getConstantEvaluator(expression: KtExpression): ConstantExpressionEvaluator =
            ConstantExpressionEvaluator(moduleDescriptor, KotlinTypeMapper.LANGUAGE_VERSION_SETTINGS_DEFAULT, expression.project)

        private val resolutionFacade get() = element.getResolutionFacade()

        override val moduleDescriptor get() = resolutionFacade.moduleDescriptor

        override val moduleName: String by lazyPub {
            JvmCodegenUtil.getModuleName(moduleDescriptor)
        }

        override val deprecationResolver: DeprecationResolver get() = resolutionFacade.getFrontendService(DeprecationResolver::class.java)

        override fun possiblyHasAlias(file: KtFile, shortName: Name): Boolean =
            allAliases(file)[shortName.asString()] == true

        private fun allAliases(file: KtFile): ConcurrentMap<String, Boolean> = CachedValuesManager.getCachedValue(file) {
            val importAliases = file.importDirectives.mapNotNull { it.aliasName }.toSet()
            val map = ConcurrentFactoryMap.createMap<String, Boolean> { s ->
                s in importAliases || KotlinTypeAliasShortNameIndex.getInstance().get(s, file.project, file.resolveScope).isNotEmpty()
            }
            CachedValueProvider.Result.create<ConcurrentMap<String, Boolean>>(map, PsiModificationTracker.MODIFICATION_COUNT)
        }

        override val typeMapper: KotlinTypeMapper by lazyPub {
            KotlinTypeMapper(
                BindingContext.EMPTY, ClassBuilderMode.LIGHT_CLASSES,
                moduleName, languageVersionSettings,
                jvmTarget = JvmTarget.JVM_1_8,
                typePreprocessor = KotlinType::cleanFromAnonymousTypes,
                namePreprocessor = ::tryGetPredefinedName
            )
        }
    }

    override fun createUltraLightClassForFacade(
        manager: PsiManager,
        facadeClassFqName: FqName,
        lightClassDataCache: CachedValue<LightClassDataHolder.ForFacade>,
        files: Collection<KtFile>
    ): KtUltraLightClassForFacade? {

        if (files.any { it.isScript() }) return null

        val filesToSupports: List<Pair<KtFile, KtUltraLightSupport>> = files.map {
            it to KtUltraLightSupportImpl(it)
        }

        return KtUltraLightClassForFacade(
            manager,
            facadeClassFqName,
            lightClassDataCache,
            files,
            filesToSupports
        )
    }

    override fun createUltraLightClass(element: KtClassOrObject): KtUltraLightClass? {
        if (element.shouldNotBeVisibleAsLightClass()) {
            return null
        }

        return KtUltraLightSupportImpl(element).let { support ->
            when {
                element is KtObjectDeclaration && element.isObjectLiteral() ->
                    KtUltraLightClassForAnonymousDeclaration(element, support)

                element.safeIsLocal() ->
                    KtUltraLightClassForLocalDeclaration(element, support)

                (element.hasModifier(KtTokens.INLINE_KEYWORD)) ->
                    KtUltraLightInlineClass(element, support)

                else -> KtUltraLightClass(element, support)
            }
        }
    }

    override fun createUltraLightClassForScript(script: KtScript): KtUltraLightClassForScript? =
        KtUltraLightClassForScript(script, support = KtUltraLightSupportImpl(script))

    override fun getUltraLightClassSupport(element: KtElement): KtUltraLightSupport =
        KtUltraLightSupportImpl(element)

    private val scopeFileComparator = JavaElementFinder.byClasspathComparator(GlobalSearchScope.allScope(project))

    override fun createDataHolderForClass(classOrObject: KtClassOrObject, builder: LightClassBuilder): LightClassDataHolder.ForClass {
        return when {
            classOrObject.shouldNotBeVisibleAsLightClass() -> InvalidLightClassDataHolder
            classOrObject.isLocal -> LazyLightClassDataHolder.ForClass(
                builder,
                exactContextProvider = { IDELightClassContexts.contextForLocalClassOrObject(classOrObject) },
                dummyContextProvider = null,
                diagnosticsHolderProvider = { classOrObject.getDiagnosticsHolder() }
            )
            else -> LazyLightClassDataHolder.ForClass(
                builder,
                exactContextProvider = { IDELightClassContexts.contextForNonLocalClassOrObject(classOrObject) },
                dummyContextProvider = { IDELightClassContexts.lightContextForClassOrObject(classOrObject) },
                diagnosticsHolderProvider = { classOrObject.getDiagnosticsHolder() }
            )
        }
    }

    override fun createDataHolderForFacade(files: Collection<KtFile>, builder: LightClassBuilder): LightClassDataHolder.ForFacade {
        assert(!files.isEmpty()) { "No files in facade" }

        val sortedFiles = files.sortedWith(scopeFileComparator)

        return LazyLightClassDataHolder.ForFacade(
            builder,
            exactContextProvider = { IDELightClassContexts.contextForFacade(sortedFiles) },
            dummyContextProvider = { IDELightClassContexts.lightContextForFacade(sortedFiles) },
            diagnosticsHolderProvider = { files.first().getDiagnosticsHolder() }
        )
    }

    override fun createDataHolderForScript(script: KtScript, builder: LightClassBuilder): LightClassDataHolder.ForScript {
        return LazyLightClassDataHolder.ForScript(
            builder,
            exactContextProvider = { IDELightClassContexts.contextForScript(script) },
            dummyContextProvider = { null },
            diagnosticsHolderProvider = { script.getDiagnosticsHolder() }
        )
    }

    private fun KtElement.getDiagnosticsHolder() =
        getResolutionFacade().frontendService<LazyLightClassDataHolder.DiagnosticsHolder>()

    override fun resolveToDescriptor(declaration: KtDeclaration): DeclarationDescriptor? {
        return try {
            declaration.resolveToDescriptorIfAny(BodyResolveMode.FULL)
        } catch (e: NoDescriptorForDeclarationException) {
            null
        }
    }

    override fun analyze(element: KtElement) = element.analyze(BodyResolveMode.PARTIAL)

    override fun analyzeWithContent(element: KtClassOrObject) = element.analyzeWithContent()
}