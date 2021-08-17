package com.ericampire.kotlinstudycase.model.designpattern

/**
 * The decorator pattern attaches additional responsibilities to an object dynamically.
 * Decorators provide a flexible alternative to subclassing for extending functionality
 *
 * Decorators have the same supertype as the objects they decorate
 */

abstract class Beverage {
    protected val description: String = "Unknown description"

    abstract fun description(): String
    abstract fun cost(): Double
}

class Cappuccino : Beverage() {
    override fun description(): String {
        return "Cappuccino"
    }

    override fun cost(): Double {
        return 5.7
    }
}

class DarkRoast : Beverage() {
    override fun description(): String {
        return "Dark Roast"
    }

    override fun cost(): Double {
        return 3.7
    }
}

/**
 * Decorators have the same supertype as the objects they decorate
 * and must be the wrapper for the object that will be decorated
 */
abstract class CondimentDecorator : Beverage() {
    abstract val beverage: Beverage
}

class Espresso(override val beverage: Beverage) : CondimentDecorator() {

    override fun description(): String {
        return "${beverage.description()}, Espresso"
    }

    override fun cost(): Double {
        return 1.9 + beverage.cost()
    }
}

class HouseBlend(override val beverage: Beverage) : CondimentDecorator() {

    override fun description(): String {
        return "${beverage.description()}, House blend coffe"
    }

    override fun cost(): Double {
        return 0.9 + beverage.cost()
    }
}

fun main() {
    val simpleCoffee = DarkRoast()
    println("${simpleCoffee.description()}, cost : ${simpleCoffee.cost()}")

    val houseBlend = HouseBlend(simpleCoffee)
    println("${houseBlend.description()}, cost : ${houseBlend.cost()}")

    val anotherOne = Espresso(houseBlend)
    println("${anotherOne.description()}, cost : ${anotherOne.cost()}")
}