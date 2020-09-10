package com.spearmintapps.library

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import com.spearmintapps.library.interfaces.OnStateChangedListener


class ToggleImageView : AppCompatImageView, View.OnClickListener {
    private var mState = UNCHECKED

    private var mCheckedRes = 0
    private var mUncheckedRes = 0
    private var deaktivate = false
    private var mCallbacks: OnStateChangedListener? = null

    constructor(context: Context) : super(context)

    constructor (context: Context, attrs: AttributeSet?) : super(context, attrs) {
        val typedArray =
            context.theme.obtainStyledAttributes(attrs, R.styleable.ToggleImageView, 0, 0)
        try {
            mCheckedRes = typedArray.getResourceId(R.styleable.ToggleImageView_src_checked, 0)
            mUncheckedRes = typedArray.getResourceId(R.styleable.ToggleImageView_src_unchecked, 0)
            deaktivate =
                typedArray.getBoolean(R.styleable.ToggleImageView_deaktivate_uncheck, false)
        } finally {
            typedArray.recycle()
        }
        if (mUncheckedRes != 0) setImage(mUncheckedRes)
        setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (mState == CHECKED) {
            if (deaktivate) return
            mState = UNCHECKED

            setImage(mUncheckedRes)

            mCallbacks?.onUnchecked()

        } else {
            mState = CHECKED

            setImage(mCheckedRes)

            mCallbacks?.onChecked()
        }
    }

    private fun setImage(resID: Int) {
        if (resID != 0) {
            setImageResource(resID)
        } else {
            Log.i(TAG, "setImage: No image resource provided")
        }
    }

    fun addStateListener(l: OnStateChangedListener) {
        mCallbacks = l
    }

    fun setChecked() {
        setChecked(false)
    }

    fun setUnchecked() {
        setUnchecked(false)
    }

    fun setChecked(callback: Boolean) {
        mState = CHECKED
        setImage(mCheckedRes)
        if (callback) mCallbacks!!.onChecked()
    }

    fun setUnchecked(callback: Boolean) {
        mState = UNCHECKED
        setImage(mUncheckedRes)
        if (callback) mCallbacks!!.onUnchecked()
    }

    fun getState(): Int {
        return mState
    }

    companion object {
        private const val CHECKED = 1
        private const val UNCHECKED = 2
        private const val TAG = "ToggleImageView"
    }

}