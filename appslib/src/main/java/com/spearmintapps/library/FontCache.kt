package com.spearmintapps.library

import android.content.Context
import android.graphics.Typeface

/**
 * Created by Bashar Asaad on 24/6/17.
 */
object FontCache {
    private val fontCache = HashMap<String?, Typeface?>()
    fun getTypeface(fontname: String?, context: Context): Typeface? {
        var typeface = fontCache[fontname]
        if (typeface == null) {
            typeface = try {
                Typeface.createFromAsset(context.assets, fontname)
            } catch (e: Exception) {
                return null
            }
            fontCache[fontname] = typeface
        }
        return typeface
    }
}