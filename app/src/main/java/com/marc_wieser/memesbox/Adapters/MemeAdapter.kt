package com.marc_wieser.memesbox.Adapters

import android.content.res.ColorStateList
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.media.MediaPlayer
import android.os.Build
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import com.marc_wieser.memesbox.Extensions.dp
import com.marc_wieser.memesbox.Extensions.volume
import com.marc_wieser.memesbox.Models.MemeModel
import com.marc_wieser.memesbox.R


/**
 * Created by marcw on 22/05/2017.
 */

class MemeAdapter(private var dataset: Array<MemeModel>, val uniquePlay : Boolean = false) : RecyclerView.Adapter<MemeAdapter.ViewHolder>() {
    private val TYPE_MEME : Int = 1

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val soundBtn: ImageButton = view.findViewById(R.id.action_image) as ImageButton
        val favouriteBtn: ImageButton = view.findViewById(R.id.fav_btn) as ImageButton
    }

    override fun getItemCount(): Int = dataset.size

    override fun getItemViewType(position: Int): Int = TYPE_MEME

    fun updateViewOverlay(imageButton: ImageButton, isSelected: Boolean) {
        return //TODO : Find a way to have a nice light overlay on all ImageButton when selected
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model : MemeModel = dataset[position]
        val image : ImageButton = holder.soundBtn
        var player: MediaPlayer? = null
        image.setImageDrawable(ContextCompat.getDrawable(holder.itemView?.context, model.imageResource))
        image.setOnClickListener {
            if (uniquePlay && player != null)
            {
                player?.stop()
                player?.release()
                player = null
                model.isSelected = false
                updateViewOverlay(image, model.isSelected)
            } else {
                player = MediaPlayer.create(holder.itemView?.context, model.sound)
                player?.setOnCompletionListener {
                    if (it == player)
                        model.isSelected = false
                    it.release()
                    player = null

                    updateViewOverlay(image, model.isSelected)
                }
                player?.volume(model.volume)
                model.isSelected = true
                player?.start()
                updateViewOverlay(image, model.isSelected)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return when(viewType){
            TYPE_MEME -> {
                val inflater = LayoutInflater.from(parent?.context)
                val layout = inflater.inflate(R.layout.item_actionbtn, parent, false)
                ViewHolder(layout)
            }
            else -> throw UnsupportedOperationException()
        }
    }


}