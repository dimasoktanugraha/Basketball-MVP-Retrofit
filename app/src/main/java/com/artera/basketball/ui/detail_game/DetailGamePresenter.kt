package com.artera.basketball.ui.detail_game

import android.annotation.SuppressLint
import com.artera.basketball.data.repository.detail_game.DetailGameRespository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class DetailGamePresenter(
    val view: DetailGameView,
    val repo: DetailGameRespository
) {

    @SuppressLint("CheckResult")
    fun getDetailGame(id: Int) {
        view.showLoading()

        repo.detailGame(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                view.hideLoading()
                val data = it

                if (data != null) {
                    view.showDetailGame(it)
                } else {
                    view.showError("null")
                }
            }, {
                view.hideLoading()
                view.showError(it.toString())
            })
    }
}