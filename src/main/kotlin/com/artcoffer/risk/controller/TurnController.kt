package com.artcoffer.risk.controller

import com.artcoffer.risk.dto.Game
import com.artcoffer.risk.dto.PlayerMove
import com.artcoffer.risk.dto.Turn
import com.artcoffer.risk.model.PlayableMapFactory
import com.artcoffer.risk.service.PlayerMoveService
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import javax.inject.Inject

@Controller
class TurnController(@Inject val playerMoveService: PlayerMoveService,
                     @Inject val playableMapFactory: PlayableMapFactory) {


    @Post("/move")
    fun move(@Body playerMove: PlayerMove) {
        val game = Game(
                id = "1",
                players = linkedSetOf("1", "2"),
                currentTurn = Turn(playerId = "1"),
                playableMap = playableMapFactory.worldMap(),
                boardSetup = true)

        playerMoveService.move(game, playerMove)
    }

}