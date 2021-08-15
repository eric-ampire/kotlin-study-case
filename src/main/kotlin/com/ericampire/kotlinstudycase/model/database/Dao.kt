package com.ericampire.kotlinstudycase.model.database

interface Dao<T> {
    fun save(item: T)
    fun delete(item: T)
    fun findById(id: String): T?
}