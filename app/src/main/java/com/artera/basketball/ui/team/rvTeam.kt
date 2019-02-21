package com.artera.basketball.ui.team

import com.artera.basketball.R
import com.artera.basketball.data.entity.TeamItem
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.adapter_team.view.*

interface TeamListener {
    fun onTeamClick(team: TeamItem)
}

class rvTeam(
    val team: TeamItem,
    val listener: TeamListener
) : Item() {


    override fun bind(viewHolder: ViewHolder, position: Int) {
        val tvName = viewHolder.itemView.teamName
        val tvCity = viewHolder.itemView.teamCity

        tvName.text = team.fullName
        tvCity.text = team.city

        viewHolder.itemView.setOnClickListener {
            listener.onTeamClick(team)
        }
    }

    override fun getLayout(): Int {
        return R.layout.adapter_team
    }


}