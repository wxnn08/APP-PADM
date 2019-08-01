package com.wesley.fucas.model

object ComerciosDAO {
    private val comercios : MutableList<Comercio> = ArrayList()
    val instance : ComerciosDAO = this

    init {
        popularLojas()
    }

    private fun popularLojas() {
        comercios.add(Comercio("Just a burguer", "Hamburgueres do webão", 50, 2))
        comercios.add(Comercio("Real burguer", "Hamburgueres de alguem, sei la quem", 30, 3))
        comercios.add(Comercio("Charlie burguer", "Um socão na sua fome", 32, 1))
        comercios.add(Comercio("Just a burguer", "Hamburgueres do webão", 33, 2))
        comercios.add(Comercio("Real burguer", "Hamburgueres de alguem, sei la quem", 0, 1))
        comercios.add(Comercio("Charlie burguer", "Um socão na sua fome", 20, 2))
        comercios.add(Comercio("Just a burguer", "Hamburgueres do webão", 22, 1))
        comercios.add(Comercio("Real burguer", "Hamburgueres de alguem, sei la quem", 0, 2))
        comercios.add(Comercio("Charlie burguer", "Um socão na sua fome", 33, 1))
        comercios.add(Comercio("Just a burguer", "Hamburgueres do webão", 21, 3))
        comercios.add(Comercio("Real burguer", "Hamburgueres de alguem, sei la quem", 0, 2))
        comercios.add(Comercio("Charlie burguer", "Um socão na sua fome", 7, 1))
    }

    fun getLojaAt(pos : Int) : Comercio {
        return comercios[pos]
    }
    fun size() : Int {
        return comercios.size
    }
}