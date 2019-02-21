package com.artera.basketball.ui.team

import com.artera.basketball.data.entity.TeamItem

interface TeamView {

    fun showLoading()
    fun hideLoading()
    fun showAllTeam(allTeam: List<TeamItem>)
    fun showError(error: String)
}