package com.artera.basketball.data.repository.team

import com.artera.basketball.data.entity.TeamResponse
import io.reactivex.Observable

interface TeamRepository {
    fun getAllTeam(): Observable<TeamResponse>
}
