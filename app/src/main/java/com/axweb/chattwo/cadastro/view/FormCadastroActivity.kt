package com.axweb.chattwo.cadastro.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.axweb.chattwo.cadastro.Presenter.CadastrarContract
import com.axweb.chattwo.cadastro.Presenter.CadastrarPresenter
import com.axweb.chattwo.databinding.ActivityFormCadastroBinding
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_form_cadastro.edit_email
import kotlinx.android.synthetic.main.activity_form_cadastro.edit_senha
import kotlinx.android.synthetic.main.activity_form_login.*

class FormCadastroActivity : AppCompatActivity(), CadastrarContract.View {

    private val presenter = CadastrarPresenter(this)

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
                    showLoad()
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
    override fun showLoad() {
        progressBar.visibility = View.VISIBLE
    }
    override fun hideLoad() {
        progressBar.visibility = View.GONE
    }

}
