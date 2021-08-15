package com.ericampire.kotlinstudycase.extension

import com.ericampire.kotlinstudycase.model.database.ConnectionManager
import com.ericampire.kotlinstudycase.model.database.UserDao
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.api.extension.ParameterContext
import org.junit.jupiter.api.extension.ParameterResolver

class UserDaoParameterResolverExtension : ParameterResolver {
    override fun supportsParameter(
        parameterContext: ParameterContext,
        extensionContext: ExtensionContext
    ): Boolean {
        return parameterContext.parameter.type.equals(UserDao::class.java)
    }

    override fun resolveParameter(
        parameterContext: ParameterContext,
        extensionContext: ExtensionContext
    ): Any {
        return UserDao(ConnectionManager.getConnection())
    }
}