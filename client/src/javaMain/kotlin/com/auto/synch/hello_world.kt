package com.auto.synch

import com.auto.synch.api.Character
import com.auto.synch.api.ClientFactory
import io.ktor.client.request.get
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun main() {
    GlobalScope.launch {
        val data = ClientFactory.client().get<Character>("https://anapioficeandfire.com/api/characters/583")
        print(data)
    }

    readLine()
}