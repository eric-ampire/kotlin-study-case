package com.ericampire.kotlinstudycase.model.designpattern

/**
 * Method Template Pattern define the skeleton of the algorithm in a methode, and
 * deferring some steps of the algorithms to the subclasses, Sub classes can provide
 * the implementation of some step of the algorithm without modifying the algo structure
 *
 * when we design with the Template Method Pattern, we’re telling subclasses,
 * “don’t call us, we’ll call you.”
 */

abstract class MyClass {

    /**
     * This is the template, it's define the structure of the algorithm, and as the
     * method is final, it can't be redefine by the sub-class
     *
     * Each method call inside the this method define the step of the algo
     */
    final fun algo() {
        stepO1()
        stepO2()
        stepO3()
        step04()
        if (hookMethod()) {
            step05()
        }
    }

    /**
     * Sub-classes can decide to override or not this methods or keep use the default
     * implementation
     */
    fun stepO1() {}
    fun stepO2() {}
    fun stepO3() {}

    /**
     * The hook method, is a method with a default implementation that each sub-class can override
     * to skip some steps of the algo, when the corresponding step is optional, if this method is not
     * overridden, the default behavior will be applied.
     *
     * This method is based on Hollywood principle, low level component doesn't have to call directly
     * high level components.
     */
    fun hookMethod(): Boolean {
        return true
    }

    /**
     * The [step04] and the [step05] is specific to each sub-class, that is why those
     * methods are declared as abstract and must be implemented by each sub-class
     */
    abstract fun step04()
    abstract fun step05()
}

/**
 * This class provide the implementation of the step 04 and 05, because those step
 * are more specific to each classes, but as the template method is final, the
 * structure of the algorithms is not going to change even tough each sub-class
 * can provide some implementations
 */
class Concrete01 : MyClass() {
    override fun step04() {
        TODO("Not yet implemented")
    }

    override fun step05() {
        TODO("Not yet implemented")
    }
}