package com.wesley.fucas.model

object LoginDAO {

    private val cadastros : MutableList<Usuario> = ArrayList()
    val instance : LoginDAO = this

    init {
        popularCadastros()
    }

    private fun popularCadastros() {
        cadastros.add(Usuario("wesley.p", "w123123", true, 0))
        cadastros.add(Usuario("michel.m", "m123123", true, 1))
        cadastros.add(Usuario("andre.s", "a123456", false, 2))
    }

    fun idCadastro(usuarioDigitado : String, senhaDigitada : String) : Int {
        for(i in 0 until cadastros.size) {
            val cadastro = cadastros[i]
            if(cadastro.usuario == usuarioDigitado && cadastro.senha == senhaDigitada)
                return i
        }
        return -1
    }

    fun ehComerciante(id: Int) : Boolean {
        if(id >= 0) return cadastros[id].comerciante
        return false
    }

    fun getComercioId(id: Int) : Int {
        return cadastros[id].comercioId
    }

    fun size() : Int {
        return cadastros.size
    }
}