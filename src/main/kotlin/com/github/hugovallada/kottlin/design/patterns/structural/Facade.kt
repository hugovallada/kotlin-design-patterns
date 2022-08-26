package com.github.hugovallada.kottlin.design.patterns.structural

// Simple Interface to a complex functionality
// Removes the need for complex object / memory management
// Simplifies the client implementation

class ComplexSystemStore(private val filePath: String) {
    private val cache: HashMap<String, String>

    init {
        println("Reading data from file: $filePath")
        cache = HashMap()
        // Read properties from file and put to cache
    }

    fun store(key: String, value: String) {
        cache[key] = value
    }

    fun read(key: String) = cache[key] ?: ""

    fun commit() = println("Storing cached data to file $filePath")
}

data class User(val login: String)

// Facade
class UserRepository {
    private val systemPreferences = ComplexSystemStore("/data/default.properties")

    fun save(user: User) {
        systemPreferences.store("USER_KEY", user.login)
        systemPreferences.commit()
    }

    fun findFirst(): User = User(systemPreferences.read("USER_KEY"))
}

fun main() {
    val user = User("hlz")
    val userRepo = UserRepository()

    userRepo.save(user)
    println(userRepo.findFirst())
}