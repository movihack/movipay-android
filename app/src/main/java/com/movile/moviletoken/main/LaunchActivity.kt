package com.movile.moviletoken.main

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.movile.moviletoken.R

class LaunchActivity : AppCompatActivity() {

    private val SPLASH_TIME_OUT = 3000


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.launch_activity)

        Handler().postDelayed(Runnable {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)

            finish()
        }, SPLASH_TIME_OUT.toLong());

    }

}