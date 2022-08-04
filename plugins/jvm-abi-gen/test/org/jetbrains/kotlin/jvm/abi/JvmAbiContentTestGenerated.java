/*
 * Copyright 2010-2022 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.jvm.abi;

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
@TestMetadata("plugins/jvm-abi-gen/testData/content")
@TestDataPath("$PROJECT_ROOT")
@RunWith(JUnit3RunnerWithInners.class)
public class JvmAbiContentTestGenerated extends AbstractJvmAbiContentTest {
    private void runTest(String testDataFilePath) throws Exception {
        KotlinTestUtils.runTest(this::doTest, TargetBackend.JVM, testDataFilePath);
    }

    public void testAllFilesPresentInContent() throws Exception {
        KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("plugins/jvm-abi-gen/testData/content"), Pattern.compile("^([^\\.]+)$"), null, TargetBackend.JVM, false);
    }

    @TestMetadata("annotation")
    public void testAnnotation() throws Exception {
        runTest("plugins/jvm-abi-gen/testData/content/annotation/");
    }

    @TestMetadata("annotationInstantiation")
    public void testAnnotationInstantiation() throws Exception {
        runTest("plugins/jvm-abi-gen/testData/content/annotationInstantiation/");
    }

    @TestMetadata("anonymousAnnotationInstantiation")
    public void testAnonymousAnnotationInstantiation() throws Exception {
        runTest("plugins/jvm-abi-gen/testData/content/anonymousAnnotationInstantiation/");
    }

    @TestMetadata("anonymousWhenMapping")
    public void testAnonymousWhenMapping() throws Exception {
        runTest("plugins/jvm-abi-gen/testData/content/anonymousWhenMapping/");
    }

    @TestMetadata("class")
    public void testClass() throws Exception {
        runTest("plugins/jvm-abi-gen/testData/content/class/");
    }

    @TestMetadata("kt50005")
    public void testKt50005() throws Exception {
        runTest("plugins/jvm-abi-gen/testData/content/kt50005/");
    }

    @TestMetadata("whenMapping")
    public void testWhenMapping() throws Exception {
        runTest("plugins/jvm-abi-gen/testData/content/whenMapping/");
    }
}
