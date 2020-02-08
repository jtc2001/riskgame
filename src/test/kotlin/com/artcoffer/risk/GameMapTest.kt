package com.artcoffer.risk

import com.artcoffer.risk.model.GameMapFactory
import org.junit.jupiter.api.Test


class GameMapTest {

    @Test
    fun testGameMapList() {

        val map = GameMapFactory.worldMap()

        val territories = map.continents.map { continent ->
            continent.territories.map { territory ->
                territory.name to 0
            }
        }.flatten().toMap()

        println(territories)

    }

}