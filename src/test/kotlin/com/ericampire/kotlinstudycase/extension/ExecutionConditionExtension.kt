package com.ericampire.kotlinstudycase.extension

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ConditionEvaluationResult
import org.junit.jupiter.api.extension.ExecutionCondition
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.extension.ExtensionContext
import java.util.*
import kotlin.test.assertEquals

class ExecutionConditionExtension : ExecutionCondition {
    override fun evaluateExecutionCondition(context: ExtensionContext): ConditionEvaluationResult {
        val properties = Properties()
        try {
            properties.load(this::class.java.classLoader.getResourceAsStream("context.properties"))
            val executionContext = properties.getProperty("context")

            return if (executionContext.contentEquals("none", true)) {
                ConditionEvaluationResult.disabled("Test is disable inside none context")
            } else {
                ConditionEvaluationResult.enabled("Test enable on $executionContext context")
            }
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }
}