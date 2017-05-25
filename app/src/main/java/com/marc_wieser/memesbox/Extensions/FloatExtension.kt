package com.marc_wieser.memesbox.Extensions

import android.content.Context
import android.util.TypedValue

/**
 * Created by marcw on 25/05/2017.
 */
fun Float.dp(context: Context) = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this, context.resources.displayMetrics)
