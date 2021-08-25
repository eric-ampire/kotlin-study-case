package com.ericampire.kotlinstudycase.model.designpattern

/**
 * The state pattern allow an object to alter its behavior when its internal state
 * change,
 *
 * The behavior of the object or the State machine is determined by the its current
 * state
 */


interface State {

    /**
     * Each state will have to implement this interface and provide a behavior by implementing
     * this methode, or others methods provided by the State interface
     */
    fun handler()
}

/**
 * Each state implement its own behavior,
 */
class StopState : State {
    override fun handler() {
        println("Stopping machine")
    }
}

class StartState : State {
    override fun handler() {
        println("Starting the machine")
    }
}

/**
 * The [Context] is the class that will going to change its behavior accordigly to its current
 * state, once the state be a sub-class of the State interface, its seems likes the [Context]
 * class will have different behavior
 *
 * This class can have a number of internal state, and actually the current state, the current
 * behavior is delegated to the current state.
 *
 * The different between the State pattern and Strategy pattern it that the [Context]
 * is responsible to transit from one state to another internally (behavior), in strategy pattern
 * the behavior is updated at runtime, outside of the [Context] class.
 */

class Context {
    private lateinit var currentState: State
    private val state01: State = StopState()
    private val state02: State = StartState()

    /**
     * The context will have to delegate its actions to the current state, and based on one
     * action to another to context can decide to update its internal state
     */
    fun doSomething() {
        currentState.handler()
    }

    /**
     * The [setState] method is private because the internal state of the context
     * can't be update outside of the Context class, in the Strategy pattern it's possible
     * to modifier the state or the behavior outside of the context
     */
    private fun setState(state: State) {
        currentState = state
    }
}

