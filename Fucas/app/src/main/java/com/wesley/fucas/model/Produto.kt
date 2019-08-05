package com.wesley.fucas.model

import android.widget.ImageView

class Produto {
    var nome : String = "Sem nome"
    var descricao : String = "Sem descrição"
    var valor : Double = 0.0
    lateinit var foto : ImageView

    constructor(nome:String, descricao:String, valor:Double) {
        this.nome = nome
        this.descricao = descricao
        this.valor = valor
    }
}
