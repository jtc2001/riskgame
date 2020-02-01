package com.artcoffer.risk.controller

import com.artcoffer.risk.dto.PlayerMove
import com.artcoffer.risk.service.PlayerMoveService
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import javax.inject.Inject

@Controller
class TurnController(@Inject val playerMoveService: PlayerMoveService) {

    @Post("/move")
    fun move(@Body playerMove: PlayerMove) {
        playerMoveService.move(playerMove)
    }

}