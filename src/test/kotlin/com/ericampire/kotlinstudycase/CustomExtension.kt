package com.ericampire.kotlinstudycase

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.AfterEachCallback
import org.junit.jupiter.api.extension.BeforeEachCallback
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.extension.ExtensionContext

class CustomExtension : BeforeEachCallback, AfterEachCallback {
    override fun beforeEach(context: ExtensionContext) {
        println("${this::class.simpleName} : ${context.displayName} stated")
    }

    override fun afterEach(context: ExtensionContext) {
        println("${this::class.simpleName} : ${context.displayName} stated")
    }
}

@ExtendWith(CustomExtension::class)
class CustomExtensionText {

    @Test
    fun myCustomText() {

    }
}