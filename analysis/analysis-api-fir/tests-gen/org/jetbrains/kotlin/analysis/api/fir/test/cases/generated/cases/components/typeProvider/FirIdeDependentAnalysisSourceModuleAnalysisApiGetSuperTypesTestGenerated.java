/*
 * Copyright 2010-2022 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.analysis.api.fir.test.cases.generated.cases.components.typeProvider;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.util.KtTestUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.kotlin.analysis.api.fir.test.configurators.AnalysisApiFirTestConfiguratorFactory;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.AnalysisApiTestConfiguratorFactoryData;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.AnalysisApiTestConfigurator;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.TestModuleKind;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.FrontendKind;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.AnalysisSessionMode;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.AnalysisApiMode;
import org.jetbrains.kotlin.analysis.api.impl.base.test.cases.components.typeProvider.AbstractAnalysisApiGetSuperTypesTest;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link GenerateNewCompilerTests.kt}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("analysis/analysis-api/testData/components/typeInfoProvider/superTypes")
@TestDataPath("$PROJECT_ROOT")
public class FirIdeDependentAnalysisSourceModuleAnalysisApiGetSuperTypesTestGenerated extends AbstractAnalysisApiGetSuperTypesTest {
    @NotNull
    @Override
    public AnalysisApiTestConfigurator getConfigurator() {
        return AnalysisApiFirTestConfiguratorFactory.INSTANCE.createConfigurator(
            new AnalysisApiTestConfiguratorFactoryData(
                FrontendKind.Fir,
                TestModuleKind.Source,
                AnalysisSessionMode.Dependent,
                AnalysisApiMode.Ide
            )
        );
    }

    @Test
    public void testAllFilesPresentInSuperTypes() throws Exception {
        KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/analysis-api/testData/components/typeInfoProvider/superTypes"), Pattern.compile("^(.+)\\.kt$"), null, true);
    }

    @Test
    @TestMetadata("anonymousObject.kt")
    public void testAnonymousObject() throws Exception {
        runTest("analysis/analysis-api/testData/components/typeInfoProvider/superTypes/anonymousObject.kt");
    }

    @Test
    @TestMetadata("any.kt")
    public void testAny() throws Exception {
        runTest("analysis/analysis-api/testData/components/typeInfoProvider/superTypes/any.kt");
    }

    @Test
    @TestMetadata("contravariant.kt")
    public void testContravariant() throws Exception {
        runTest("analysis/analysis-api/testData/components/typeInfoProvider/superTypes/contravariant.kt");
    }

    @Test
    @TestMetadata("covariant.kt")
    public void testCovariant() throws Exception {
        runTest("analysis/analysis-api/testData/components/typeInfoProvider/superTypes/covariant.kt");
    }

    @Test
    @TestMetadata("errorType.kt")
    public void testErrorType() throws Exception {
        runTest("analysis/analysis-api/testData/components/typeInfoProvider/superTypes/errorType.kt");
    }

    @Test
    @TestMetadata("flexibleType.kt")
    public void testFlexibleType() throws Exception {
        runTest("analysis/analysis-api/testData/components/typeInfoProvider/superTypes/flexibleType.kt");
    }

    @Test
    @TestMetadata("int.kt")
    public void testInt() throws Exception {
        runTest("analysis/analysis-api/testData/components/typeInfoProvider/superTypes/int.kt");
    }

    @Test
    @TestMetadata("invariant.kt")
    public void testInvariant() throws Exception {
        runTest("analysis/analysis-api/testData/components/typeInfoProvider/superTypes/invariant.kt");
    }

    @Test
    @TestMetadata("recursiveTypeParameter.kt")
    public void testRecursiveTypeParameter() throws Exception {
        runTest("analysis/analysis-api/testData/components/typeInfoProvider/superTypes/recursiveTypeParameter.kt");
    }

    @Test
    @TestMetadata("regularClass.kt")
    public void testRegularClass() throws Exception {
        runTest("analysis/analysis-api/testData/components/typeInfoProvider/superTypes/regularClass.kt");
    }

    @Test
    @TestMetadata("regularClassWithBounds.kt")
    public void testRegularClassWithBounds() throws Exception {
        runTest("analysis/analysis-api/testData/components/typeInfoProvider/superTypes/regularClassWithBounds.kt");
    }

    @Test
    @TestMetadata("star.kt")
    public void testStar() throws Exception {
        runTest("analysis/analysis-api/testData/components/typeInfoProvider/superTypes/star.kt");
    }

    @Test
    @TestMetadata("string.kt")
    public void testString() throws Exception {
        runTest("analysis/analysis-api/testData/components/typeInfoProvider/superTypes/string.kt");
    }

    @Test
    @TestMetadata("typeParameter.kt")
    public void testTypeParameter() throws Exception {
        runTest("analysis/analysis-api/testData/components/typeInfoProvider/superTypes/typeParameter.kt");
    }
}
