package com.github.hugovallada.kottlin.design.patterns.structural

interface Device {
    var volume: Int

    fun getName(): String
}

class Radio(override var volume: Int = 0) : Device {
    override fun getName() = "Radio $this"
}

class TV(override var volume: Int = 0): Device {
    override fun getName() = "TV $this"
}

interface Remote {
    fun volumeUp()
    fun volumeDown()
}

class BasicRemote(val device: Device): Remote {
    override fun volumeUp() {
        device.volume++
        println("Current volume of ${device.getName()}: ${device.volume}")
    }

    override fun volumeDown() {
        if (device.volume > 0) device.volume--

        println("Current volume of ${device.getName()}: ${device.volume}")
    }
}

fun main() {
    val tv = TV()
    val radio = Radio()

    val tvRemote = BasicRemote(tv)
    val radioRemote = BasicRemote(radio)

    tvRemote.volumeUp()
    tvRemote.volumeUp()
    tvRemote.volumeDown()

    radioRemote.volumeDown()
}