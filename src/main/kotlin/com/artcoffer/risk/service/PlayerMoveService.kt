package com.artcoffer.risk.service

import com.artcoffer.risk.dto.Game
import com.artcoffer.risk.dto.PlayerMove
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PlayerMoveService(@Inject val coordinator: GameCoordinator) {

    fun move(playerMove: PlayerMove): Game {
        val game = coordinator.getGame()

        if(!game.currentTurn.turnActions.contains(playerMove.turnAction)){
            println("Invalid move cannot proceed")
            return game
        }

        return coordinator.advanceTurn(playerMove)
    }

}