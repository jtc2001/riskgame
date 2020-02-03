package com.artcoffer.risk.controller

import com.artcoffer.risk.dto.*
import com.artcoffer.risk.service.GameCoordinator
import com.artcoffer.risk.service.PlayerMoveService
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import javax.inject.Inject

@Controller
class TurnController(@Inject val playerMoveService: PlayerMoveService,
                     @Inject val gameCoordinator: GameCoordinator) {


    @Get("/move")
    fun currentMove(): CurrentMove {
        return gameCoordinator.currentMove()
    }

    @Post("/move")
    fun playMove(@Body playerMove: PlayerMove): Game {
        return playerMoveService.move(playerMove)
    }

}