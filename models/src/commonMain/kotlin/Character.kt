package com.auto.synch.api

import kotlinx.serialization.Serializable

@Serializable
data class Character(val name: String, val gender: String, val culture: String, val born: String)