package com.jamesnthomas.symbolique.core.symbols

import com.jamesnthomas.symbolique.core.scopes.Scope
import com.jamesnthomas.symbolique.core.types.Type

/**
 * Represents a generic programming language symbol within Symbolique,
 * designed to be versatile across different programming languages.
 * Implementations must provide hashCode and equals for effective comparison.
 */
interface Symbol {
    val name: String
    var scope: Scope?
    val type: Type?
    val visibility: Visibility
    val declarationLocation: SourceLocation
    val modifiers: Set<Modifier>
    val documentation: String?
    val annotations: List<Annotation>
    var insertionOrderNumber: Int

    // Implementations should override equals to ensure that Symbols are compared
    // based on their properties, particularly `name` and `scope`.
    override fun equals(other: Any?): Boolean

    // Implementations should override hashCode to be consistent with equals.
    // This usually involves computing the hash code based on the same properties
    // used in equals, particularly `name` and `scope`.
    override fun hashCode(): Int

    data class SourceLocation(val filePath: String, val line: Int, val column: Int)

    enum class Visibility {
        PUBLIC, PROTECTED, PRIVATE, INTERNAL, PACKAGE_PRIVATE
    }

    enum class Modifier {
        STATIC, FINAL, ABSTRACT, VOLATILE, SYNCHRONIZED, TRANSIENT,
        STRICTFP, NATIVE, SEALED, OPEN, DATA, INLINE, INFIX, OPERATOR, SUSPEND
    }

    data class Annotation(val name: String, val properties: Map<String, String>)
}