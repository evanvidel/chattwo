package com.axweb.chattwo.cadastro.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.axweb.chattwo.FormLoginActivity
import com.axweb.chattwo.databinding.ActivityFormSetupBinding

class FormSetupActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFormSetupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormSetupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnFinish.setOnClickListener {
            backFormLogin()
        }
    }

    private fun backFormLogin() {
        startActivity(Intent(this, FormLoginActivity::class.java))
        finish()
    }
}