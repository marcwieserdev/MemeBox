package com.marc_wieser.memesbox.Adapters

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.marc_wieser.memesbox.Fragments.HomeFragment
import com.marc_wieser.memesbox.Fragments.FavoriteFragment
import com.marc_wieser.memesbox.Fragments.StudioFragment
import com.marc_wieser.memesbox.R

/**
 * Created by marcw on 25/05/2017.
 */
class PagerAdapter(fm: FragmentManager, val context: Context) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position){
            0 -> HomeFragment()
            1 -> StudioFragment()
            2 -> FavoriteFragment()
            else -> throw UnsupportedOperationException()
        }
    }

    override fun getCount(): Int = 3

    override fun getPageTitle(position: Int): CharSequence {
        return when (position){
            0 -> context.getString(R.string.title_home)
            1 -> context.getString(R.string.title_studio)
            2 -> context.getString(R.string.title_favorite)
            else -> throw UnsupportedOperationException()
        }
    }
}