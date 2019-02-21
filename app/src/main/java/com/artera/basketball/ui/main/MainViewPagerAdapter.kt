package com.artera.basketball.ui.main

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.artera.basketball.ui.game.GameFragment
import com.artera.basketball.ui.team.TeamFragment

class MainViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val pages = listOf(
        TeamFragment(),
        GameFragment()
    )

    override fun getItem(position: Int): Fragment {
        return pages[position]
    }

    override fun getCount(): Int {
        return pages.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "TEAM"
            else -> "GAME"
        }
    }
}