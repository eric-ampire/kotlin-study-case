package com.ericampire.kotlinstudycase.model.designpattern

import java.util.*

/**
 * Provide a way to access the element of an aggregate object semantically without
 * exposing its internal representation
 *
 * Instead of having your owr Iterator interface, you can used the existing one
 */

interface MyIterator {
    fun hasNext(): Boolean
    fun next(): Any
}

/**
 * All classes that will implement this interface will have a collection of items
 * that require a iterator
 *
 * The [createIterator] method expose a iterator that will allow the client access to
 * the elements of the aggregate object.
 */
interface Aggregate {
    fun createIterator(): MyIterator
}