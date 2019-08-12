package com.wesley.fucas.model

object ComerciosDAO {
    private val comercios : MutableList<Comercio> = ArrayList()
    val instance : ComerciosDAO = this

    init {
        popularLojas()
    }

    private fun popularLojas() {
        comercios.add(Comercio("Just a burguer", "Hamburgueres do webão"))
        comercios.add(Comercio("Real burguer", "Hamburgueres de alguem, sei la quem"))
        comercios.add(Comercio("Charlie burguer", "Um socão na sua fome"))
        for(i in 0..10)
            comercios[0].produtos.add(Produto("Cookie chocolate", "cookie sabor chocolate. uma delicia!", 12.50))
        for(i in 0..10)
            comercios[1].produtos.add(Produto("Cookie limão", "cookie sabor chocolate. uma delicia!", 23.50))
        for(i in 0..10)
            comercios[2].produtos.add(Produto("Cookie branco", "cookie sabor chocolate. uma delicia!", 40.50))
    }

    fun getComercioAt(pos : Int) : Comercio {
        return comercios[pos]
    }

    fun size() : Int {
        return comercios.size
    }
}