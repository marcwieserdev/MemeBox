package com.marc_wieser.memesbox

import android.media.MediaPlayer
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageButton


/**
 * Created by marcw on 22/05/2017.
 */

class MemeAdapter(private var dataset: Array<MemeModel>) : RecyclerView.Adapter<MemeAdapter.ViewHolder>() {
    private val TYPE_MEME : Int = 1

    class ViewHolder(view: ImageButton) : RecyclerView.ViewHolder(view)

    override fun getItemCount(): Int = dataset.size

    override fun getItemViewType(position: Int): Int = TYPE_MEME

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val model : MemeModel = dataset[position]
        val image : ImageButton = holder?.itemView as ImageButton
        image.setImageDrawable(ContextCompat.getDrawable(holder.itemView?.context, model.imageResource))
        image.setOnClickListener {
            val player: MediaPlayer = MediaPlayer.create(holder.itemView.context, model.sound)
            player.setOnCompletionListener { player.release() }
            player.start()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return when(viewType){
            TYPE_MEME -> {
                val inflater = LayoutInflater.from(parent?.context)
                val layout = inflater.inflate(R.layout.item_actionbtn, parent, false)
                ViewHolder(layout as ImageButton)
            }
            else -> throw UnsupportedOperationException()
        }
    }


}