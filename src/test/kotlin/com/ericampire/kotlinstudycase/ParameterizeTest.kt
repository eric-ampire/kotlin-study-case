package com.ericampire.kotlinstudycase

import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import kotlin.test.assertFalse

class ParameterizeTest {


    // Todo: Test with value source

    fun checkWord() {

    }

    // Todo: Test with enum source
    fun checkWordfd() {

    }

    // Todo: Test with CSV source
    fun checkWordfdfdfd() {

    }

    // Todo: Test with CSV File source
    fun checkWordfdfdfdsdf() {

    }
}

class TestFactory {

    @TestFactory
    fun sdf(): List<DynamicTest> {
        return listOf(
            DynamicTest.dynamicTest("aaadfd") { assertFalse(false) },
            DynamicTest.dynamicTest("dfdd") { assertFalse(false) }
        )
    }
}

class HamcrestTest {
    fun sdf() {

    }
}