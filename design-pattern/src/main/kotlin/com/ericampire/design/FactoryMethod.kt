package com.ericampire.design

/**
 * This pattern make easy the creation of different object that have the same parent, in one side we
 * have the class hierarchy of class that must be created, in another side we have a factory responsible for
 * the creation of the class of a specific type
 *
 * The pattern is very useful when you don't know beforehand the exact type of object you code should
 * work with, it can also be used when you want the user to extend your lib or framework with its internal
 * components
 *
 * The pattern separate the creation of the object from the place the actual object is used.
 */


/**
 * Here the class hierarchy
 */
interface Payment {
  fun makePayment()
}

class Mpsa : Payment {
  override fun makePayment() {
    println("I have pay with ${this::class.simpleName}")
  }
}

class AirtelMoney : Payment {
  override fun makePayment() {
    println("I have pay with ${this::class.simpleName}")
  }
}

/**
 * Factories responsible for creation of a class of a specific
 * type of class
 */
interface PaymentFactory {
  fun createPayment(): Payment
  fun makePayment() {
    val payment: Payment = createPayment()
    payment.makePayment()
  }
}

class AirtelMoneyFactory : PaymentFactory {
  override fun createPayment(): Payment {
    return AirtelMoney()
  }
}

class MpsaFactory : PaymentFactory {
  override fun createPayment(): Payment {
    return Mpsa()
  }
}

class PaymentApplication {

  private fun getProvider(): String {
    return if (System.currentTimeMillis().toInt() == 1) {
      "airtel"
    } else {
      "vodacom"
    }
  }

  fun init() {
    val provider = getProvider()
    val paymentFactory: PaymentFactory = when (provider) {
      "airtel" -> AirtelMoneyFactory()
      "vodacom" -> MpsaFactory()
      else -> throw IllegalArgumentException("Not supported yet")
    }

    paymentFactory.makePayment()
  }
}

