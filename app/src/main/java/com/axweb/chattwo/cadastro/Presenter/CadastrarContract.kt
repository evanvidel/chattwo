package com.axweb.chattwo.cadastro.Presenter

interface CadastrarContract {

    interface View{
        fun showLoad()
        fun hideLoad()
    }

    interface Presenter{
        fun registerUser()
        fun goToLoginScreen()

    }
}