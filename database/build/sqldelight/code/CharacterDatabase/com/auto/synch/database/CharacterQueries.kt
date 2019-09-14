package com.auto.synch.database

import com.squareup.sqldelight.Query
import com.squareup.sqldelight.Transacter
import kotlin.Any
import kotlin.String

interface CharacterQueries : Transacter {
  fun <T : Any> selectAllCharacters(mapper: (
    name: String,
    gender: String,
    culture: String,
    born: String
  ) -> T): Query<T>

  fun selectAllCharacters(): Query<GotCharacter>

  fun insertCharacter(gotCharacter: GotCharacter)
}
