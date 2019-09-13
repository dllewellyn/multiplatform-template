package com.auto.synch.database

import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.sqlite.driver.JdbcSqliteDriver
import com.squareup.sqldelight.sqlite.driver.JdbcSqliteDriver.Companion.IN_MEMORY

object Db {
    private val driver: SqlDriver by lazy { JdbcSqliteDriver(IN_MEMORY) }

    init {
        CharacterDatabase.Schema.create(driver)
    }

    fun getDb() = CharacterDatabase(driver)
}