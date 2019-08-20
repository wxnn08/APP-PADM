package com.wesley.fucas.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.wesley.fucas.App
import com.wesley.fucas.R
import com.wesley.fucas.viewmodel.CatalogoViewModel
import kotlinx.android.synthetic.main.activity_catalogo_lojas.*

class Catalogo : AppCompatActivity() {

    var idLogin : Int = App.LOGIN_ID_ANONIMO
    private lateinit var list_lojas : RecyclerView
    private lateinit var catalogoViewModel : CatalogoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalogo_lojas)

        defineMode()

        setSupportActionBar(simple_appbar)

        catalogoViewModel = ViewModelProviders.of(this).get(CatalogoViewModel::class.java)

        bindComponents()
    }

    private fun defineMode() {
        idLogin = intent.getIntExtra(App.LOGIN_EXTRA_ACTIVITY, App.LOGIN_ID_ANONIMO)

    }

    private fun bindComponents() {
        list_lojas = findViewById(R.id.catalogo_recycler_lojas)
        list_lojas.layoutManager = LinearLayoutManager(this)
        list_lojas.adapter = CatalogoAdapter(catalogoViewModel)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.catalogo_menu, menu)

        if(ehComerciante()) menu?.add(0,0,0, R.string.menu_gerenciar_loja)
        //menu?.add(0,1,0, R.string.menu_configuracoes)
        menu?.add(0, 2, 0, R.string.menu_sobre)

        return super.onCreateOptionsMenu(menu)
    }

    private fun ehComerciante(): Boolean {
        return catalogoViewModel.ehComerciante(idLogin)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        0 -> { // Minha loja
            val comercioId = catalogoViewModel.getComercioId(idLogin)
            if(comercioId >= 0) {
                val intent = Intent(App.context, GerenciarComercio::class.java)
                intent.putExtra(App.COMERCIO_POSITION, comercioId)
                startActivity(intent)
            } else {
                createSnack(R.string.catalogo_erro_id_comercio)
            }
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

    private fun createSnack(mensagem: Int) {
        Snackbar.make(
            findViewById(R.id.catalogo_layout),
            mensagem,
            Snackbar.LENGTH_LONG
        ).show()
    }

}

