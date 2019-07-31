package com.wesley.fucas.model

object ComerciosDAO {
    private val comercios : MutableList<Comercio> = ArrayList()
    val instance : ComerciosDAO = this

    init {
        popularLojas()
    }

    private fun popularLojas() {
        comercios.add(Comercio("Just a burguer", "Hamburgueres do webão", 50))
        comercios.add(Comercio("Real burguer", "Hamburgueres de alguem, sei la quem", 30))
        comercios.add(Comercio("Charlie burguer", "Um socão na sua fome", 32))
        comercios.add(Comercio("Just a burguer", "Hamburgueres do webão", 33))
        comercios.add(Comercio("Real burguer", "Hamburgueres de alguem, sei la quem", 0))
        comercios.add(Comercio("Charlie burguer", "Um socão na sua fome", 20))
        comercios.add(Comercio("Just a burguer", "Hamburgueres do webão", 22))
        comercios.add(Comercio("Real burguer", "Hamburgueres de alguem, sei la quem", 0))
        comercios.add(Comercio("Charlie burguer", "Um socão na sua fome", 33))
        comercios.add(Comercio("Just a burguer", "Hamburgueres do webão", 21))
        comercios.add(Comercio("Real burguer", "Hamburgueres de alguem, sei la quem", 0))
        comercios.add(Comercio("Charlie burguer", "Um socão na sua fome", 7))
    }

    fun getLojaAt(pos : Int) : Comercio {
        return comercios[pos]
    }
    fun size() : Int {
        return comercios.size
    }
}