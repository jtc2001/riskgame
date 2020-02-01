package com.artcoffer.risk.dto

data class PlayerMove(
        val gameId: String,
        val player: String,
        val turnAction: TurnAction,
        val territoryFrom: String,
        val territoryTo: String
)