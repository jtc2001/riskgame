package com.artcoffer.risk.service

import com.artcoffer.risk.dto.CurrentMove
import com.artcoffer.risk.dto.Game
import com.artcoffer.risk.dto.GameSetup
import com.artcoffer.risk.dto.Turn
import com.artcoffer.risk.dto.TurnAction.PLACE_TROOPS
import com.artcoffer.risk.model.PlayableMapFactory
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GameCoordinator(@Inject val playableMapFactory: PlayableMapFactory){

    companion object {
        private lateinit var theGame: Game
    }

    fun createGame(gameSetup: GameSetup): Game {
        theGame = Game(
                id = UUID.randomUUID().toString(),
                players = gameSetup.players,
                currentTurn = Turn(gameSetup.players.first()),
                playableMap = PlayableMapFactory.worldMap()
        )
        return theGame.copy()
    }

    fun getGame(): Game {
        return theGame.copy()
    }


    fun validMove(): Boolean {
        if (!theGame.boardSetup) {
            return false
        }
        return true
    }

    fun advanceTurn(): Game {
        theGame.copy(currentTurn = Turn(playerId = "Matt", turnActions = setOf(PLACE_TROOPS)))
        return theGame.copy()
    }

    fun currentMove(): CurrentMove {
        return CurrentMove(playerId = theGame.currentTurn.playerId, move = theGame.currentTurn.turnActions)
    }

}