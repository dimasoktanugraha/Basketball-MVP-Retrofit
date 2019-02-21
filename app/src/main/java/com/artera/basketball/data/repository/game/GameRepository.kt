package com.artera.basketball.data.repository.game

import com.artera.basketball.data.entity.GameResponse
import io.reactivex.Observable

interface GameRepository {

    fun getAllGame(): Observable<GameResponse>
}