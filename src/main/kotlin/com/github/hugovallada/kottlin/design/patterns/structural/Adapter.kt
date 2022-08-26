package com.github.hugovallada.kottlin.design.patterns.structural

// 3rd party functionality

data class DisplayDataType(val index: Float, val data: String)

class DataDisplay {
    fun displayData(data: DisplayDataType) {
        println("Data is displayed: ${data.index} - ${data.data}")
    }
}
// ----------------------------------

// Our code

data class DatabaseData(val position: Int, val amount: Int)

class DatabaseDataGenerator {
    fun generateData(): List<DatabaseData> {
        val list = arrayListOf<DatabaseData>()
        list.add(DatabaseData(2, 2))
        list.add(DatabaseData(3, 7))
        list.add(DatabaseData(4, 23))
        return list
    }
}

// Adapter to adapter between our code and the 3rd party functionality

interface DatabaseDataConverter {
    fun convertData(data: List<DatabaseData>): List<DisplayDataType>
}

class DataDisplayAdapter(val display: DataDisplay): DatabaseDataConverter {
    override fun convertData(data: List<DatabaseData>): List<DisplayDataType> {
        val returnList = arrayListOf<DisplayDataType>()

        for (datum in data) {
            val ddt = DisplayDataType(datum.position.toFloat(), datum.amount.toString())
            display.displayData(ddt)
            returnList.add(ddt)
        }
        return returnList
    }
}

fun main() {
    val generatedData = DatabaseDataGenerator().generateData()
    val adapter = DataDisplayAdapter(DataDisplay())

    with(adapter.convertData(generatedData)) {
        println(this)
    }
}