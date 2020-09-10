package com.spearmintapps.appslib

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.spearmintapps.library.interfaces.OnStateChangedListener
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toggleImageView.addStateListener(object : OnStateChangedListener {
            override fun onChecked() {
                Log.d("MAINACTIVITY", "onChecked: ")
            }

            override fun onUnchecked() {
                Log.d("MAINACTIVITY", "onUnchecked: ")
            }
        })
    }
}