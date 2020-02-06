package com.artcoffer.risk.service

import com.artcoffer.risk.dto.Game
import com.artcoffer.risk.dto.PlayerMove
import com.artcoffer.risk.dto.Turn
import com.artcoffer.risk.dto.TurnAction.*
import javax.inject.Singleton

@Singleton
class MoveCoordinator {

    fun calculateNextMove(playerMove: PlayerMove, game: Game): Game {

        return when (playerMove.turnAction) {
            PLACE_TROOPS -> {
                placeTroops(playerMove.territoryTo)
                game
            }
            ADVANCE -> {
                advanceTroops(playerMove.territoryFrom, playerMove.territoryTo)
                game
            }
            ATTACK -> {
                attack(playerMove.territoryFrom, playerMove.territoryTo)
                game
            }
            REINFORCE -> {
                reinforce(playerMove.territoryFrom, playerMove.territoryTo)
                game
            }
            END_TURN -> {
                endTurn(game)
            }
        }

    }

    private fun placeTroops(territoryTo: String) {
        println("Placing troops on $territoryTo")
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

    private fun endTurn(game: Game): Game {
        println("Ending turn")

        // Pay out next player bonuses

        // Set initial turn options of next player
        return game.copy(currentTurn = Turn(playerId = getNextPlayer(game),
                turnActions = setOf(ADVANCE, END_TURN)))
    }

    private fun getNextPlayer(game: Game): String {
        val currentPlayer = game.currentTurn.playerId
        val currentPlayerIndex = game.players.indexOf(currentPlayer)

        // Determine next player
        return if (currentPlayerIndex < game.players.size - 1)
            game.players[currentPlayerIndex + 1]
        else game.players.first()
    }

}