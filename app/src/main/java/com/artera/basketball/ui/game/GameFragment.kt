package com.artera.basketball.ui.game

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import com.artera.basketball.R
import com.artera.basketball.data.entity.Game
import com.artera.basketball.data.repository.game.GameRepositoryImpl
import com.artera.basketball.ui.detail_game.DetailGameActivity
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import org.jetbrains.anko.find
import org.jetbrains.anko.toast

class GameFragment : Fragment(), GameView, GameListener {

    lateinit var presenter: GamePresenter
    lateinit var recyclerGame: RecyclerView
    lateinit var progressGame: ProgressBar
    val gameAdapter = GroupAdapter<ViewHolder>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_game, container, false)

        recyclerGame = view.find(R.id.recyclerGame)
        progressGame = view.find(R.id.progressGame)

        val repo = GameRepositoryImpl()

        recyclerGame.apply {
            adapter = gameAdapter
            layoutManager = LinearLayoutManager(activity)
        }

        presenter = GamePresenter(this, repo)
        presenter.getAllGame()


        return view
    }

    override fun showLoading() {
        progressGame.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progressGame.visibility = View.GONE
    }

    override fun showAllGame(allGame: List<Game>) {
        allGame.map {
            gameAdapter.add(rvGame(it, this))
        }
    }

    override fun showError(error: String) {
        activity?.toast(error)
    }

    override fun onGameClick(game: Game) {
        val intent = Intent(activity, DetailGameActivity::class.java)
        intent.putExtra("idGame", game.id)
        startActivity(intent)
    }

}