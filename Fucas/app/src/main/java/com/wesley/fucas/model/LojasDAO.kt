package com.wesley.fucas.model

object LojasDAO {
    private val lojas : MutableList<Loja> = ArrayList()
    val instance : LojasDAO = this

    init {
        popularLojas()
    }

    private fun popularLojas() {
        lojas.add(Loja("Just a burguer", "Hamburgueres do webão", 50))
        lojas.add(Loja("Real burguer", "Hamburgueres de alguem, sei la quem", 30))
        lojas.add(Loja("Charlie burguer", "Um socão na sua fome", 32))
        lojas.add(Loja("Just a burguer", "Hamburgueres do webão", 33))
        lojas.add(Loja("Real burguer", "Hamburgueres de alguem, sei la quem", 0))
        lojas.add(Loja("Charlie burguer", "Um socão na sua fome", 20))
        lojas.add(Loja("Just a burguer", "Hamburgueres do webão", 22))
        lojas.add(Loja("Real burguer", "Hamburgueres de alguem, sei la quem", 0))
        lojas.add(Loja("Charlie burguer", "Um socão na sua fome", 33))
        lojas.add(Loja("Just a burguer", "Hamburgueres do webão", 21))
        lojas.add(Loja("Real burguer", "Hamburgueres de alguem, sei la quem", 0))
        lojas.add(Loja("Charlie burguer", "Um socão na sua fome", 7))
    }

    fun getLojaAt(pos : Int) : Loja {
        return lojas[pos]
    }
    fun size() : Int {
        return lojas.size
    }
}