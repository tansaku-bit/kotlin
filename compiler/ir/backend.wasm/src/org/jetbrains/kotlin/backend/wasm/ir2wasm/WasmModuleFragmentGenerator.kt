/*
 * Copyright 2010-2020 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.backend.wasm.ir2wasm

import org.jetbrains.kotlin.backend.wasm.WasmBackendContext
import org.jetbrains.kotlin.backend.wasm.utils.DiscriminatedUnions
import org.jetbrains.kotlin.ir.IrElement
import org.jetbrains.kotlin.ir.declarations.IrClass
import org.jetbrains.kotlin.ir.declarations.IrDeclaration
import org.jetbrains.kotlin.ir.declarations.IrModuleFragment
import org.jetbrains.kotlin.ir.declarations.IrPackageFragment
import org.jetbrains.kotlin.ir.types.classOrNull
import org.jetbrains.kotlin.ir.util.fqNameWhenAvailable
import org.jetbrains.kotlin.ir.util.isInterface
import org.jetbrains.kotlin.ir.util.kotlinFqName
import org.jetbrains.kotlin.ir.visitors.IrElementVisitorVoid
import org.jetbrains.kotlin.ir.visitors.acceptVoid
import org.jetbrains.kotlin.types.checker.SimpleClassicTypeSystemContext.isInterface

class WasmModuleFragmentGenerator(
    backendContext: WasmBackendContext,
    wasmModuleFragment: WasmCompiledModuleFragment,
    allowIncompleteImplementations: Boolean,
) {
    private val declarationGenerator =
        DeclarationGenerator(
            WasmModuleCodegenContextImpl(
                backendContext,
                wasmModuleFragment,
            ),
            allowIncompleteImplementations
        )

    private val discriminatedInterfaceUnions = DiscriminatedUnions<IrClass>()
    private fun deepInterfacesTraversal(klass: IrClass): Sequence<IrClass> = sequence {
        for (type in klass.superTypes) {
            val superType = type.classOrNull?.owner
            if (superType != null) {
                if (superType.isInterface) yield(superType)
                yieldAll(deepInterfacesTraversal(superType))
            }
        }
    }

    private val interfaceUnionsCollector = object : IrElementVisitorVoid {
        override fun visitElement(element: IrElement) = Unit
        override fun visitClass(declaration: IrClass) {
            if (!declaration.isInterface && declaration.superTypes.any()) {
                discriminatedInterfaceUnions.addUnion(deepInterfacesTraversal(declaration))
            }
            for (member in declaration.declarations) {
                member.acceptVoid(this)
            }
        }
    }

    private val printer = object : IrElementVisitorVoid {
        override fun visitElement(element: IrElement) = Unit

        var max = 0

        override fun visitClass(declaration: IrClass) {
            if (!declaration.isInterface && declaration.superTypes.any()) {
                val firstInterface = deepInterfacesTraversal(declaration).firstOrNull()
                if (firstInterface != null) {
                    println(declaration.fqNameWhenAvailable?.asString() ?: "NONAME:")
                    val union = discriminatedInterfaceUnions.getUnion(firstInterface)
                    max = maxOf(max, union.size)
                    union.forEach {
                        println("--- ${it.fqNameWhenAvailable?.asString() ?: "NONAME INTERFACE??"}")
                    }
                }
            }
            for (member in declaration.declarations) {
                member.acceptVoid(this)
            }
        }
    }

    private fun forAllDeclarations(irModuleFragment: IrModuleFragment, visitor: IrElementVisitorVoid) {
        for (irFile in irModuleFragment.files) {
            for (irDeclaration in irFile.declarations) {
                irDeclaration.acceptVoid(visitor)
            }
        }
    }

    fun generateModule(irModuleFragment: IrModuleFragment) {
        forAllDeclarations(irModuleFragment, interfaceUnionsCollector)
        discriminatedInterfaceUnions.compress()
        forAllDeclarations(irModuleFragment, printer)
        println("XXXSXXXXXXX -> ${printer.max}")
        forAllDeclarations(irModuleFragment, declarationGenerator)
    }
}
