package com.auto.synch

import com.auto.synch.database.Db
import com.auto.synch.database.GotCharacter
import com.auto.synch.models.CharacterApi
import com.auto.synch.models.ClientFactory
import io.ktor.client.request.get
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


fun main() {

    print(Db.getDb().characterQueries.selectAllCharacters().executeAsList())


    GlobalScope.launch {
        val data = ClientFactory.client().get<CharacterApi>("https://anapioficeandfire.com/models/characters/583")
        print(data)

        Db.getDb().characterQueries.insertCharacter(
            GotCharacter.Impl(
                name = data.name,
                born = data.born,
                culture = data.culture,
                gender = data.gender
            )
        )

        print(Db.getDb().characterQueries.selectAllCharacters().executeAsList())

    }

    readLine()
}