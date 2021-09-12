package com.ericampire.design.factorymethod

/**
 * The abstract factory allow the creation of a family of object without specifying the
 * real class
 *
 * 1. We first create an interface for each family of object, and all classes for that family must
 * implement that interface and so on
 *
 * 2. We create an Abstract Factory that contains list of factory method for each family
 *
 * 3. Create concrete factory responsible for objects for the specific family
 */


/**
 * The [Button] interface represent the first family of object
 */
interface Button {}
class WindowsButton : Button {}
class LinuxButton : Button {}


/**
 * The [CheckBox] interface represent the second family of object
 */
interface CheckBox {}
class WindowsCheckBox : CheckBox {}
class LinuxCheckBox : CheckBox {}


/**
 * The [GuiFactory] interface is the abstract contains the list of all factory method
 * for each family
 */
interface GuiFactory {
  fun createButton(): Button
  fun createCheckBox(): CheckBox
}

/**
 * The [WindowsFactory] is responsible for creation of the components from the
 * windows family
 */
class WindowsFactory : GuiFactory {
  override fun createButton(): Button {
    return WindowsButton()
  }

  override fun createCheckBox(): CheckBox {
    return WindowsCheckBox()
  }
}

/**
 * The [LinuxFactory] is responsible for creation of the components from the
 * linux family
 */
class LinuxFactory : GuiFactory {
  override fun createButton(): Button {
    return LinuxButton()
  }

  override fun createCheckBox(): CheckBox {
    return LinuxCheckBox()
  }
}



class Client(private val factory: GuiFactory) {
  fun init() {
    val button: Button = factory.createButton()
    val checkBox: CheckBox = factory.createCheckBox()
  }
}