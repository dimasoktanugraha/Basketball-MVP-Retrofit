package com.artera.basketball.ui.detail_game

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.artera.basketball.R
import com.artera.basketball.data.entity.Game
import com.artera.basketball.data.repository.detail_game.DetailGameRepositoryImpl
import kotlinx.android.synthetic.main.activity_detail_game.*
import org.jetbrains.anko.toast
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class DetailGameActivity : AppCompatActivity(), DetailGameView {

    lateinit var presenter: DetailGamePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_game)

        supportActionBar?.title = " DETAIL GAME"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val id: Int = intent.getIntExtra("idGame", 0)

        val repo = DetailGameRepositoryImpl()
        presenter = DetailGamePresenter(this, repo)
        presenter.getDetailGame(id)
    }

    override fun showLoading() {
        progresDetailGame.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progresDetailGame.visibility = View.GONE
    }

    override fun showDetailGame(detail: Game) {

//            detailGameTgl.text = detail.date
        detailGameScoreHome.text = detail.homeTeamScore.toString()
        detailGameNameHome.text = detail.homeTeam.fullName
        detailGameScoreAway.text = detail.visitorTeamScore.toString()
        detailGameNameAway.text = detail.visitorTeam.fullName
        detailGameYear.text = detail.season.toString()
        detailGameStatus.text = detail.status

        val getDate = detail.date
        val input = SimpleDateFormat("yyyy-MM-dd HH:mm:ss 'UTC'")
        val output = SimpleDateFormat("dd/MM/yyyy")

        var d: Date? = null
        try {
            d = input.parse(getDate)
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        val formatted = output.format(d)

        detailGameTgl.text = formatted

    }

    override fun showError(error: String) {
        toast(error)
    }
}
