package com.artera.basketball.data.repository.detail_game

import com.artera.basketball.data.entity.Game
import io.reactivex.Observable

interface DetailGameRespository {
    fun detailGame(id: Int): Observable<Game>
}