package com.artcoffer.risk.controller

import com.artcoffer.risk.dto.Game
import com.artcoffer.risk.dto.GameSetup
import com.artcoffer.risk.dto.Turn
import com.artcoffer.risk.model.PlayableMapFactory
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*
import javax.inject.Inject

@Controller("/")
class GameController(@Inject val playableMapFactory: PlayableMapFactory) {

    /**
     * Returns details about game
     */
    @Get("/game/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    fun gameInit(@PathVariable id: String): Game {
        return Game(
                id = "1",
                players = linkedSetOf("1", "2"),
                currentTurn = Turn(playerId = "1"),
                playableMap = playableMapFactory.worldMap()
        )
    }

    /**
     * Creates a new game
     */
    @Post("/game")
    fun createGame(@Body gameSetup: GameSetup): Game {
        return Game(
                id = "1",
                players = gameSetup.players,
                currentTurn = Turn(playerId = gameSetup.players.first()),
                playableMap = playableMapFactory.worldMap()
        )
    }


}