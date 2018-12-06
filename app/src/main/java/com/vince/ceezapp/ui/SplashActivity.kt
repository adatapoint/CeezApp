package com.vince.ceezapp.ui

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import com.vince.ceezapp.CeezApplication
import com.vince.ceezapp.R
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    private val SPLASH_DURATION = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val randomSplash = (1 until 5).random()

        when (randomSplash) {
            1 -> splashImageView.setImageResource(R.drawable.splash1)
            2 -> splashImageView.setImageResource(R.drawable.splash2)
            3 -> splashImageView.setImageResource(R.drawable.splash3)
            else -> splashImageView.setImageResource(R.drawable.splash4)
        }
        splashImageView.scaleType = ImageView.ScaleType.FIT_XY

        val background = object : Thread() {
            override fun run() {
                try {
                    Thread.sleep(SPLASH_DURATION.toLong())
                    val intent = Intent(baseContext, CeezApplication::class.java)
                    startActivity(intent)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
        background.start()
    }
}
