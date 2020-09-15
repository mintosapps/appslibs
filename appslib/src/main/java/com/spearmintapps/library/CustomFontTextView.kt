package com.spearmintapps.library

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

/**
 * Created by Bashar Asaad on 24/6/17.
 */
class CustomFontTextView : AppCompatTextView {
    constructor(context: Context) : super(context) {
        CustomFontUtils.applyCustomFont(this, context, null)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        CustomFontUtils.applyCustomFont(this, context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
        CustomFontUtils.applyCustomFont(this, context, attrs)
    }
}