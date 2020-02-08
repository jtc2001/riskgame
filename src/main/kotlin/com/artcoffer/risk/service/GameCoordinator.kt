package com.artcoffer.risk.service

import com.artcoffer.risk.dto.*
import com.artcoffer.risk.model.MapFactory
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GameCoordinator(@Inject val mapFactory: MapFactory,
                      @Inject val moveCoordinator: MoveCoordinator) {

    companion object {
        private lateinit var theGame: Game
    }

    fun createGame(gameSetup: GameSetup): Game {
        theGame = Game(
                id = UUID.randomUUID().toString(),
                players = gameSetup.players,
                currentTurn = Turn(gameSetup.players.first()),
                mapDetails = MapFactory.worldMap()
        )
        return theGame.copy()
    }

    fun getGame(): Game {
        return theGame.copy()
    }

    fun validMove(): Boolean {
        return true
    }

    fun advanceTurn(playerMove: PlayerMove): Game {
        theGame = moveCoordinator.calculateNextMove(playerMove, theGame)
        return theGame.copy()
    }

    fun currentMove(): CurrentMove {
        return CurrentMove(playerId = theGame.currentTurn.playerId, move = theGame.currentTurn.turnActions)
    }

}