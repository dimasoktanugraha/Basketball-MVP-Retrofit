package com.artera.basketball.ui.detail

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.view.View
import com.artera.basketball.R
import com.artera.basketball.data.entity.TeamItem
import com.artera.basketball.data.repository.detail.DetailRepositoryImpl
import kotlinx.android.synthetic.main.activity_detail.*
import org.jetbrains.anko.toast

class DetailActivity : AppCompatActivity(), DetailView {

    lateinit var presenter: DetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.title = " DETAIL TEAM"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val id: Int = intent.getIntExtra("id", 0)

        val repo = DetailRepositoryImpl()

        presenter = DetailPresenter(this, repo)
        presenter.getDetailTeam(id)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun showLoading() {
        progressDetail.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progressDetail.visibility = View.GONE
    }

    override fun showDetailTeam(detail: TeamItem) {


        teamName1.text = detail.fullName
        teamsShortName.text = detail.name
        teamDiv.text = detail.division
        teamConference.text = detail.conference
        teamCity1.text = detail.city


    }

    override fun showError(error: String) {
        toast(error)
    }
}
