package com.artera.basketball.data.repository.detail

import com.artera.basketball.data.entity.TeamItem
import com.artera.basketball.network.ApiService
import com.artera.basketball.network.RetrofitClient
import io.reactivex.Observable

class DetailRepositoryImpl : DetailRepository {
    override fun getDetailTeam(id: Int): Observable<TeamItem> {
        return RetrofitClient.instance.create(ApiService::class.java).getDetailTeam(id)
    }
}