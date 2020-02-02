package com.artcoffer.risk.model.entity

import java.time.ZonedDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class GameEntity(


    @Id
    @GeneratedValue
    private val id: Long? = null,

    @Column(name = "start_date")
    private val startDate: ZonedDateTime? = ZonedDateTime.now(),

    @Column(name = "board_setup")
    private val boardSetup: Boolean? = null,

    @Column(name = "round")
    private val round: Int? = 1)

//    val id: String,
//    val startDate: ZonedDateTime? = ZonedDateTime.now(),
//    val boardSetup: Boolean = false,
//    val players: LinkedHashSet<String>,
//    val round: Int = 1,
//    val currentTurn: Turn,
