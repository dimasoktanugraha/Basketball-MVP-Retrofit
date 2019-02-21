package com.artera.basketball.ui.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.artera.basketball.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewpager_main.adapter = MainViewPagerAdapter(supportFragmentManager)
        tabs_main.setupWithViewPager(viewpager_main)
    }
}
