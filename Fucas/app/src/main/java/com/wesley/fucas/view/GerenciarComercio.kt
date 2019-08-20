package com.wesley.fucas.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.wesley.fucas.App
import com.wesley.fucas.R
import com.wesley.fucas.model.Comercio
import com.wesley.fucas.viewmodel.GerenciarComercioViewModel

import kotlinx.android.synthetic.main.activity_gerenciar_comercio.*

class GerenciarComercio : AppCompatActivity() {

    private lateinit var gerenciarComercioViewModel : GerenciarComercioViewModel

    private lateinit var recycler_produtos : RecyclerView
    private lateinit var txt_nome : TextView
    private lateinit var txt_descricao : TextView
    private lateinit var btn_adicionar: Button
    private lateinit var container_top : ConstraintLayout
    private lateinit var comercio : Comercio
    private var idComercio : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gerenciar_comercio)
        setSupportActionBar(toolbar)

        gerenciarComercioViewModel = ViewModelProviders.of(this).get(GerenciarComercioViewModel::class.java)

        idComercio = intent.getIntExtra(App.COMERCIO_POSITION, -1)
        comercio = gerenciarComercioViewModel.getComercioById(idComercio)

        bindComponents()
        setComponents()
    }

    override fun onStart() {
        super.onStart()
        (recycler_produtos.adapter as GerenciarComercioAdapter).notifyDataSetChanged()
    }

    private fun setComponents() {
        // Ação do Floating button
        btn_adicionar.setOnClickListener {
            startActivity(Intent(this, AdicionarProduto::class.java).apply {
                putExtra(App.COMERCIO_POSITION, idComercio)
            })
        }

        txt_nome.text = comercio.nome
        txt_descricao.text = comercio.descricao

        recycler_produtos.layoutManager = LinearLayoutManager(this)
        recycler_produtos.adapter = GerenciarComercioAdapter(this, gerenciarComercioViewModel, idComercio)
    }

    private fun bindComponents() {
        txt_nome = findViewById(R.id.gerenciar_txt_nome)
        txt_descricao = findViewById(R.id.gerenciar_txt_descricao)
        btn_adicionar = findViewById(R.id.gerenciar_button_adicionar)
        container_top = findViewById(R.id.top_info)
        recycler_produtos = findViewById(R.id.gerenciar_recycler_produtos)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.catalogo_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    fun createSnack(mensagem: Int) {
        Snackbar.make(
            findViewById(R.id.gerenciar_layout),
            mensagem,
            Snackbar.LENGTH_LONG
        ).show()
    }

}
