package com.artera.basketball.data.entity

import com.google.gson.annotations.SerializedName

data class TeamItem(

    @field:SerializedName("division")
    val division: String,

    @field:SerializedName("conference")
    val conference: String,

    @field:SerializedName("full_name")
    val fullName: String,

    @field:SerializedName("city")
    val city: String,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("abbreviation")
    val abbreviation: String
)