package com.auto.synch.models

import kotlinx.serialization.Serializable

@Serializable
data class CharacterApi(val name: String, val gender: String, val culture: String, val born: String)