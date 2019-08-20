package com.wesley.fucas.model

import android.net.Uri

class Produto(var nome: String, var descricao: String, var valor: Double) {

    var uriFoto : Uri = Uri.EMPTY

    var isChecked : Boolean = true
        private set

    fun existeImagem() : Boolean {
        return uriFoto != Uri.EMPTY
    }

    fun setCheck(state: Boolean) {
        isChecked = state
    }
}
