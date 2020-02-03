package com.artcoffer.risk.controller

import com.artcoffer.risk.dto.Game
import com.artcoffer.risk.dto.GameSetup
import com.artcoffer.risk.service.GameCoordinator
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*
import javax.inject.Inject

@Controller("/")
class GameController(@Inject val gameCoordinator: GameCoordinator) {

    /**
     * Returns details about game
     */
    @Get("/game/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    fun gameDetails(@PathVariable id: String): Game {
        return gameCoordinator.getGame()
    }

    /**
     * Creates a new game
     */
    @Post("/game")
    fun createGame(@Body gameSetup: GameSetup): Game {
        return gameCoordinator.createGame(gameSetup)
    }


}