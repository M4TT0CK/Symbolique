package com.jamesnthomas.symbolique.core.scopes

import com.jamesnthomas.symbolique.core.symbols.Symbol

/**
 * Represents a scope within a programming language, which is a context
 * where symbols are defined and exist. Scopes can be hierarchical, allowing
 * for symbols to be organized in nested structures such as classes, functions,
 * and blocks.
 */
interface Scope {
    /** The name of the scope, useful for named scopes like functions or classes. */
    val name: String

    /** The scope that lexically encloses this one, or null if this is a top-level scope. */
    var enclosingScope: Scope?

    /**
     * Adds a symbol to this scope.
     *
     * @param symbol The symbol to be defined within this scope.
     */
    fun define(symbol: Symbol) // Consider using a Result type for Kotlin-style error handling.

    /**
     * Attempts to resolve a symbol by name, starting in this scope and
     * progressing up the enclosing scopes.
     *
     * @param name The name of the symbol to resolve.
     * @return The resolved Symbol, or null if not found.
     */
    fun resolve(name: String): Symbol?

    /**
     * Retrieves a symbol defined directly within this scope (does not search enclosing scopes).
     *
     * @param name The name of the symbol to retrieve.
     * @return The Symbol if found, or null otherwise.
     */
    fun getSymbol(name: String): Symbol?

    /**
     * Adds a nested scope. This is useful for creating hierarchical structures
     * of scopes, such as a new block within a function.
     *
     * @param scope The Scope to be nested within this one.
     */
    fun addNestedScope(scope: Scope)

    /** A list of scopes that are directly nested within this scope. */
    val nestedScopes: List<Scope>

    /**
     * A path from this scope to the root scope, inclusive.
     * Useful for understanding the hierarchical context of a scope.
     */
    val enclosingPathToRoot: List<Scope>

    /**
     * All symbols that represent scopes (like classes or functions)
     * directly nested within this scope, in insertion order.
     */
    val nestedScopedSymbols: List<Scope>

    /** All symbols defined directly within this scope, in insertion order. */
    val symbols: List<Symbol>

    /**
     * Recursively collects all symbols from this scope and all nested scopes,
     * in insertion order for each scope.
     */
    val allSymbols: List<Symbol>

    /** The names of all symbols directly within this scope. */
    val symbolNames: Set<String>

    /** The number of symbols directly defined in this scope. */
    val numberOfSymbols: Int

    /**
     * Constructs a string representation of the scope hierarchy,
     * using a specified separator between scope names.
     *
     * @param separator The separator to use between scope names.
     * @return A string representing the qualified scope name path.
     */
    fun toQualifierString(separator: String = "."): String
}