package com.ericampire.kotlinstudycase.extension.test

import com.ericampire.kotlinstudycase.extension.ExecutionConditionExtension
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ConditionEvaluationResult
import org.junit.jupiter.api.extension.ExecutionCondition
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.extension.ExtensionContext
import java.util.*
import kotlin.test.assertEquals

@ExtendWith(ExecutionConditionExtension::class)
class ConditionalExecutionTest {

    @Test
    fun testSomethingHere() {
        val expected = "some expectation"
        assertEquals(expected, "some expectation")
    }
}