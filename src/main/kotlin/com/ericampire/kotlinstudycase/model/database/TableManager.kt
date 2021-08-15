package com.ericampire.kotlinstudycase.model.database

import java.sql.Connection

object TableManager {
    fun dropTable(connection: Connection) {
        val query = """DROP TABLE IF EXISTS USERS;"""
        executeStatement(connection, query)
    }

    fun createTable(connection: Connection) {
        val query = """CREATE TABLE IF NOT EXISTS USERS(ID VARCHAR(50), NAME VARCHAR(50));"""
        executeStatement(connection, query)
    }

    private fun executeStatement(connection: Connection, query: String) {
        try {
            val statement = connection.prepareStatement(query)
            statement.executeUpdate()
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }
}