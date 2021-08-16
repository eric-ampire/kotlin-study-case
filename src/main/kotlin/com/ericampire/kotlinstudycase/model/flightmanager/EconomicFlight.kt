package com.ericampire.kotlinstudycase.model.flightmanager

class EconomicFlight(id: String) : Flight(id = id) {
    override fun addPassenger(passenger: Passenger): Boolean {
        return passengers.add(passenger)
    }

    override fun removePassenger(passenger: Passenger): Boolean {
        return if (!passenger.vip) passengers.remove(passenger) else false
    }
}