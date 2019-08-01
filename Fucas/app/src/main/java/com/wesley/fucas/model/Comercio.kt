package com.wesley.fucas.model

import android.widget.ImageView

class Comercio {
    var nome : String = ""
    var descricao : String = ""
    var avaliacao : Int = 0
    var custo : Int = 0

    constructor(a : String, b : String, c : Int, d : Int) {
        nome = a
        descricao = b
        avaliacao = c
        custo = d
    }
}

