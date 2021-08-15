package com.ericampire.kotlinstudycase.extension.test

import com.ericampire.kotlinstudycase.extension.*
import com.ericampire.kotlinstudycase.model.database.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.*
import java.sql.Connection
import java.sql.Savepoint

@ExtendWith(
    value = [
        DatabaseOperationExtension::class,
        ExecutionConditionExtension::class,
        UserDaoParameterResolverExtension::class,
        ExceptionHandlerExtension::class
    ]
)
class DatabaseTest(private val dao: UserDao) {

    @Test
    fun testDeleteUser() {
        val user = User(id = "5", name = "Jack Will")
        dao.save(user)
        dao.delete(user)
        assertNull(dao.findById("5"))
    }

    @Test
    fun testFindUser() {
        val user = User(id = "2", name = "Jack Will")
        dao.save(user)
        assertNotNull(dao.findById("2"))
    }

    @Test
    fun testSaveUser() {
        val user = User(id = "1", name = "Eric Ampire")
        dao.save(user)
        assertEquals("Eric Ampire", dao.findById("1")?.name)
    }

    @Test
    fun testSaveTwiceUser() {
        val user = User(id = "10", name = "Eric Ampire")
        assertThrows(InsertOnceException::class.java) {
            dao.save(user)
            dao.save(user)
        }
    }
}