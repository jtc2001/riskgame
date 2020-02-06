package com.artcoffer.risk.service

import com.artcoffer.risk.dto.Game
import com.artcoffer.risk.dto.PlayerMove
import com.artcoffer.risk.dto.TurnAction.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PlayerMoveService(@Inject val coordinator: GameCoordinator) {

    fun move(playerMove: PlayerMove): Game {

        if (!coordinator.validMove()) {
            println("Invalid move cannot proceed")
            return coordinator.getGame()
        }

        return coordinator.advanceTurn(playerMove)

    }

}