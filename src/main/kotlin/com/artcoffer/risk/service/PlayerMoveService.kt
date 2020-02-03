package com.artcoffer.risk.service

import com.artcoffer.risk.dto.Game
import com.artcoffer.risk.dto.PlayerMove
import com.artcoffer.risk.dto.TurnAction.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PlayerMoveService(@Inject val coordinator: GameCoordinator) {

    fun move(playerMove: PlayerMove): Game {
        return when (playerMove.turnAction) {
            PLACE_TROOPS -> {
                placeTroops(playerMove.territoryTo)
            }
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

    private fun placeTroops(territoryTo: String): Game {
        println("Placing troops on $territoryTo")
        return coordinator.advanceTurn()
    }

    private fun advanceTroops(location1: String, location2: String): Game {
        return if (coordinator.validMove()) {
            println("Advanced troops from $location1 to $location2")
            coordinator.advanceTurn()
        } else {
            println("Invalid move cannot proceed with advancement")
            return coordinator.getGame()
        }
    }

    private fun attack(location1: String, location2: String): Game {
        return if (coordinator.validMove()) {
            println("Attacking! from $location1 to $location2")
            coordinator.advanceTurn()
        } else {
            println("Invalid move cannot proceed with attack")
            return coordinator.getGame()
        }
    }

    private fun reinforce(location1: String, location2: String): Game {
        return if (coordinator.validMove()) {
            println("Reinforcing troops from $location1 to $location2")
            coordinator.advanceTurn()
        } else {
            println("Invalid move cannot proceed with reinforcement")
            return coordinator.getGame()
        }
    }
}