package com.github.hugovallada.kottlin.design.patterns.creational

// Useful for memory management
// Porque manter um objeto pesado na memória se vc não precisa.

// Inicie um resource quando é preciso, não quando é declarado

// Lazy vs Eager -> Eager: Define and Instantiate. Lazy -> Define, but instantiate when you will use.

/* Kotlin has built in lazy initialization
*   by lazy -> only be used with val
*   lateinit -> only use with var. Crash if not inatialized before use
*/

class Value {
    val values: String = "V"
}

class WindowByLazy {
    val value by lazy { getValue() }

    fun show() {
        println("By Lazy: ${value.values}")
    }
}

class WindowLateInit {
    lateinit var value: Value

    fun show(){
        value = getValue()
        println("LateInit ${value.values}")
    }
}

fun getValue() = Value()

fun main() {
    WindowByLazy().run {
        show()
    }

    WindowLateInit().run {
        show()
    }
}