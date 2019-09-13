package com.auto.synch.database

import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.sqlite.driver.JdbcSqliteDriver
import com.squareup.sqldelight.sqlite.driver.JdbcSqliteDriver.Companion.IN_MEMORY

class CharacterDb : BaseRetriever<List<GotCharacter>>() {

    private val driver: SqlDriver by lazy { JdbcSqliteDriver(IN_MEMORY) }
    private val db: CharacterDatabase by lazy { CharacterDatabase(driver) }

    init {
        CharacterDatabase.Schema.create(driver)
    }

    fun addCharacter(character: GotCharacter) {
        db.characterQueries.insertCharacter(character)
        update(characters())
    }

    fun characters() = db.characterQueries.selectAllCharacters().executeAsList()
}