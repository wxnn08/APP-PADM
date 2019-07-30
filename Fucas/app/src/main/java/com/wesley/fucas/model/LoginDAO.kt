package com.wesley.fucas.model

import android.util.Log

object LoginDAO {

    private val usuarios : MutableList<Usuario> = ArrayList()
    val instance : LoginDAO = this

    init {
        popularCadastros()
    }

    private fun popularCadastros() {
        usuarios.add(Usuario("wesley.p", "w123123"))
        usuarios.add(Usuario("michel.m", "m123123"))
        usuarios.add(Usuario("andre.s", "a123456"))
    }

    fun existeCadastro(usuarioDigitado : String, senhaDigitada : String) : Boolean {
        Log.d("VERIFICA DIGITADO$ ", "usuario: $usuarioDigitado | senha: $senhaDigitada")
        for(at in usuarios) {
            Log.d("VERIFICA CADASTRO$ ", "usuario: ${at.usuario} | senha: ${at.senha}")
            if(at.usuario == usuarioDigitado && at.senha == senhaDigitada)
                return true
        }
        return false
    }

    fun size() : Int {
        return usuarios.size
    }
}