package com.wesley.fucas.viewmodel

import androidx.lifecycle.ViewModel
import com.wesley.fucas.model.Comercio
import com.wesley.fucas.model.ComerciosDAO

class InfoComercioViewModel : ViewModel() {
    fun getComercioById(id: Int): Comercio {
        return ComerciosDAO.getComercioById(id)
    }

    fun sizeProdutos(idComercio : Int) : Int {
        return ComerciosDAO.getComercioById(idComercio).sizeProdutos()
    }
}