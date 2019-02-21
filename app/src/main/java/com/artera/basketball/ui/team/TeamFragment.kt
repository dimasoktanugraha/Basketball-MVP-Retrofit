package com.artera.basketball.ui.team

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
import com.artera.basketball.data.entity.TeamItem
import com.artera.basketball.data.repository.team.TeamRepositoryImpl
import com.artera.basketball.ui.detail.DetailActivity
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import org.jetbrains.anko.find
import org.jetbrains.anko.toast

class TeamFragment : Fragment(), TeamView, TeamListener {

    lateinit var presenter: TeamPresenter

    val TeamAdapter = GroupAdapter<ViewHolder>()

    lateinit var recyclerTeam: RecyclerView
    lateinit var progressTeam: ProgressBar


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_team, container, false)

        val repo = TeamRepositoryImpl()

        recyclerTeam = view.find(R.id.recyclerTeam)
        progressTeam = view.find(R.id.progressTeam)

        recyclerTeam.apply {
            adapter = TeamAdapter
            layoutManager = LinearLayoutManager(activity)
        }

        presenter = TeamPresenter(this, repo)
        presenter.getAllTeam()

        return view
    }

    override fun showLoading() {
        progressTeam.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progressTeam.visibility = View.GONE
    }

    override fun showAllTeam(allTeam: List<TeamItem>) {
        allTeam.map {
            TeamAdapter.add(rvTeam(it, this))
        }
    }

    override fun showError(error: String) {
        activity?.toast(error)
    }

    override fun onTeamClick(team: TeamItem) {
        val intent = Intent(activity, DetailActivity::class.java)
        intent.putExtra("id", team.id)
        startActivity(intent)
    }
}