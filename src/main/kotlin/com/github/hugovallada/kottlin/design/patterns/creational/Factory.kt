package com.github.hugovallada.kottlin.design.patterns.creational

sealed class Country {
    object Canada: Country()
    object Poland : Country()
}

object Spain: Country()
class Greece(val someProperty: String): Country()
data class USA(val someProperty: String): Country()

data class Currency(val code: String)

object CurrencyFactory {
    fun currencyForCountry(country: Country): Currency = when(country) {
        is Country.Canada -> Currency("CAD")
        is Greece -> Currency("EUR")
        is Country.Poland -> Currency("EUR")
        is Spain -> Currency("EUR")
        is USA -> Currency("USD")
    }
}

fun main() {
    val greekCurrency = CurrencyFactory.currencyForCountry(Greece("prop"))
    println("Greek currency: $greekCurrency")

    val usaCurrency = CurrencyFactory.currencyForCountry(USA("prop"))
    println("USA currency: $usaCurrency")
}