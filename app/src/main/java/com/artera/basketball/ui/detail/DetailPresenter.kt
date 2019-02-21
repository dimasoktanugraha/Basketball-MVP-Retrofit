package com.artera.basketball.ui.detail

import android.annotation.SuppressLint
import com.artera.basketball.data.repository.detail.DetailRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class DetailPresenter(
    val view: DetailView,
    val teamRepo: DetailRepository
) {

    @SuppressLint("CheckResult")
    fun getDetailTeam(id: Int) {

        view.showLoading()

        teamRepo.getDetailTeam(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                view.hideLoading()
                val data = it

                if (data != null) {
                    view.showDetailTeam(it)
                } else {
                    view.showError("null")
                }
            }, {
                view.hideLoading()
                view.showError(it.toString())
            })

    }
}