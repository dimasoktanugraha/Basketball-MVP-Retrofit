package com.artera.basketball.network

import com.artera.basketball.data.entity.Game
import com.artera.basketball.data.entity.GameResponse
import com.artera.basketball.data.entity.TeamItem
import com.artera.basketball.data.entity.TeamResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("teams/{id}")
    fun getDetailTeam(@Path("id") id: Int): Observable<TeamItem>

    @GET("teams")
    fun getAllTeam(): Observable<TeamResponse>

    @GET("games?seasons[]=2017")
    fun getAllGame(): Observable<GameResponse>

    @GET("games/{id}")
    fun getDetailGame(@Path("id") id: Int): Observable<Game>

}