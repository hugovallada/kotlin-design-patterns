package com.github.hugovallada.kottlin.design.patterns.structural

// Attach new behaviour to an object
// Without altering existing code
// Overriding behaviour

interface CoffeeMachine {
    fun makeSmallCoffee()
    fun makeLargeCoffee()
}

class NormalCoffeeMachine : CoffeeMachine {
    override fun makeSmallCoffee() {
        println("Normal coffee machine: Making small coffee")
    }

    override fun makeLargeCoffee() {
        println("Normal coffee machine: Making large coffee")
    }
}

//Decorator
class EnhancedCoffeeMachine(private val coffeeMachine: CoffeeMachine): CoffeeMachine by coffeeMachine {
    // overriding behavior
    override fun makeLargeCoffee() {
        println("Enhanced coffee machine: Making large coffee")
    }

    // extending behavior
    fun makeMilkCoffee() {
        println("Enhanced coffee machine: Making milk coffee")
        coffeeMachine.makeSmallCoffee()
        println("Enhanced coffee machine: Adding milk")
    }
}


fun main() {
    val normalCoffeeMachine = NormalCoffeeMachine()
    val enhancedCoffeeMachine = EnhancedCoffeeMachine(normalCoffeeMachine)

    enhancedCoffeeMachine.makeSmallCoffee()
    enhancedCoffeeMachine.makeLargeCoffee()
    enhancedCoffeeMachine.makeMilkCoffee()
}