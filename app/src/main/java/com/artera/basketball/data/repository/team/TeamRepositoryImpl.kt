package com.artera.basketball.data.repository.team

import com.artera.basketball.data.entity.TeamResponse
import com.artera.basketball.network.ApiService
import com.artera.basketball.network.RetrofitClient
import io.reactivex.Observable

class TeamRepositoryImpl : TeamRepository {

    override fun getAllTeam(): Observable<TeamResponse> {
        return RetrofitClient.instance.create(ApiService::class.java).getAllTeam()
    }
}