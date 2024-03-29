package com.wesley.fucas.viewmodel

import androidx.lifecycle.ViewModel
import com.wesley.fucas.model.Comercio
import com.wesley.fucas.model.ComerciosDAO

class GerenciarComercioViewModel : ViewModel() {
    fun getComercioById(id: Int): Comercio {
        return ComerciosDAO.getComercioById(id)
    }

    fun sizeProdutos(idComercio : Int) : Int {
        return ComerciosDAO.getComercioById(idComercio).sizeProdutos()
    }

    fun changeChecked(idComercio: Int, idProduto: Int, switchState: Boolean) {
        ComerciosDAO.getComercioById(idComercio).getProdutoAt(idProduto).setCheck(switchState)
    }

    fun removerProduto(idComercio: Int, pos: Int) {
        ComerciosDAO.getComercioById(idComercio).removerProduto(pos)
    }

}