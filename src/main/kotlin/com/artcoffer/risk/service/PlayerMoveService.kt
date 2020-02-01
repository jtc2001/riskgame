package com.artcoffer.risk.service

import com.artcoffer.risk.dto.PlayerMove
import com.artcoffer.risk.dto.TurnAction.*
import javax.inject.Singleton

@Singleton
class PlayerMoveService {

    fun move(playerMove: PlayerMove) {
        when (playerMove.turnAction) {
            ADVANCE -> {
                advanceTroops(playerMove.territoryFrom, playerMove.territoryTo)
            }
            ATTACK -> {
                attack(playerMove.territoryFrom, playerMove.territoryTo)
            }
            REINFORCE -> {
                reinforce(playerMove.territoryFrom, playerMove.territoryTo)
            }
        }

    }

    private fun advanceTroops(location1: String, location2: String) {
        println("Advanced troops from $location1 to $location2")
    }

    private fun attack(location1: String, location2: String) {
        println("Attacking! from $location1 to $location2")
    }

    private fun reinforce(location1: String, location2: String) {
        println("Reinforcing troops from $location1 to $location2")
    }
}