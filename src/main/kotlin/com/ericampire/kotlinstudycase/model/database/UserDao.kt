package com.ericampire.kotlinstudycase.model.database

import java.sql.Connection


data class User(val id: String, val name: String)


class UserDao(
    private val connection: Connection
) : Dao<User> {
    override fun save(item: User) {
        val query = "INSERT INTO USERS(ID, NAME) VALUES (?, ?)"
        val user = findById(item.id)
        if (user != null) {
            throw InsertOnceException("User with id : ${user.id} already exists !!", user)
        }
        try {
            connection.prepareStatement(query).apply {
                setString(1, item.id)
                setString(2, item.name)
                executeUpdate()
            }
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }

    override fun findById(id: String): User? {
        val query = "SELECT * FROM USERS WHERE ID = ?"
        var user: User? = null
        try {
            val statement = connection.prepareStatement(query).apply {
                setString(1, id)
            }
            val result = statement.executeQuery()
            if(result.next()) {
                user = User(result.getString(1), result.getString(2))
            }
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
        return user
    }

    override fun delete(item: User) {
        val query = "DELETE FROM USERS WHERE ID = ?"
        try {
            connection.prepareStatement(query).apply {
                setString(1, item.id)
                executeUpdate()
            }
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }
}