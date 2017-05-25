package com.marc_wieser.memesbox

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import com.marc_wieser.memesbox.Adapters.PagerAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val pager : ViewPager = findViewById(R.id.pager) as ViewPager
        pager.adapter = PagerAdapter(supportFragmentManager, this)
    }

}
