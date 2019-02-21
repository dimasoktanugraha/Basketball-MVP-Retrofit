package com.artera.basketball.data.entity

import com.google.gson.annotations.SerializedName

data class Game(

    @field:SerializedName("date")
    val date: String,

    @field:SerializedName("period")
    val period: Int,

    @field:SerializedName("visitor_team_score")
    val visitorTeamScore: Int,

    @field:SerializedName("season")
    val season: Int,

    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("home_team_score")
    val homeTeamScore: Int,

    @field:SerializedName("time")
    val time: String,

    @field:SerializedName("home_team")
    val homeTeam: GameTeam,

    @field:SerializedName("visitor_team")
    val visitorTeam: GameTeam,

    @field:SerializedName("status")
    val status: String
)