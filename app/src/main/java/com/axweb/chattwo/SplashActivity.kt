package com.axweb.chattwo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({
        openFormLogin()
        },3000)
    }

    private fun openFormLogin() {
        val intent = Intent(this, FormLoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}