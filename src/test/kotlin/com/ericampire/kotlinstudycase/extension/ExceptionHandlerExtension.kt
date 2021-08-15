package com.ericampire.kotlinstudycase.extension

import com.ericampire.kotlinstudycase.model.database.InsertOnceException
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler
import java.util.logging.Logger

class ExceptionHandlerExtension : TestExecutionExceptionHandler {
    private val logger = Logger.getLogger(this.javaClass.simpleName)

    override fun handleTestExecutionException(context: ExtensionContext?, throwable: Throwable) {
        if (throwable is InsertOnceException) {
            logger.severe("User exists : ${throwable.message}")
            return
        }
        throw throwable
    }
}