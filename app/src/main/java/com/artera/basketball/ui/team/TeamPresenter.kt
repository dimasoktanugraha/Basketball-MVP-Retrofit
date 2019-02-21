package com.artera.basketball.ui.team

import android.annotation.SuppressLint
import com.artera.basketball.data.repository.team.TeamRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class TeamPresenter(
    val view: TeamView,
    val teamRepo: TeamRepository
) {

    @SuppressLint("CheckResult")
    fun getAllTeam() {

        view.showLoading()

//        teamRepo.getAllTeam().enqueue(object : Callback<TeamResponse>{
//
//
//            override fun onResponse(call: Call<TeamResponse>, response: Response<TeamResponse>) {
//                view.hideLoading()
//
//                if(response.isSuccessful){
//                    val result = response.body()
//
//                    if(result != null){
//                        view.showAllTeam(result.data)
//                    }else{
//                        view.showError("null")
//                    }
//
//                }
//
//            }
//
//            override fun onFailure(call: Call<TeamResponse>, t: Throwable) {
//                view.hideLoading()
//                view.showError(t.toString())
//            }
//
//        })

        teamRepo.getAllTeam()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                val data = it.data
                view.hideLoading()

                if (!data.isNullOrEmpty()) {
                    view.showAllTeam(data)
                } else {
                    view.showError("null")
                }
            }, {
                view.hideLoading()
                view.showError(it.toString())
            })

    }
}