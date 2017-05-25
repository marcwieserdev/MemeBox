package com.marc_wieser.memesbox.Fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.marc_wieser.memesbox.Adapters.MemeAdapter
import com.marc_wieser.memesbox.Models.MemeModel
import com.marc_wieser.memesbox.R


/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    private fun buildBeatsDataset() : Array<MemeModel> = arrayOf(
            MemeModel("Souffrir OK?!", R.raw.souffrirok_gif, R.raw.souffrirok, 1f),
            MemeModel("Ah!", R.raw.ah_gif, R.raw.ah, 1f)
    )

    private fun buildAmbientDataset() : Array<MemeModel> = arrayOf(
            MemeModel("JLM Holo", R.raw.jlmholo, R.raw.planete_melenchon, 0.25f)
    )

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val v = inflater?.inflate(R.layout.fragment_home, container, false)
        val memeBeats : RecyclerView = v?.findViewById(R.id.meme_list) as RecyclerView
        val memeAmbient : RecyclerView = v.findViewById(R.id.meme_ambient_list) as RecyclerView
        val datasetBeats: Array<MemeModel> = buildBeatsDataset()
        val datasetAmbient: Array<MemeModel> = buildAmbientDataset()

        memeBeats.adapter = MemeAdapter(datasetBeats)
        memeBeats.layoutManager = GridLayoutManager(context, 2)

        memeAmbient.adapter = MemeAdapter(datasetAmbient, uniquePlay = true)
        memeAmbient.layoutManager = GridLayoutManager(context, 2)
        return v
    }

}// Required empty public constructor
