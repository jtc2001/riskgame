package com.artcoffer.risk.dto

import java.time.ZonedDateTime

data class Game(
        val id: String,
        val startDate: ZonedDateTime? = ZonedDateTime.now(),
        val boardSetup: Boolean = false,
        val players: List<String>,
        val round: Int = 1,
        val currentTurn: Turn,
        val gameMap: GameMap,
        val playableMap: Map<String, Int>
)