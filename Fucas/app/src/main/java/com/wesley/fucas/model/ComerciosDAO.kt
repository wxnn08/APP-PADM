package com.wesley.fucas.model

object ComerciosDAO {
    private val comercios : MutableList<Comercio> = ArrayList()
    val instance : ComerciosDAO = this

    init {
        popularLojas()
    }

    private fun popularLojas() {
        comercios.add(Comercio("Just a burguer", "Hamburgueres do webão", 0))
        comercios.add(Comercio("Real burguer", "Hamburgueres de alguem, sei la quem", 1))
        comercios.add(Comercio("Charlie burguer", "Um socão na sua fome", 2))
        // for(i in 0..1)
        //     comercios[0].produtos.add(Produto("Cookie chocolate $i", "cookie sabor chocolate. uma delicia!", 12.50))
        // for(i in 0..1)
        //     comercios[1].produtos.add(Produto("Cookie limão $i", "cookie sabor chocolate. uma delicia!", 23.50))
        // for(i in 0..1)
        //     comercios[2].produtos.add(Produto("Cookie branco $i", "cookie sabor chocolate. uma delicia!", 40.50))
    }

    fun getComercioById(pos : Int) : Comercio {
        return comercios[pos]
    }

    fun getComercioId(id : Int) : Int {
        for (comercio in comercios) {
            if(comercio.id == id) return comercio.id
        }
        return -1
    }

    fun size() : Int {
        return comercios.size
    }
}