package com.spearmintapps.library

import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import com.spearmintapps.library.interfaces.OnHorizonTouchListener
import kotlin.math.abs

// ClickListener for NEXT button
// When clicked on Button TextSwitcher will switch between texts
// The current Text will go OUT and next text will come in with specified animation
class MyGestureDetector(listener: OnHorizonTouchListener) :
    GestureDetector.SimpleOnGestureListener() {
    private val TAG = MyGestureDetector::class.java.simpleName
    private val horizonTouchListener: OnHorizonTouchListener = listener

    // for touch left or touch right events
    private val SWIPE_MIN_DISTANCE = 30 //default is 120
    private val SWIPE_MAX_OFF_PATH = 400
    private val SWIPE_THRESHOLD_VELOCITY = 50

    override fun onDown(e: MotionEvent): Boolean {
        return true
    }

    override fun onFling(
        e1: MotionEvent,
        e2: MotionEvent,
        velocityX: Float,
        velocityY: Float
    ): Boolean {
        Log.d(
            TAG, " on filing event, first velocityX :" + velocityX +
                    " second velocityY" + velocityY
        )
        try {
            if (abs(e1.y - e2.y) > SWIPE_MAX_OFF_PATH) return false
            if (e1.x - e2.x > SWIPE_MIN_DISTANCE && abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                horizonTouchListener.onHorizonTouch(true) // left
            } else if (e2.x - e1.x > SWIPE_MIN_DISTANCE && abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                horizonTouchListener.onHorizonTouch(false) // right
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return false
    }
}