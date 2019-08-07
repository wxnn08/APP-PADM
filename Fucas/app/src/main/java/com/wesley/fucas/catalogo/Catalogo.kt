package com.wesley.fucas.catalogo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wesley.fucas.App
import com.wesley.fucas.gerenciar.GerenciarComercio
import com.wesley.fucas.R

class Catalogo : AppCompatActivity() {

    private var idLogin : Int = 0
    private lateinit var list_lojas : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalogo_lojas)
        setSupportActionBar(findViewById(R.id.simple_appbar))


        bindComponents()
        defineMode()

    }

    private fun defineMode() {
        idLogin = intent.getIntExtra("LOGIN",0)
    }

    private fun bindComponents() {
        list_lojas = findViewById(R.id.catalogo_recycler_lojas)
        list_lojas.layoutManager = LinearLayoutManager(this)
        list_lojas.adapter = CatalogoAdapter()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.catalogo_menu, menu)

        if(ehComerciante()) {
            menu?.add(0,0,0, "Gerenciar loja")
        }

        menu?.add(0,1,0,"Configurações")
        menu?.add(0, 2, 0, "Sobre")
        return super.onCreateOptionsMenu(menu)
    }

    private fun ehComerciante(): Boolean {
        //Todo: Implementar verificação
        return idLogin > 0
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        0 -> { // Minha loja
            val intent = Intent(App.context, GerenciarComercio::class.java)
            startActivity(intent)
            true
        }
        1 -> { // Configurações
            true
        }
        2 -> { // Sobre
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }

}

