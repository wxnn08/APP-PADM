package com.wesley.fucas.viewmodel

import androidx.lifecycle.ViewModel
import com.wesley.fucas.model.ComerciosDAO
import com.wesley.fucas.model.Produto

class AdicionarProdutoViewModel : ViewModel() {
    fun addProduto(idComercio : Int, produto: Produto) {
        ComerciosDAO.getComercioById(idComercio).add(produto)
    }

}