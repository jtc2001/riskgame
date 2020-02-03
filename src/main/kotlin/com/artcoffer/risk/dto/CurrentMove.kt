package com.artcoffer.risk.dto

data class CurrentMove(val playerId: String, val move: Set<TurnAction>)