package com.ericampire.kotlinstudycase.model.designpattern

/**
 * Here we use composition instead of inheritance, The strategy pattern lets algo to
 * Vary independently from the client that use it
 *
 * Here it's possible to update the behavior of the [Duck] class without modifying it
 */
abstract class Duck {
    private var flyBehavior: FlyBehavior
    private var quackBehavior: QuackBehavior

    init {
        flyBehavior = FlyWithWing()
        quackBehavior = Quack()
    }

    fun setFlyBehavior(flyBehavior: FlyBehavior) {
        this.flyBehavior = flyBehavior
    }

    fun setQuackBehavior(quackBehavior: QuackBehavior) {
        this.quackBehavior = quackBehavior
    }

    fun performFly() {
        flyBehavior.fly()
    }

    fun performQuack() {
        quackBehavior.quack()
    }
}

class RubberDuck : Duck() {
}

// Defining the first family of algo
interface FlyBehavior {
    fun fly()
}


/**
 * Defining the second family of algo
 */
interface QuackBehavior {
    fun quack()
}

// Fly Algo
class FlyWithWing : FlyBehavior {
    override fun fly() {
        println("I can fly")
    }
}

class FlyNoWay : FlyBehavior {
    override fun fly() {
        println("I can't fly")
    }
}

// Quack Algo
class Quack : QuackBehavior {
    override fun quack() {
        println("Quack !!")
    }
}

class MuteQuack : QuackBehavior {
    override fun quack() {
        println("Silence")
    }
}

fun main() {
    val duck: Duck = RubberDuck()
    duck.performFly()

    // Update the behavior at runtime
    duck.setFlyBehavior(FlyNoWay())
    duck.performFly()
}