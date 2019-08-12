package com.wesley.fucas.view

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView
import com.wesley.fucas.App
import com.wesley.fucas.R

import kotlinx.android.synthetic.main.activity_gerenciar_comercio.*

class GerenciarComercio : AppCompatActivity() {


    private lateinit var list_produtos : RecyclerView
    private lateinit var txt_nome : TextView
    private lateinit var txt_descricao : TextView
    private var comercioId : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gerenciar_comercio)
        setSupportActionBar(toolbar)

        comercioId = intent.getIntExtra(App.COMERCIO_POSITION, 0)

        fab.setOnClickListener { view ->
            startActivity(Intent(this, AdicionarProduto::class.java))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.catalogo_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
}
