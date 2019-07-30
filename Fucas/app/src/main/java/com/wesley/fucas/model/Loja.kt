package com.wesley.fucas.model

import android.widget.ImageView

class Loja {
    var nome : String = ""
    var descricao : String = ""
    var avaliacao : Int = 0

    constructor(a : String, b : String, c : Int) {
        nome = a
        descricao = b
        avaliacao = c
    }
}

