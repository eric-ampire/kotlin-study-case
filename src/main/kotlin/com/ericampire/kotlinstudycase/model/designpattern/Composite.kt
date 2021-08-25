package com.ericampire.kotlinstudycase.model.designpattern

/**
 * The Composite Pattern allows you to compose objects into tree structures to
 * represent part-whole hierarchies. Composite lets clients treat individual objects and
 * compositions of objects uniformly.
 */

interface MenuComponent {
    fun add(menuItem: MenuComponent) {

    }

    fun remove(menuItem: MenuComponent) {

    }

    fun getChild(index: Int): MenuComponent {
        TODO()
    }

    fun getName(): String {
        TODO()
    }

    fun getDescription() : String {
        TODO()
    }

    fun getPrice(): Double {
        TODO()
    }

    fun print() {
        TODO()
    }
}

class MenuItem(
    val mname: String,
    val mprice: Double,
    val mdescription: String
): MenuComponent {
    override fun getDescription(): String {
        return mdescription
    }

    override fun getPrice(): Double {
        return mprice
    }

    override fun getName(): String {
        return mname
    }

    override fun print() {
        ""
    }
}

class Menu(

) : MenuComponent {

    private val menuComponent: MutableList<MenuComponent> = mutableListOf()

    override fun add(menuItem: MenuComponent) {
        menuItem.add(menuItem)
    }

    override fun remove(menuItem: MenuComponent) {
        menuItem.remove(menuItem)
    }

    override fun getChild(index: Int): MenuComponent {
        return menuComponent[index]
    }

    override fun print() {
        print("Name")
        for (menu in menuComponent) {
            menu.print()
        }
    }
}