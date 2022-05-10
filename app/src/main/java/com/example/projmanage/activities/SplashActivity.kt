package com.example.projmanage.activities

import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import androidx.core.content.ContextCompat.startActivity
import com.example.projmanage.R
import com.example.projmanage.firebase.FireStore
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        val typeface: Typeface =
            Typeface.createFromAsset(assets, "carbon bl.ttf")
        tv_app_name.typeface = typeface


        Handler().postDelayed({
            // Start the Intro Activity

            var currentUserId=FireStore().getCurrentUserID()
            if(currentUserId.isNotEmpty()){
                startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            }
            else {
                startActivity(Intent(this@SplashActivity, IntroActivity::class.java))
            }
            finish()
        }, 2500) // Here we pass the delay time in milliSeconds after which the splash activity will d
    }
}