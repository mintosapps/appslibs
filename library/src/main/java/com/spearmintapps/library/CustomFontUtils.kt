package com.spearmintapps.library

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.widget.TextView

/**
 * Created by Bashar Asaad on 24/6/17.
 */
object CustomFontUtils {
    fun applyCustomFont(customFontTextView: TextView, context: Context, attrs: AttributeSet?) {
        val attributeArray = context.obtainStyledAttributes(
            attrs,
            R.styleable.CustomFontTextView
        )
        val fontName = attributeArray.getString(R.styleable.CustomFontTextView_customFont)
        // check if a special textStyle was used (e.g. extra bold)
        val customFont = selectTypeface(context, fontName)
        customFontTextView.typeface = customFont
        attributeArray.recycle()
    }

    private fun selectTypeface(context: Context, fontName: String?): Typeface? {
        return FontCache.getTypeface(fontName, context)
    }
}