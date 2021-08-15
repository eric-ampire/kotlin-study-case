package com.ericampire.kotlinstudycase.model.database

import java.sql.Connection
import java.sql.DriverManager

object ConnectionManager {
    private lateinit var connection: Connection
    fun getConnection(): Connection {
        try {
            Class.forName("org.h2.Driver")
            connection = DriverManager.getConnection("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1", "sa", "sa")
            return connection
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }

    fun closeConnection() {
        if (this::connection.isInitialized) {
            try {
                connection.close()
            } catch (e: Exception) {
                throw RuntimeException(e)
            }
        }
    }
}