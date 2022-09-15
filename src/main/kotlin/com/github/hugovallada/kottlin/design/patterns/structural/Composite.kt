package com.github.hugovallada.kottlin.design.patterns.structural

// Compose objects into tree structures
// Works when the core functionality can be represented as a tree
// Manipulate many objects as a single one

open class Equipment(
    open val price: Int,
    val name: String
)

open class Composite(name: String): Equipment(0, name) {
    private val equipments = ArrayList<Equipment>()

    override val price: Int
        get() = equipments.sumOf { it.price }

    fun add (equipment: Equipment) = apply {
        equipments.add(equipment)
    }
}

class Computer: Composite("PC")
class Processor: Equipment(1000, "Processor")
class HardDrive: Equipment(250, "Hard Drive")
class Memory: Composite("Memory")
class ROM: Equipment(100, "Read Only Memory")
class RAM: Equipment(75, "Random Access Memory")

fun main() {
    val memory = Memory()
    memory.add(ROM())
    memory.add(RAM())

    val pc = Computer()
    pc.add(Processor())
    pc.add(memory)
    pc.add(HardDrive())

    println("${pc.name} price: ${pc.price}")
}