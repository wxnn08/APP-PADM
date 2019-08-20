package com.wesley.fucas.viewmodel

import androidx.lifecycle.ViewModel
import com.wesley.fucas.model.LoginDAO

class LoginViewModel : ViewModel() {
    var usuario : String = "wesley.p"
    var senha : String = "w123123"

    fun idCadastro(usuario: String, senha: String): Int {
        return LoginDAO.instance.idCadastro(usuario, senha)
    }



}