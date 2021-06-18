package com.axweb.chattwo

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.axweb.chattwo.cadastro.view.FormCadastroActivity
import com.axweb.chattwo.databinding.ActivityFormLoginBinding
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_form_login.*

class FormLoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFormLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        checkLoggedInUser()

        binding.btRegistrar.setOnClickListener {
            val intent = Intent(this, FormCadastroActivity::class.java)
            startActivity(intent)
        }
        binding.btLogin.setOnClickListener {
            loggedInUser()
        }
    }

    private fun loggedInUser() {
        val email = edit_email.text.toString()
        val senha = edit_senha.text.toString()

        if (email.isEmpty() || senha.isEmpty()) {
            Toast.makeText(this, "Prencha todos os campos", Toast.LENGTH_LONG).show()
        }else {
            FirebaseAuth.getInstance().signInWithEmailAndPassword(email,senha).addOnCompleteListener {
                if (it.isSuccessful) {
                    openMainScreen()
                }
            }.addOnFailureListener {
                Toast.makeText(this, "Cadastro realizado com sucesso", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun checkLoggedInUser() {
        val currentUser = FirebaseAuth.getInstance().currentUser
        if (currentUser != null) {
            openMainScreen()
        }
    }

    private fun openMainScreen() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun showLoad() {
        progressBar.visibility = View.VISIBLE
    }
    fun hideLoad() {
        progressBar.visibility = View.GONE
    }


}