package com.ericampire.kotlinstudycase.model.designpattern

/**
 * Provide a unified interface to a set of interface in a subsystem.
 * Facade defines a higher-lever interface that makes sub-system easier to use
 *
 * The facade [HomeTheaterFacade] takes all component through composition and
 * provide a simplified version of the system
 */

class HomeTheaterFacade(
    private val lightStud: LightStud,
    private val tuner: Tuner,
    private val amplifier: Amplifier
) {
    fun on() {
        lightStud.on()
        tuner.on()
        amplifier.on()
    }

    fun off() {

    }
}

/**
 * When we have a system with a lot of components, we can use a Facade to simplifier the
 * sub-system
 */
class LightStud {
    fun on() {
        println("One")
    }
}

class Tuner {
    fun on() {
        println("One")
    }
}

class Amplifier {
    fun on() {
        println("One")
    }
}