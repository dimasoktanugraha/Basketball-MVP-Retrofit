package com.artera.basketball.ui.game

import com.artera.basketball.data.entity.Game

interface GameView {

    fun showLoading()
    fun hideLoading()
    fun showAllGame(allGame: List<Game>)
    fun showError(error: String)
}