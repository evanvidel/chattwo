package com.axweb.chattwo

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.axweb.chattwo.databinding.ActivityFormCadastroBinding
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_form_cadastro.*

class FormCadastroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFormCadastroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btCadastrar.setOnClickListener {
            registerUser()
        }
    }

    private fun registerUser() {
        val email = edit_email.text.toString()
        val senha = edit_senha.text.toString()

        if (email.isEmpty() || senha.isEmpty()) {
            Toast.makeText(this, "Prencha todos os campos", Toast.LENGTH_LONG).show()
        } else {
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,senha).addOnCompleteListener {
                if (it.isSuccessful) {
                    goToLoginScreen()
                    Toast.makeText(this, "Cadastro realizado com sucesso", Toast.LENGTH_LONG).show()
                }
            }.addOnFailureListener {
                Toast.makeText(this, "Erro ao logar usuário",Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun goToLoginScreen() {
        startActivity(Intent(this, FormSetupActivity::class.java))
        finish()
    }
}
