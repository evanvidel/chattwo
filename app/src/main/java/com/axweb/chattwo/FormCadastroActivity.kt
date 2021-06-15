package com.axweb.chattwo

import android.content.Intent
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.axweb.chattwo.databinding.ActivityFormCadastroBinding

class FormCadastroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFormCadastroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btCadastrar.setOnClickListener {
            val intent = Intent(this, FormSetupActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
