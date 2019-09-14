package com.auto.synch.database.database

import com.auto.synch.database.CharacterDatabase
import com.auto.synch.database.CharacterQueries
import com.auto.synch.database.GotCharacter
import com.squareup.sqldelight.Query
import com.squareup.sqldelight.TransacterImpl
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.internal.copyOnWriteList
import kotlin.Any
import kotlin.Int
import kotlin.String
import kotlin.collections.MutableList
import kotlin.reflect.KClass

internal val KClass<CharacterDatabase>.schema: SqlDriver.Schema
  get() = CharacterDatabaseImpl.Schema

internal fun KClass<CharacterDatabase>.newInstance(driver: SqlDriver): CharacterDatabase =
    CharacterDatabaseImpl(driver)

private class CharacterDatabaseImpl(
  driver: SqlDriver
) : TransacterImpl(driver), CharacterDatabase {
  override val characterQueries: CharacterQueriesImpl = CharacterQueriesImpl(this, driver)

  object Schema : SqlDriver.Schema {
    override val version: Int
      get() = 1

    override fun create(driver: SqlDriver) {
      driver.execute(null, """
          |CREATE TABLE gotCharacter (
          |  name TEXT NOT NULL,
          |  gender TEXT NOT NULL,
          |  culture TEXT NOT NULL,
          |  born TEXT NOT NULL
          |)
          """.trimMargin(), 0)
      driver.execute(null,
          "INSERT INTO gotCharacter VALUES (\"Alysanne Osgrey\", \"Female\", \"Bravoosi\", \"In 188 AC\")",
          0)
    }

    override fun migrate(
      driver: SqlDriver,
      oldVersion: Int,
      newVersion: Int
    ) {
    }
  }
}

private class CharacterQueriesImpl(
  private val database: CharacterDatabaseImpl,
  private val driver: SqlDriver
) : TransacterImpl(driver), CharacterQueries {
  internal val selectAllCharacters: MutableList<Query<*>> = copyOnWriteList()

  override fun <T : Any> selectAllCharacters(mapper: (
    name: String,
    gender: String,
    culture: String,
    born: String
  ) -> T): Query<T> = Query(-2142757052, selectAllCharacters, driver, "character.sq",
      "selectAllCharacters", "SELECT * FROM gotCharacter") { cursor ->
    mapper(
      cursor.getString(0)!!,
      cursor.getString(1)!!,
      cursor.getString(2)!!,
      cursor.getString(3)!!
    )
  }

  override fun selectAllCharacters(): Query<GotCharacter> = selectAllCharacters(GotCharacter::Impl)

  override fun insertCharacter(gotCharacter: GotCharacter) {
    driver.execute(-1427416347, """INSERT INTO gotCharacter VALUES (?, ?, ?, ?)""", 4) {
      bindString(1, gotCharacter.name)
      bindString(2, gotCharacter.gender)
      bindString(3, gotCharacter.culture)
      bindString(4, gotCharacter.born)
    }
    notifyQueries(-1427416347, {database.characterQueries.selectAllCharacters})
  }
}
