/*
 * Copyright 2010-2022 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.jvm.compiler;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.JUnit3RunnerWithInners;
import org.jetbrains.kotlin.test.KotlinTestUtils;
import org.jetbrains.kotlin.test.util.KtTestUtil;
import org.jetbrains.kotlin.test.TargetBackend;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.runner.RunWith;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.TestsPackage}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@RunWith(JUnit3RunnerWithInners.class)
public class CompileKotlinAgainstJavaTestGenerated extends AbstractCompileKotlinAgainstJavaTest {
    @TestMetadata("compiler/testData/compileKotlinAgainstJava")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class WithAPT extends AbstractCompileKotlinAgainstJavaTest {
        private void runTest(String testDataFilePath) throws Exception {
            KotlinTestUtils.runTest(this::doTestWithAPT, TargetBackend.JVM, testDataFilePath);
        }

        @TestMetadata("AbstractClass.kt")
        public void testAbstractClass() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/AbstractClass.kt");
        }

        @TestMetadata("AbstractEnum.kt")
        public void testAbstractEnum() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/AbstractEnum.kt");
        }

        public void testAllFilesPresentInWithAPT() throws Exception {
            KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/compileKotlinAgainstJava"), Pattern.compile("^(.+)\\.kt$"), null, TargetBackend.JVM, true);
        }

        @TestMetadata("AnnotationWithArguments.kt")
        public void testAnnotationWithArguments() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/AnnotationWithArguments.kt");
        }

        @TestMetadata("AnnotationWithField.kt")
        public void testAnnotationWithField() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/AnnotationWithField.kt");
        }

        @TestMetadata("AsteriskInImport.kt")
        public void testAsteriskInImport() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/AsteriskInImport.kt");
        }

        @TestMetadata("CheckKotlinStub.kt")
        public void testCheckKotlinStub() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/CheckKotlinStub.kt");
        }

        @TestMetadata("CheckNotNull.kt")
        public void testCheckNotNull() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/CheckNotNull.kt");
        }

        @TestMetadata("Class.kt")
        public void testClass() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/Class.kt");
        }

        @TestMetadata("ClassDefaultConstructor.kt")
        public void testClassDefaultConstructor() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/ClassDefaultConstructor.kt");
        }

        @TestMetadata("ClassWithNestedEnum.kt")
        public void testClassWithNestedEnum() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/ClassWithNestedEnum.kt");
        }

        @TestMetadata("ClassWithTypeParameter.kt")
        public void testClassWithTypeParameter() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/ClassWithTypeParameter.kt");
        }

        @TestMetadata("CyclicDependencies.kt")
        public void testCyclicDependencies() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/CyclicDependencies.kt");
        }

        @TestMetadata("DefaultModifier.kt")
        public void testDefaultModifier() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/DefaultModifier.kt");
        }

        @TestMetadata("EnclosingClassInner.kt")
        public void testEnclosingClassInner() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/EnclosingClassInner.kt");
        }

        @TestMetadata("Enum.kt")
        public void testEnum() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/Enum.kt");
        }

        @TestMetadata("EnumName.kt")
        public void testEnumName() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/EnumName.kt");
        }

        @TestMetadata("EnumValues.kt")
        public void testEnumValues() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/EnumValues.kt");
        }

        @TestMetadata("Inheritance.kt")
        public void testInheritance() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/Inheritance.kt");
        }

        @TestMetadata("InheritedInner.kt")
        public void testInheritedInner() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/InheritedInner.kt");
        }

        @TestMetadata("InnerCanonicalName.kt")
        public void testInnerCanonicalName() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/InnerCanonicalName.kt");
        }

        @TestMetadata("InnerClass.kt")
        public void testInnerClass() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/InnerClass.kt");
        }

        @TestMetadata("InnerClassFromAsteriskImport.kt")
        public void testInnerClassFromAsteriskImport() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/InnerClassFromAsteriskImport.kt");
        }

        @TestMetadata("InnerClassFromImport.kt")
        public void testInnerClassFromImport() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/InnerClassFromImport.kt");
        }

        @TestMetadata("InnerWithGenericOuter.kt")
        public void testInnerWithGenericOuter() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/InnerWithGenericOuter.kt");
        }

        @TestMetadata("Interface.kt")
        public void testInterface() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/Interface.kt");
        }

        @TestMetadata("InterfaceField.kt")
        public void testInterfaceField() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/InterfaceField.kt");
        }

        @TestMetadata("InterfaceMemberClass.kt")
        public void testInterfaceMemberClass() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/InterfaceMemberClass.kt");
        }

        @TestMetadata("InterfaceWithDefault.kt")
        public void testInterfaceWithDefault() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/InterfaceWithDefault.kt");
        }

        @TestMetadata("JavaLangClass.kt")
        public void testJavaLangClass() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/JavaLangClass.kt");
        }

        @TestMetadata("ListImpl.kt")
        public void testListImpl() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/ListImpl.kt");
        }

        @TestMetadata("MapExample.kt")
        public void testMapExample() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/MapExample.kt");
        }

        @TestMetadata("Method.kt")
        public void testMethod() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/Method.kt");
        }

        @TestMetadata("MethodWithArgument.kt")
        public void testMethodWithArgument() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/MethodWithArgument.kt");
        }

        @TestMetadata("MethodWithSeveralTypeParameters.kt")
        public void testMethodWithSeveralTypeParameters() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/MethodWithSeveralTypeParameters.kt");
        }

        @TestMetadata("MethodWithTypeParameter.kt")
        public void testMethodWithTypeParameter() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/MethodWithTypeParameter.kt");
        }

        @TestMetadata("MethodWithWildcard.kt")
        public void testMethodWithWildcard() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/MethodWithWildcard.kt");
        }

        @TestMetadata("Nesting.kt")
        public void testNesting() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/Nesting.kt");
        }

        @TestMetadata("RawReturnType.kt")
        public void testRawReturnType() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/RawReturnType.kt");
        }

        @TestMetadata("ReturnEnum.kt")
        public void testReturnEnum() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/ReturnEnum.kt");
        }

        @TestMetadata("ReturnInnerClass.kt")
        public void testReturnInnerClass() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/ReturnInnerClass.kt");
        }

        @TestMetadata("ReturnInnerInInner.kt")
        public void testReturnInnerInInner() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/ReturnInnerInInner.kt");
        }

        @TestMetadata("ReturnInnerInner.kt")
        public void testReturnInnerInner() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/ReturnInnerInner.kt");
        }

        @TestMetadata("ReturnNested.kt")
        public void testReturnNested() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/ReturnNested.kt");
        }

        @TestMetadata("ReturnNestedFQ.kt")
        public void testReturnNestedFQ() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/ReturnNestedFQ.kt");
        }

        @TestMetadata("ReturnType.kt")
        public void testReturnType() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/ReturnType.kt");
        }

        @TestMetadata("ReturnTypeResolution.kt")
        public void testReturnTypeResolution() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/ReturnTypeResolution.kt");
        }

        @TestMetadata("SeveralInnerClasses.kt")
        public void testSeveralInnerClasses() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/SeveralInnerClasses.kt");
        }

        @TestMetadata("SimpleAnnotation.kt")
        public void testSimpleAnnotation() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/SimpleAnnotation.kt");
        }

        @TestMetadata("SimpleWildcard.kt")
        public void testSimpleWildcard() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/SimpleWildcard.kt");
        }

        @TestMetadata("Singleton.kt")
        public void testSingleton() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/Singleton.kt");
        }

        @TestMetadata("StaticNestedClass.kt")
        public void testStaticNestedClass() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/StaticNestedClass.kt");
        }

        @TestMetadata("TypeArgumentInSuperType.kt")
        public void testTypeArgumentInSuperType() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/TypeArgumentInSuperType.kt");
        }

        @TestMetadata("TypeParameter.kt")
        public void testTypeParameter() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/TypeParameter.kt");
        }

        @TestMetadata("UseKtClass.kt")
        public void testUseKtClass() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/UseKtClass.kt");
        }

        @TestMetadata("Vararg.kt")
        public void testVararg() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/Vararg.kt");
        }
    }

    @TestMetadata("compiler/testData/compileKotlinAgainstJava")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class WithoutAPT extends AbstractCompileKotlinAgainstJavaTest {
        private void runTest(String testDataFilePath) throws Exception {
            KotlinTestUtils.runTest(this::doTestWithoutAPT, TargetBackend.JVM, testDataFilePath);
        }

        @TestMetadata("AbstractClass.kt")
        public void testAbstractClass() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/AbstractClass.kt");
        }

        @TestMetadata("AbstractEnum.kt")
        public void testAbstractEnum() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/AbstractEnum.kt");
        }

        public void testAllFilesPresentInWithoutAPT() throws Exception {
            KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/compileKotlinAgainstJava"), Pattern.compile("^(.+)\\.kt$"), null, TargetBackend.JVM, true);
        }

        @TestMetadata("AnnotationWithArguments.kt")
        public void testAnnotationWithArguments() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/AnnotationWithArguments.kt");
        }

        @TestMetadata("AnnotationWithField.kt")
        public void testAnnotationWithField() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/AnnotationWithField.kt");
        }

        @TestMetadata("AsteriskInImport.kt")
        public void testAsteriskInImport() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/AsteriskInImport.kt");
        }

        @TestMetadata("CheckKotlinStub.kt")
        public void testCheckKotlinStub() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/CheckKotlinStub.kt");
        }

        @TestMetadata("CheckNotNull.kt")
        public void testCheckNotNull() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/CheckNotNull.kt");
        }

        @TestMetadata("Class.kt")
        public void testClass() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/Class.kt");
        }

        @TestMetadata("ClassDefaultConstructor.kt")
        public void testClassDefaultConstructor() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/ClassDefaultConstructor.kt");
        }

        @TestMetadata("ClassWithNestedEnum.kt")
        public void testClassWithNestedEnum() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/ClassWithNestedEnum.kt");
        }

        @TestMetadata("ClassWithTypeParameter.kt")
        public void testClassWithTypeParameter() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/ClassWithTypeParameter.kt");
        }

        @TestMetadata("CyclicDependencies.kt")
        public void testCyclicDependencies() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/CyclicDependencies.kt");
        }

        @TestMetadata("DefaultModifier.kt")
        public void testDefaultModifier() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/DefaultModifier.kt");
        }

        @TestMetadata("EnclosingClassInner.kt")
        public void testEnclosingClassInner() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/EnclosingClassInner.kt");
        }

        @TestMetadata("Enum.kt")
        public void testEnum() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/Enum.kt");
        }

        @TestMetadata("EnumName.kt")
        public void testEnumName() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/EnumName.kt");
        }

        @TestMetadata("EnumValues.kt")
        public void testEnumValues() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/EnumValues.kt");
        }

        @TestMetadata("Inheritance.kt")
        public void testInheritance() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/Inheritance.kt");
        }

        @TestMetadata("InheritedInner.kt")
        public void testInheritedInner() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/InheritedInner.kt");
        }

        @TestMetadata("InnerCanonicalName.kt")
        public void testInnerCanonicalName() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/InnerCanonicalName.kt");
        }

        @TestMetadata("InnerClass.kt")
        public void testInnerClass() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/InnerClass.kt");
        }

        @TestMetadata("InnerClassFromAsteriskImport.kt")
        public void testInnerClassFromAsteriskImport() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/InnerClassFromAsteriskImport.kt");
        }

        @TestMetadata("InnerClassFromImport.kt")
        public void testInnerClassFromImport() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/InnerClassFromImport.kt");
        }

        @TestMetadata("InnerWithGenericOuter.kt")
        public void testInnerWithGenericOuter() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/InnerWithGenericOuter.kt");
        }

        @TestMetadata("Interface.kt")
        public void testInterface() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/Interface.kt");
        }

        @TestMetadata("InterfaceField.kt")
        public void testInterfaceField() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/InterfaceField.kt");
        }

        @TestMetadata("InterfaceMemberClass.kt")
        public void testInterfaceMemberClass() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/InterfaceMemberClass.kt");
        }

        @TestMetadata("InterfaceWithDefault.kt")
        public void testInterfaceWithDefault() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/InterfaceWithDefault.kt");
        }

        @TestMetadata("JavaLangClass.kt")
        public void testJavaLangClass() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/JavaLangClass.kt");
        }

        @TestMetadata("ListImpl.kt")
        public void testListImpl() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/ListImpl.kt");
        }

        @TestMetadata("MapExample.kt")
        public void testMapExample() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/MapExample.kt");
        }

        @TestMetadata("Method.kt")
        public void testMethod() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/Method.kt");
        }

        @TestMetadata("MethodWithArgument.kt")
        public void testMethodWithArgument() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/MethodWithArgument.kt");
        }

        @TestMetadata("MethodWithSeveralTypeParameters.kt")
        public void testMethodWithSeveralTypeParameters() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/MethodWithSeveralTypeParameters.kt");
        }

        @TestMetadata("MethodWithTypeParameter.kt")
        public void testMethodWithTypeParameter() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/MethodWithTypeParameter.kt");
        }

        @TestMetadata("MethodWithWildcard.kt")
        public void testMethodWithWildcard() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/MethodWithWildcard.kt");
        }

        @TestMetadata("Nesting.kt")
        public void testNesting() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/Nesting.kt");
        }

        @TestMetadata("RawReturnType.kt")
        public void testRawReturnType() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/RawReturnType.kt");
        }

        @TestMetadata("ReturnEnum.kt")
        public void testReturnEnum() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/ReturnEnum.kt");
        }

        @TestMetadata("ReturnInnerClass.kt")
        public void testReturnInnerClass() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/ReturnInnerClass.kt");
        }

        @TestMetadata("ReturnInnerInInner.kt")
        public void testReturnInnerInInner() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/ReturnInnerInInner.kt");
        }

        @TestMetadata("ReturnInnerInner.kt")
        public void testReturnInnerInner() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/ReturnInnerInner.kt");
        }

        @TestMetadata("ReturnNested.kt")
        public void testReturnNested() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/ReturnNested.kt");
        }

        @TestMetadata("ReturnNestedFQ.kt")
        public void testReturnNestedFQ() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/ReturnNestedFQ.kt");
        }

        @TestMetadata("ReturnType.kt")
        public void testReturnType() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/ReturnType.kt");
        }

        @TestMetadata("ReturnTypeResolution.kt")
        public void testReturnTypeResolution() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/ReturnTypeResolution.kt");
        }

        @TestMetadata("SeveralInnerClasses.kt")
        public void testSeveralInnerClasses() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/SeveralInnerClasses.kt");
        }

        @TestMetadata("SimpleAnnotation.kt")
        public void testSimpleAnnotation() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/SimpleAnnotation.kt");
        }

        @TestMetadata("SimpleWildcard.kt")
        public void testSimpleWildcard() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/SimpleWildcard.kt");
        }

        @TestMetadata("Singleton.kt")
        public void testSingleton() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/Singleton.kt");
        }

        @TestMetadata("StaticNestedClass.kt")
        public void testStaticNestedClass() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/StaticNestedClass.kt");
        }

        @TestMetadata("TypeArgumentInSuperType.kt")
        public void testTypeArgumentInSuperType() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/TypeArgumentInSuperType.kt");
        }

        @TestMetadata("TypeParameter.kt")
        public void testTypeParameter() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/TypeParameter.kt");
        }

        @TestMetadata("UseKtClass.kt")
        public void testUseKtClass() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/UseKtClass.kt");
        }

        @TestMetadata("Vararg.kt")
        public void testVararg() throws Exception {
            runTest("compiler/testData/compileKotlinAgainstJava/Vararg.kt");
        }
    }
}
