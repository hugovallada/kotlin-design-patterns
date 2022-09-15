package com.github.hugovallada.kottlin.design.patterns.structural

import java.lang.IllegalStateException

// Proxy provides some caching functionally
// Provide some functionality before and/or after calling an object
// Similar to other design patterns
// Similar to facade, except the proxy has the same interface
// Similar to decorator, except the proxy manages the lifecycle of its object

interface Image {
    fun display()
}

class RealImage(private val fileName: String) : Image {
    override fun display() {
        println("RealImage: Displaying $fileName")
    }

    private fun loadFromDisk(fileName: String) {
        println("RealImage: Loading $fileName")
    }

    init {
        loadFromDisk(fileName)
    }
}

class ProxyImage(private val fileName: String): Image {
    private var realImage: RealImage? = null

    override fun display() {
        println("ProxyImage: Displaying $fileName")
        if (realImage == null) {
            realImage = RealImage(fileName)
        }

        realImage?.display() ?: throw IllegalStateException("")
    }
}

fun main() {
    val image = ProxyImage("image.jpg")
    // load image from disk
    image.display()

    // load  image from cache
    image.display()
}