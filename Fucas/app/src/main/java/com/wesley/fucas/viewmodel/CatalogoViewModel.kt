package com.wesley.fucas.viewmodel

import androidx.lifecycle.ViewModel
import com.wesley.fucas.model.Comercio
import com.wesley.fucas.model.ComerciosDAO
import com.wesley.fucas.model.LoginDAO

class CatalogoViewModel : ViewModel() {
    fun ehComerciante(id: Int): Boolean {
        return LoginDAO.ehComerciante(id)
    }

    fun getComercioId(id: Int): Int {
        return ComerciosDAO.getComercioId(id)
    }

    fun getComercioAt(id: Int): Comercio {
        return ComerciosDAO.getComercioById(id)
    }

    fun sizeComercios(): Int {
        return ComerciosDAO.size()
    }

}