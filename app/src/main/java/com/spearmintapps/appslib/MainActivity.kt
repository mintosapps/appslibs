package com.spearmintapps.appslib

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.spearmintapps.library.interfaces.OnStateChangedListener
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toggleImageView.addStateListener(object : OnStateChangedListener {
            override fun onChecked() {
                toggleImageView_1.setUnchecked()
            }

            override fun onUnchecked() {
                toggleImageView_1.setChecked()
            }
        })
        toggleImageView_1.addStateListener(object : OnStateChangedListener {
            override fun onChecked() {
                toggleImageView.setUnchecked()
            }

            override fun onUnchecked() {
                toggleImageView.setChecked()
            }
        })
    }
}