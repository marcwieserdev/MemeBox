package com.marc_wieser.memesbox.Extensions

import android.media.AudioManager
import android.media.MediaPlayer

/**
 * Created by marcw on 23/05/2017.
 */
fun MediaPlayer.volume(volume: Float) : Unit = setVolume(volume, volume)