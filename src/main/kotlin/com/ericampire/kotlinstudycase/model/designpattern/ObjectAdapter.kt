package com.ericampire.kotlinstudycase.model.designpattern

/**
 * Convert an Interface of a class into an another interface that the client
 * expect,
 *
 * Ex: The adapter must implement the interface compatible with client, and must
 * encapsulate the object that must be adapted through composition, and this object must
 * delegate his actions to the adapter.
 *
 * It's allow two classes to work together even though they wasn't compatible
 */

interface Shape {
    fun somethingRelatedToShare()
}

class CircleToy {
    fun surface() {

    }
}

class SquareToy : Shape {
    override fun somethingRelatedToShare() {
        TODO("Not yet implemented")
    }
}

class Appli(shape: Shape) {

}

class ShapeAdapter(
    private val circle: CircleToy
) : Shape {

    /**
     * Delegate all the actions of the shape to the circle
     */
    override fun somethingRelatedToShare() {
        circle.surface()
    }
}

fun main() {
    val circle = CircleToy()
    val adapter = ShapeAdapter(circle)

    Appli(adapter)
}

// Todo: What is there weren't the Shape interface
// Todo: What if the SquareToy class wasn't extendable (final)