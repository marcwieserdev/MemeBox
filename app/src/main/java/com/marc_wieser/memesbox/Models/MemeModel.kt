package com.marc_wieser.memesbox.Models

import android.view.View

/**
 * Created by marcw on 22/05/2017.
 */

data class MemeModel(val title : String, val imageResource : Int, val sound : Int, val volume : Float, var isSelected: Boolean = false)