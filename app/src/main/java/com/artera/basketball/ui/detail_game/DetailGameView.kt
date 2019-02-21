package com.artera.basketball.ui.detail_game

import com.artera.basketball.data.entity.Game

interface DetailGameView {
    fun showLoading()
    fun hideLoading()
    fun showDetailGame(detail: Game)
    fun showError(error: String)
}