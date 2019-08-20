package com.wesley.fucas.model

import kotlin.math.floor

class Comercio( var nome: String, var descricao: String, var id: Int) {
    var avaliacao: Double = 5.0    // Avaliação: valor entre 0 e 50 (será dividido por 10 para formar uma nota entre 0,0 e 5,0)
    var custo: Int = 0             // Com base na média dos produtos. A cada R$10,00 acrescenta-se um simbolo '$'
    var produtos: ArrayList<Produto> = ArrayList()
    var qtdAvaliacao: Int = 0

    fun getProdutoAt(pos: Int): Produto {
        return produtos[pos]
    }

    fun getMediaPrecos(): Int {
        var media = 0.0
        for (produto in produtos) {
            media += produto.valor
        }
        media /= produtos.size
        return floor(media / 10).toInt()
    }

    fun changeMediaAvaliacao() {

    }

    fun getMediaAvaliacao() : Double {
        return avaliacao
    }

    fun sizeProdutos(): Int {
        return produtos.size
    }

    fun add(produto: Produto) {
        produtos.add(produto)
    }

    fun removerProduto(pos: Int) {
        produtos.removeAt(pos)
    }
}

