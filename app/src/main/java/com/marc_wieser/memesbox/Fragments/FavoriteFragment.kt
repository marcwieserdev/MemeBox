package com.marc_wieser.memesbox.Fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.marc_wieser.memesbox.R


/**
 * A simple [Fragment] subclass.
 */
class FavoriteFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_liked, container, false)
    }

}// Required empty public constructor
