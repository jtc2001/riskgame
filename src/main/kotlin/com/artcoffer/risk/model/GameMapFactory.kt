package com.artcoffer.risk.model

import com.artcoffer.risk.dto.Continent
import com.artcoffer.risk.dto.GameMap
import com.artcoffer.risk.dto.Territory
import javax.inject.Singleton

@Singleton
class GameMapFactory {

    companion object {
        val northAmericaTerritories = setOf<Territory>(
                Territory("Western United States"),
                Territory("Eastern United States"),
                Territory("Eastern Canada"),
                Territory("Ontario"),
                Territory("Central America"),
                Territory("Alaska"),
                Territory("Alberta"),
                Territory("Greenland"))

        val northAmerica = Continent(name = "North America", territories = northAmericaTerritories, bonusArmies = 5)

        val continents = setOf<Continent>(northAmerica)

        @JvmStatic
        fun worldMap(): GameMap = GameMap(continents = continents)
    }


}