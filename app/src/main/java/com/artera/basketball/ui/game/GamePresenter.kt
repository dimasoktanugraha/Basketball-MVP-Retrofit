package com.artera.basketball.ui.game

import android.annotation.SuppressLint
import com.artera.basketball.data.repository.game.GameRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class GamePresenter(
    val view: GameView,
    val gameRepo: GameRepository
) {
    @SuppressLint("CheckResult")
    fun getAllGame() {

        view.showLoading()

        gameRepo.getAllGame()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                val data = it.data
                view.hideLoading()

                if (!data.isNullOrEmpty()) {
                    view.showAllGame(data)
                } else {
                    view.showError("null")
                }
            }, {
                view.hideLoading()
                view.showError(it.toString())
            })

    }
}