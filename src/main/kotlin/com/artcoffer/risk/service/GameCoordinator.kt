package com.artcoffer.risk.service

import com.artcoffer.risk.dto.Game

class GameCoordinator {

    fun validMove(game: Game): Boolean {

        if (!game.boardSetup) {
            return false
        }

        return true
    }

}