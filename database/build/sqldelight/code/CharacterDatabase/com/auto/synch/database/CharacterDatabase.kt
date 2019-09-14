package com.auto.synch.database

import com.auto.synch.database.database.newInstance
import com.auto.synch.database.database.schema
import com.squareup.sqldelight.Transacter
import com.squareup.sqldelight.db.SqlDriver

interface CharacterDatabase : Transacter {
  val characterQueries: CharacterQueries

  companion object {
    val Schema: SqlDriver.Schema
      get() = CharacterDatabase::class.schema

    operator fun invoke(driver: SqlDriver): CharacterDatabase =
        CharacterDatabase::class.newInstance(driver)}
}
