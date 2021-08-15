package com.ericampire.kotlinstudycase.model.database

class InsertOnceException(
    override val message: String,
    val user: User,
) : Exception(message)