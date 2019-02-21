package com.artera.basketball.data.repository.detail_game

import com.artera.basketball.data.entity.Game
import com.artera.basketball.network.ApiService
import com.artera.basketball.network.RetrofitClient
import io.reactivex.Observable

class DetailGameRepositoryImpl : DetailGameRespository {
    override fun detailGame(id: Int): Observable<Game> {
        return RetrofitClient.instance.create(ApiService::class.java).getDetailGame(id)
    }


}