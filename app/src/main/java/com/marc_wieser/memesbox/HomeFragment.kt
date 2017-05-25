package com.marc_wieser.memesbox


import android.media.MediaPlayer
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.marc_wieser.memesbox.R


/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val v = inflater?.inflate(R.layout.fragment_home, container, false)
        val recyclerView : RecyclerView = v?.findViewById(R.id.meme_list) as RecyclerView
        var dataset: Array<MemeModel> = Array(0, {MemeModel("empty", it, it)})

        dataset += MemeModel("Souffrir OK?!", R.raw.souffrirok_gif, R.raw.souffrirok)
        dataset += MemeModel("Ah!", R.raw.ah_gif, R.raw.ah)
        recyclerView.adapter = MemeAdapter(dataset)
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        return v
    }

}// Required empty public constructor
