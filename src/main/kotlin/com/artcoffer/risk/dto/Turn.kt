package com.artcoffer.risk.dto

import com.artcoffer.risk.dto.TurnAction.*

data class Turn(val playerId: String, val turnAction: TurnAction?= ADVANCE)