package com.artera.basketball.data.entity

import com.google.gson.annotations.SerializedName

data class TeamResponse(

    @field:SerializedName("data")
    val data: List<TeamItem>
)