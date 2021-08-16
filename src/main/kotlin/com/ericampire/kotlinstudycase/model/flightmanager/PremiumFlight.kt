package com.ericampire.kotlinstudycase.model.flightmanager

class PremiumFlight(id: String) : Flight(id = id) {
    override fun addPassenger(passenger: Passenger): Boolean {
        return if (passenger.vip) passengers.add(passenger) else false
    }

    override fun removePassenger(passenger: Passenger): Boolean {
        return passengers.remove(passenger)
    }
}