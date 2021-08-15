package com.ericampire.kotlinstudycase.extension

import com.ericampire.kotlinstudycase.model.database.ConnectionManager
import com.ericampire.kotlinstudycase.model.database.TableManager
import com.ericampire.kotlinstudycase.model.database.User
import com.ericampire.kotlinstudycase.model.database.UserDao
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.*
import java.sql.Connection
import java.sql.Savepoint

class DatabaseOperationExtension : BeforeAllCallback,
    AfterAllCallback, BeforeEachCallback, AfterEachCallback {

    private lateinit var savepoint: Savepoint
    private lateinit var connection: Connection

    override fun beforeAll(context: ExtensionContext?) {
        // Database init
        connection = ConnectionManager.getConnection()
        TableManager.dropTable(connection)
        TableManager.createTable(connection)
    }

    override fun afterAll(context: ExtensionContext?) {
        // Close connection
        ConnectionManager.closeConnection()
    }

    override fun beforeEach(context: ExtensionContext?) {
        connection.autoCommit = false
        savepoint = connection.setSavepoint("save-point")
    }

    override fun afterEach(context: ExtensionContext?) {
        connection.rollback(savepoint)
    }
}

