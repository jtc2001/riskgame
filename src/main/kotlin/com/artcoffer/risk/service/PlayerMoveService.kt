package com.artcoffer.risk.service

import com.artcoffer.risk.dto.Game
import com.artcoffer.risk.dto.PlayerMove
import com.artcoffer.risk.dto.TurnAction.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PlayerMoveService(@Inject val coordinator: GameCoordinator) {

    fun move(game: Game, playerMove: PlayerMove) {
        when (playerMove.turnAction) {
            ADVANCE -> {
                advanceTroops(game, playerMove.territoryFrom, playerMove.territoryTo)
            }
            ATTACK -> {
                attack(game, playerMove.territoryFrom, playerMove.territoryTo)
            }
            REINFORCE -> {
                reinforce(game, playerMove.territoryFrom, playerMove.territoryTo)
            }
        }

    }

    private fun advanceTroops(game: Game, location1: String, location2: String) {
        if (coordinator.validMove(game)) {
            println("Advanced troops from $location1 to $location2")
        } else {
            println("Invalid move cannot proceed with advancement")
        }
    }

    private fun attack(game: Game, location1: String, location2: String) {
        if (coordinator.validMove(game)) {
            println("Attacking! from $location1 to $location2")
        } else {
            println("Invalid move cannot proceed with attack")
        }
    }

    private fun reinforce(game: Game, location1: String, location2: String) {
        if (coordinator.validMove(game)) {
            println("Reinforcing troops from $location1 to $location2")
        } else {
            println("Invalid move cannot proceed with reinforcement")
        }
    }
}