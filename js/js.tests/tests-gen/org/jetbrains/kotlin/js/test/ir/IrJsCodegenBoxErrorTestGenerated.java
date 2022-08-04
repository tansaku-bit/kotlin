/*
 * Copyright 2010-2022 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.js.test.ir;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.util.KtTestUtil;
import org.jetbrains.kotlin.test.TargetBackend;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link GenerateNewCompilerTests.kt}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("compiler/testData/codegen/boxError")
@TestDataPath("$PROJECT_ROOT")
public class IrJsCodegenBoxErrorTestGenerated extends AbstractIrJsCodegenBoxErrorTest {
    @Test
    public void testAllFilesPresentInBoxError() throws Exception {
        KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/codegen/boxError"), Pattern.compile("^(.+)\\.kt$"), null, TargetBackend.JS_IR, true, "compileKotlinAgainstKotlin");
    }

    @Nested
    @TestMetadata("compiler/testData/codegen/boxError/semantic")
    @TestDataPath("$PROJECT_ROOT")
    public class Semantic {
        @Test
        public void testAllFilesPresentInSemantic() throws Exception {
            KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/codegen/boxError/semantic"), Pattern.compile("^(.+)\\.kt$"), null, TargetBackend.JS_IR, true);
        }

        @Test
        @TestMetadata("castToErrorType.kt")
        public void testCastToErrorType() throws Exception {
            runTest("compiler/testData/codegen/boxError/semantic/castToErrorType.kt");
        }

        @Test
        @TestMetadata("catchErrorType.kt")
        public void testCatchErrorType() throws Exception {
            runTest("compiler/testData/codegen/boxError/semantic/catchErrorType.kt");
        }

        @Test
        @TestMetadata("evaluationOrder.kt")
        public void testEvaluationOrder() throws Exception {
            runTest("compiler/testData/codegen/boxError/semantic/evaluationOrder.kt");
        }

        @Test
        @TestMetadata("mismatchTypeParameters.kt")
        public void testMismatchTypeParameters() throws Exception {
            runTest("compiler/testData/codegen/boxError/semantic/mismatchTypeParameters.kt");
        }

        @Test
        @TestMetadata("missedBody.kt")
        public void testMissedBody() throws Exception {
            runTest("compiler/testData/codegen/boxError/semantic/missedBody.kt");
        }

        @Test
        @TestMetadata("reifiedNonInline.kt")
        public void testReifiedNonInline() throws Exception {
            runTest("compiler/testData/codegen/boxError/semantic/reifiedNonInline.kt");
        }

        @Test
        @TestMetadata("reifiedWithWrongArguments.kt")
        public void testReifiedWithWrongArguments() throws Exception {
            runTest("compiler/testData/codegen/boxError/semantic/reifiedWithWrongArguments.kt");
        }

        @Test
        @TestMetadata("typeMismatch.kt")
        public void testTypeMismatch() throws Exception {
            runTest("compiler/testData/codegen/boxError/semantic/typeMismatch.kt");
        }

        @Test
        @TestMetadata("unmatchedArguments.kt")
        public void testUnmatchedArguments() throws Exception {
            runTest("compiler/testData/codegen/boxError/semantic/unmatchedArguments.kt");
        }

        @Test
        @TestMetadata("unresolvedFunctionReferece.kt")
        public void testUnresolvedFunctionReferece() throws Exception {
            runTest("compiler/testData/codegen/boxError/semantic/unresolvedFunctionReferece.kt");
        }
    }

    @Nested
    @TestMetadata("compiler/testData/codegen/boxError/syntax")
    @TestDataPath("$PROJECT_ROOT")
    public class Syntax {
        @Test
        public void testAllFilesPresentInSyntax() throws Exception {
            KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/codegen/boxError/syntax"), Pattern.compile("^(.+)\\.kt$"), null, TargetBackend.JS_IR, true);
        }

        @Test
        @TestMetadata("arrowReference.kt")
        public void testArrowReference() throws Exception {
            runTest("compiler/testData/codegen/boxError/syntax/arrowReference.kt");
        }

        @Test
        @TestMetadata("evaluationOrder.kt")
        public void testEvaluationOrder() throws Exception {
            runTest("compiler/testData/codegen/boxError/syntax/evaluationOrder.kt");
        }

        @Test
        @TestMetadata("incorectLexicalName.kt")
        public void testIncorectLexicalName() throws Exception {
            runTest("compiler/testData/codegen/boxError/syntax/incorectLexicalName.kt");
        }

        @Test
        @TestMetadata("missedArgument.kt")
        public void testMissedArgument() throws Exception {
            runTest("compiler/testData/codegen/boxError/syntax/missedArgument.kt");
        }
    }
}
