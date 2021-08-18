package com.ericampire.kotlinstudycase.model.designpattern

import java.lang.RuntimeException

/**
 * The factory method pattern define an interface for creating an object, but lets subclasses decide which class
 * to instantiate. Factory Methods a class defer instantiation to subclasses
 *
 * The idea is to encapsulate the instantiation of concrete types
 */

interface Product {
    val name: String
    val price: Double
}

/**
 * The creator class, contain all the implementation for all the methods
 * ot manipulate the product except for the factory method.
 */

interface ProductFactory {

    // This abstract factory method will be responsible of creating the product, but as it's abstract
    // It'll be the responsibility of the concrete factory that will implement this method to
    // Decide which concrete product will we created.

    // A factory with method with a parameter is called parameterized factory method
    fun createProduct(): Product


    fun orderProduct(color: String): Product {
        val product = createProduct()
        // Some operations on the product
        // And some others operations
        return product
    }
}

/**
 * Sample this is the class that we want to create
 */
abstract class Pizza {
    abstract fun preparer()
    abstract fun cuire()
    abstract fun couper()
    abstract fun emballer()
}

class PizzaFromageStyleParis : Pizza() {
    override fun preparer() {
        println("Preparation 3 .6min")
    }

    override fun cuire() {
        println("Cuisson 35,5 min")
    }

    override fun couper() {
        println("Couper en rond")
    }

    override fun emballer() {
        println("Puis on emballe")
    }
}

class PizzaFruitStyleParis : Pizza() {
    override fun preparer() {
        println("Preparation 35 min")
    }

    override fun cuire() {
        println("Cuisson 33,5 min")
    }

    override fun couper() {
        println("Couper en carrer carrer")
    }

    override fun emballer() {
        println("Puis on emballe")
    }
}

class PizzaFromageStyleLile : Pizza() {
    override fun preparer() {
        println("Preparation 5 min")
    }

    override fun cuire() {
        println("Cuisson 5,5 min")
    }

    override fun couper() {
        println("Couper en triangle")
    }

    override fun emballer() {
        println("Puis on emballe")
    }
}

class PizzaFruitStyleLile : Pizza() {
    override fun preparer() {
        println("Preparation 3 min")
    }

    override fun cuire() {
        println("Cuisson 3,5 min")
    }

    override fun couper() {
        println("Couper en carrer")
    }

    override fun emballer() {
        println("Puis on emballe")
    }
}


/**
 * This is the Factory that need to create the [Pizza] instance
 */
abstract class PizzeriaFactory {
    fun commanderPizza(type: String): Pizza {
        val pizza = creezPizza(type)
        pizza.preparer()
        pizza.cuire()
        pizza.couper()
        pizza.emballer()
        return pizza
    }

    // This is the factory method responsible of crating the [Pizza] instance
    abstract fun creezPizza(type: String): Pizza
}

class PizzeriaStyleParisFactory : PizzeriaFactory() {
    override fun creezPizza(type: String): Pizza {
        return when(type) {
            "fruit" -> PizzaFruitStyleParis()
            "fromage" -> PizzaFromageStyleParis()
            else -> throw RuntimeException()
        }
    }
}

class PizzeriaStyleLileFactory : PizzeriaFactory() {
    override fun creezPizza(type: String): Pizza {
        return when(type) {
            "fruit" -> PizzaFruitStyleLile()
            "fromage" -> PizzaFromageStyleLile()
            else -> throw RuntimeException()
        }
    }
}

fun main() {
    val factory1 = PizzeriaStyleLileFactory()
    val factory2 = PizzeriaStyleParisFactory()

    val pizzaFromage: Pizza = factory1.commanderPizza("fromage")
    val pizzaFruit: Pizza = factory2.commanderPizza("fruit")
}