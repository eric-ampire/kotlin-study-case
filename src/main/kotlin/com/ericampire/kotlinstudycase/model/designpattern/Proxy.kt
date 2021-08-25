package com.ericampire.kotlinstudycase.model.designpattern

import java.rmi.Naming
import java.rmi.Remote
import java.rmi.server.UnicastRemoteObject

interface Service : Remote {
    fun sayHello(): String
}

class MyService : UnicastRemoteObject(), Service {
    val serialVersionUID = 2L

    override fun sayHello(): String {
        return "Salut les amie"
    }
}

fun main() {
    try {
        val service = MyService()
        Naming.rebind("myservice", service)
        startClient()
    } catch (e: Exception) {
        println(e.localizedMessage)
    }
}

fun startClient() {
    val service = Naming.lookup("rmi://127.0.0.1/myservice") as Service
    println(service::sayHello)
}