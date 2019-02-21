package com.artera.basketball.ui.detail

import com.artera.basketball.data.entity.TeamItem

interface DetailView {

    fun showLoading()
    fun hideLoading()
    fun showDetailTeam(detail: TeamItem)
    fun showError(error: String)
}