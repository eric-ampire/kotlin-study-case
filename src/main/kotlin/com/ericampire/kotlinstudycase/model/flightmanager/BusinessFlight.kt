package com.ericampire.kotlinstudycase.model.flightmanager

class BusinessFlight(id: String) : Flight(id = id) {
    override fun addPassenger(passenger: Passenger): Boolean {
        return if (passenger.vip) passengers.add(passenger)
        else false
    }

    override fun removePassenger(passenger: Passenger): Boolean {
        return false
    }
}