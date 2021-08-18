package com.ericampire.kotlinstudycase.model.designpattern

/**
 *
 */
class Light {
    fun on() {
        println("On")
    }
    fun off() {
        println("Off")
    }
}

/**
 * This pattern encapsulate the request, The client will have just to call execute method
 * and has the command encapsulate the [Command] it will execute the necessary operation
 * on the receiver, it can be one or more actions
 */

interface Command {
    fun execute()
}

/**
 *
 */
class LightOnCommand(private val light: Light) : Command {
    override fun execute() {
        light.on()
    }
}

/**
 *
 */
class LightOffCommand(private val light: Light) : Command {
    override fun execute() {
        light.off()
    }
}

/**
 * The client is responsible of creating the concrete command and set its
 * Receiver, the Receiver it's the object in which the action will be applied
 *
 * The receive know exactly what to do
 */
fun main() {

}