package com.github.hugovallada.kottlin.design.patterns.creational

interface DataSource

class DatabaseDataSource : DataSource

class NetworkDataSource : DataSource

abstract class DataSourceFactory {
    abstract fun makeDataSource(): DataSource

    companion object {
        inline fun <reified T : DataSource> createFactory(): DataSourceFactory = when (T::class) {
            DatabaseDataSource::class -> DatabaseFactory()
            NetworkDataSource::class -> NetworkFactory()
            else -> throw IllegalStateException()
        }
    }
}

class NetworkFactory : DataSourceFactory() {
    override fun makeDataSource(): DataSource = NetworkDataSource()
}

class DatabaseFactory : DataSourceFactory() {
    override fun makeDataSource(): DataSource = DatabaseDataSource()
}

fun main() {
    val dataSourceFactory = DataSourceFactory.createFactory<DatabaseDataSource>()
    val dataSource = dataSourceFactory.makeDataSource()

    println("Created datasource: $dataSource")
    assert(dataSource is DatabaseDataSource)
}