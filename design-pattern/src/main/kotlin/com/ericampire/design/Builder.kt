package com.ericampire.design

import java.util.*

/**
 * The builder pattern allow you to create a complex object step by step
 * It allows you to create different type and representation af an object using the
 * same constructor
 *
 * This pattern extract the creation logic of an object outside it
 */

class Engine
class Transmission
class TripComputer

data class Car(
    val model: String = "",
    val mark: String = "",
    val seats: Int = 0,
    val engine: Engine? = null,
    val transmission: Transmission? = null,
    val tripComputer: TripComputer? = null,
) {
  class AutomaticCarBuilder : CarBuilder<Car> {

    private lateinit var car: Car

    init {
      reset()
    }

    override fun reset() {
      car = Car()
    }

    override fun setSeats(number: Int): CarBuilder<Car> = apply {
      this.car = car.copy(seats = number)
    }

    override fun setMark(mark: String): CarBuilder<Car> = apply {
      this.car = car.copy(mark = mark)
    }

    override fun setModel(model: String): CarBuilder<Car> = apply {
      this.car = car.copy(model = model)
    }

    override fun setEngine(engine: Engine): CarBuilder<Car> = apply {
      this.car = car.copy(engine = engine)
    }

    override fun setTripComputer(computer: TripComputer): CarBuilder<Car> = apply {
      this.car = car.copy(tripComputer = computer)
    }

    override fun setTransmission(transmission: Transmission): CarBuilder<Car> = apply {
      this.car = car.copy(transmission = transmission)
    }

    override fun build(): Car {
      val car = this.car
      reset()
      return car
    }
  }
}

interface CarBuilder<T> {
  fun reset()
  fun setSeats(number: Int): CarBuilder<T>
  fun setMark(mark: String): CarBuilder<T>
  fun setModel(model: String): CarBuilder<T>
  fun setEngine(engine: Engine): CarBuilder<T>
  fun setTripComputer(computer: TripComputer): CarBuilder<T>
  fun setTransmission(transmission: Transmission): CarBuilder<T>
  fun build(): T
}

fun main(args: Array<String>) {

  val builder: CarBuilder<Car> = Car.AutomaticCarBuilder()
      .setEngine(Engine())
      .setMark("Toyota")
      .setModel("Mark II")
      .setSeats(4)

  val car = builder.build()
  println(car)
}