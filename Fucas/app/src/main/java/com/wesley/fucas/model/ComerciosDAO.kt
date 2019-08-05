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
        comercios.add(Comercio("Just a burguer", "Hamburgueres do webão"))
        comercios.add(Comercio("Real burguer", "Hamburgueres de alguem, sei la quem"))
        comercios.add(Comercio("Charlie burguer", "Um socão na sua fome"))
        comercios.add(Comercio("Just a burguer", "Hamburgueres do webão"))
        comercios.add(Comercio("Real burguer", "Hamburgueres de alguem, sei la quem"))
        comercios.add(Comercio("Charlie burguer", "Um socão na sua fome"))
        comercios.add(Comercio("Just a burguer", "Hamburgueres do webão"))
        comercios.add(Comercio("Real burguer", "Hamburgueres de alguem, sei la quem"))
        comercios.add(Comercio("Charlie burguer", "Um socão na sua fome"))
        comercios[0].produtos.add(Produto("Cookie chocolate", "cookie sabor chocolate. uma delicia!", 2.50))
        comercios[0].produtos.add(Produto("Cookie chocolate", "cookie sabor chocolate. uma delicia!", 2.50))
        comercios[0].produtos.add(Produto("Cookie chocolate", "cookie sabor chocolate. uma delicia!", 2.50))
        comercios[1].produtos.add(Produto("Cookie limão", "cookie sabor chocolate. uma delicia!", 3.50))
        comercios[1].produtos.add(Produto("Cookie limão", "cookie sabor chocolate. uma delicia!", 3.50))
        comercios[1].produtos.add(Produto("Cookie limão", "cookie sabor chocolate. uma delicia!", 3.50))
        comercios[2].produtos.add(Produto("Cookie branco", "cookie sabor chocolate. uma delicia!", 4.50))
        comercios[2].produtos.add(Produto("Cookie branco", "cookie sabor chocolate. uma delicia!", 4.50))
        comercios[2].produtos.add(Produto("Cookie branco", "cookie sabor chocolate. uma delicia!", 4.50))
    }

    fun getComercioAt(pos : Int) : Comercio {
        return comercios[pos]
    }

    fun size() : Int {
        return comercios.size
    }
}