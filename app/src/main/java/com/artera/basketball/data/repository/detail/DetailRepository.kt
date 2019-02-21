package com.artera.basketball.data.repository.detail

import com.artera.basketball.data.entity.TeamItem
import io.reactivex.Observable

interface DetailRepository {
    fun getDetailTeam(id: Int): Observable<TeamItem>
}