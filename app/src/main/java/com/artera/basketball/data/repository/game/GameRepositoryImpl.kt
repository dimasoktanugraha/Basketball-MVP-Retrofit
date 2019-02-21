package com.artera.basketball.data.repository.game

import com.artera.basketball.data.entity.GameResponse
import com.artera.basketball.network.ApiService
import com.artera.basketball.network.RetrofitClient
import io.reactivex.Observable

class GameRepositoryImpl : GameRepository {

    override fun getAllGame(): Observable<GameResponse> {
        return RetrofitClient.instance.create(ApiService::class.java).getAllGame()
    }
}