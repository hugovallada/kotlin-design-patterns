package com.github.hugovallada.kottlin.design.patterns.creational

// Usado quando a classe for ser chamada dentro do código java

class Pessoa private constructor(builder: PessoaBuilder) {
    var name: String? = null
    var age: Int? = null
    var employed: Boolean? = null

    class PessoaBuilder {
        private var name: String? = null
        private var age: Int? = null
        private var employed: Boolean? = null

        fun setName(name: String) = apply { this.name = name }
        fun setAge(age: Int) = apply { this.age = age }
        fun setEmployed(employed: Boolean) = apply { this.employed = employed }
        fun build() = Pessoa(this)

        fun getName() = name
        fun getAge() = age
        fun isEmployed() = employed
    }

    init {
        name = builder.getName()
        age = builder.getAge()
        employed = builder.isEmployed()
    }
}

fun main() {
    val pessoa = Pessoa.PessoaBuilder()
        .setName("Hugo")
        .setAge(20)
        .build()

    println(pessoa.name)
    println(pessoa.age)
}