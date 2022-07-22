package com.github.hugovallada.kottlin.design.patterns.creational

// Java Way
class SingletonJavaWay private constructor() {
    private object HOLDER {
        val INSTANCE = SingletonJavaWay()
    }

    companion object {
        val instance: SingletonJavaWay by lazy { HOLDER.INSTANCE }
    }
}

// Kotlin Way
object Singleton {}


object NetworkDriver {
    init {
        println("Initializing: $this")
    }

    fun log(): NetworkDriver = apply { println("Network driver: $this") }

}

fun main() {
    val networkDriver = NetworkDriver.log()
    val networkDriver2 = NetworkDriver.log()

    assert(networkDriver == networkDriver2)
}

