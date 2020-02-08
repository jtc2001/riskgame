package com.artcoffer.risk.service

import com.artcoffer.risk.dto.*
import com.artcoffer.risk.model.GameMapFactory
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GameCoordinator(@Inject val gameMapFactory: GameMapFactory,
                      @Inject val moveCoordinator: MoveCoordinator) {

    companion object {
        private lateinit var theGame: Game
    }

    fun createGame(gameSetup: GameSetup): Game {
        val map = GameMapFactory.worldMap()

        val playableMap = map.continents.map { continent ->
            continent.territories.map { territory ->
                territory.name to 0
            }
        }.flatten().toMap().toMutableMap()

        theGame = Game(
                id = UUID.randomUUID().toString(),
                players = gameSetup.players,
                currentTurn = Turn(gameSetup.players.first()),
                gameMap = GameMapFactory.worldMap(),
                playableMap = playableMap
        )
        return theGame.copy()
    }

    fun getGame(): Game {
        return theGame.copy()
    }

    fun advanceTurn(playerMove: PlayerMove): Game {
        theGame = moveCoordinator.calculateNextMove(playerMove, theGame)
        return theGame.copy()
    }

    fun currentMove(): CurrentMove {
        return CurrentMove(playerId = theGame.currentTurn.playerId, move = theGame.currentTurn.turnActions)
    }

}