package com.ericampire.kotlinstudycase.model.designpattern


/**
 * This is the first family of object that we can create
 */
abstract class Button

class MacButton : Button()
class WindowsButton : Button()
class LinuxButton : Button()

/**
 * This is the second family of components that we can create
 */

abstract class CheckBox

class MacCheckBox : CheckBox()
class WindowsCheckBox : CheckBox()
class LinuxCheckBox : CheckBox()




/**
 * The abstract factory provide an interface for creating a family or dependent objects,
 * without specifying their concrete class
 *
 * The idea is to have several implementation of factories that allow us to create different
 * objects based on different context
 */

interface GuiFactory {

    /**
     * We can have one or more family of [Button]
     */
    fun createButton(): Button

    /**
     * We can have one or more family of [CheckBox]
     */
    fun createCheckBox(): CheckBox
}

/**
 * The concrete implementation of the abstract factory is responsible a creating the concrete Object
 *
 * Each factory is responsible of creating of one family
 */
class WindowFactory : GuiFactory {
    override fun createButton(): Button {
        return WindowsButton()
    }

    override fun createCheckBox(): CheckBox {
        return WindowsCheckBox()
    }
}

class MacFactory : GuiFactory {
    override fun createButton(): Button {
        return MacButton()
    }

    override fun createCheckBox(): CheckBox {
        return MacCheckBox()
    }
}

class LinuxFactory : GuiFactory {
    override fun createButton(): Button {
        return LinuxButton()
    }

    override fun createCheckBox(): CheckBox {
        return LinuxCheckBox()
    }
}

/**
 * The client is the application that will going to use the factory in order
 * to create different component
 */

class App(val factory: GuiFactory) {

    fun render() {
        val button: Button = factory.createButton()
        val checkBox: CheckBox = factory.createCheckBox()
    }
}

enum class Os {
    Windows, Linux, Mac
}

fun main() {
    val config = Os.Linux

    val app = when(config) {
        Os.Windows -> App(factory = WindowFactory())
        Os.Linux -> App(factory = LinuxFactory())
        Os.Mac -> App(factory = MacFactory())
    }
    app.render()
}
