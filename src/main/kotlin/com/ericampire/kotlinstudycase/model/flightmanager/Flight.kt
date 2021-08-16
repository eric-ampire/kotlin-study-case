package com.ericampire.kotlinstudycase.model.flightmanager

abstract class Flight(val id: String) {

    protected val passengers: MutableSet<Passenger> = mutableSetOf()

    val passengerList: Set<Passenger>
        get() = passengers

    abstract fun addPassenger(passenger: Passenger): Boolean

    abstract fun removePassenger(passenger: Passenger): Boolean
}