package com.auto.synch.database

import kotlin.String

interface GotCharacter {
  val name: String

  val gender: String

  val culture: String

  val born: String

  data class Impl(
    override val name: String,
    override val gender: String,
    override val culture: String,
    override val born: String
  ) : GotCharacter {
    override fun toString(): String = """
    |GotCharacter.Impl [
    |  name: $name
    |  gender: $gender
    |  culture: $culture
    |  born: $born
    |]
    """.trimMargin()
  }
}
