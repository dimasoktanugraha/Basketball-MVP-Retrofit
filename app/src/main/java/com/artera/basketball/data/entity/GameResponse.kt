package com.artera.basketball.data.entity

import com.google.gson.annotations.SerializedName

class GameResponse(

    @field:SerializedName("data")
    val data: List<Game>
)