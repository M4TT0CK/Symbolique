package com.jamesnthomas.symbolique.core.types

/**
 * Represents a kind of type within the Symbolique system. This interface serves as a foundation
 * for all types, providing basic properties essential for type identification and management.
 */
interface Type {
    /**
     * The name of the type, which can be used for identification, debugging, and code generation.
     */
    val name: String

    /**
     * An optional index for the type, useful in certain type management and code generation contexts.
     * A value of -1 indicates that the type does not have an assigned index.
     */
    val typeIndex: Int
        get() = -1 // Default implementation, indicating no index by default.
}