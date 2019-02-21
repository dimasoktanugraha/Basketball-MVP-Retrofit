package com.artera.basketball.ui.game

import android.widget.TextView
import com.artera.basketball.R
import com.artera.basketball.data.entity.Game
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.adapter_game.view.*
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class rvGame(
    val game: Game,
    val listener: GameListener
) : Item() {
    override fun bind(viewHolder: ViewHolder, position: Int) {
        val date: TextView = viewHolder.itemView.gameDate
        val scoreHome: TextView = viewHolder.itemView.gameHomeScore
        val scoreAway: TextView = viewHolder.itemView.gameAwayScore
        val home: TextView = viewHolder.itemView.gameHome
        val away: TextView = viewHolder.itemView.gameAway

        val getDate = game.date
        val input = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US)
        val output = SimpleDateFormat("dd/MM/yyyy")

        var d: Date? = null
        try {
            d = input.parse(getDate)
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        val formatted = output.format(d)

        date.text = formatted
        scoreHome.text = game.homeTeamScore.toString()
        scoreAway.text = game.visitorTeamScore.toString()
        home.text = game.homeTeam.name
        away.text = game.visitorTeam.name

        viewHolder.itemView.setOnClickListener {
            listener.onGameClick(game)
        }
    }

    override fun getLayout(): Int {
        return R.layout.adapter_game
    }
}

interface GameListener {
    fun onGameClick(game: Game)
}