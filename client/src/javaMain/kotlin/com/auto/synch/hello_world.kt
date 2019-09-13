package com.auto.synch

import com.auto.synch.database.CharacterDb
import com.auto.synch.database.GotCharacter
import com.auto.synch.models.CharacterApi
import com.auto.synch.models.ClientFactory
import io.ktor.client.request.get
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


fun executeMe() {

    val db = CharacterDb()
    db.registerForReceiver {
        print("List")
        val data = it.map { character ->
            CharacterApi(
                character.name,
                character.born,
                character.culture,
                character.gender
            )
        }
        print(data)
    }

    GlobalScope.launch {
        val data = ClientFactory.client().get<CharacterApi>("https://anapioficeandfire.com/api/characters/583")
        print(data)
        db.addCharacter(
            GotCharacter.Impl(
                name = data.name,
                born = data.born,
                culture = data.culture,
                gender = data.gender
            )
        )
    }

    readLine()
}