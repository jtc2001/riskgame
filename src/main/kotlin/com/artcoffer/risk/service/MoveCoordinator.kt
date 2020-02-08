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
                placeTroops(game, playerMove.territoryTo, playerMove.troops)
            }
            ADVANCE -> {
                advanceTroops(game, playerMove.territoryFrom, playerMove.territoryTo, playerMove.troops)
            }
            ATTACK -> {
                attack(game, playerMove.territoryFrom, playerMove.territoryTo)
            }
            REINFORCE -> {
                reinforce(game, playerMove.territoryFrom, playerMove.territoryTo)
            }
            END_TURN -> {
                endTurn(game)
            }
        }

    }

    private fun placeTroops(game: Game, territoryTo: String, troops: Int): Game {
        println("Placing troops on $territoryTo")
        val updatedTerritory = game.playableMap.toMutableMap()
        updatedTerritory[territoryTo] = updatedTerritory[territoryTo]?.plus(troops) ?: 0
        return game.copy(
                playableMap = updatedTerritory,
                currentTurn = game.currentTurn.copy(turnActions = setOf(PLACE_TROOPS, END_TURN))
        )
    }

    private fun advanceTroops(game: Game, territoryFrom: String, territoryTo: String, troops: Int): Game {
        println("Advanced troops from $territoryFrom to $territoryTo")
        val updatedTerritory = game.playableMap.toMutableMap()
        updatedTerritory[territoryTo] = updatedTerritory[territoryTo]?.plus(troops) ?: 0
        updatedTerritory[territoryFrom] = updatedTerritory[territoryFrom]?.minus(troops) ?: 0
        return game.copy(
                playableMap = updatedTerritory,
                currentTurn = game.currentTurn.copy(turnActions = setOf(ADVANCE, ATTACK, END_TURN))
        )
    }

    private fun attack(game: Game, location1: String, location2: String): Game {
        println("Attacking! from $location1 to $location2")
        return game.copy(currentTurn = game.currentTurn.copy(turnActions = setOf(ATTACK, REINFORCE, END_TURN)))
    }

    private fun reinforce(game: Game, location1: String, location2: String): Game {
        println("Reinforcing troops from $location1 to $location2")
        return game.copy(currentTurn = game.currentTurn.copy(turnActions = setOf(REINFORCE, END_TURN)))
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