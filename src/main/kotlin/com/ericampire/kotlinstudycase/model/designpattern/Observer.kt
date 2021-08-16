package com.ericampire.kotlinstudycase.model.designpattern

interface Observable {
    fun notifier()
    fun addObserver(observer: Observer)
    fun removeObserver(observer: Observer)
}

interface Observer {
    fun update()
}

/**
 * The implementation
 */

class LiveDataObserver(private val observable: LiveDataObservable) : Observer {

    init {
        observable.addObserver(this)
    }

    override fun update() {
        // The observer get the information he needs
        println("There is a new data ${observable.state}")
    }
}

class LiveDataObservable : Observable {

    private val observers: MutableSet<Observer> = mutableSetOf()
    var state: String = ""
        private set

    override fun notifier() {
        for (observer in observers) {
            // Instead of pushing all the state to the observer, the observer must contact himself the
            // to get information they wand
            observer.update()
        }
    }

    override fun addObserver(observer: Observer) {
        observers.add(observer)
    }

    override fun removeObserver(observer: Observer) {
        observers.remove(observer)
    }

    fun setState(state: String) {
        this.state = state
        notifier()
    }
}

/**
 * Testing
 */

fun main() {
    val observable = LiveDataObservable()
    val observer1 = LiveDataObserver(observable)
    val observer2 = LiveDataObserver(observable)

    observable.setState("New state")
    val observer3 = LiveDataObserver(observable)
}