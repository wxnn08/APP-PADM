package com.wesley.fucas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wesley.fucas.model.ComerciosDAO


class InfoComercio : AppCompatActivity() {

    private lateinit var list_produtos : RecyclerView
    private lateinit var txt_nome : TextView
    private lateinit var txt_descricao : TextView
    private var comercioId : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_comercio)

        comercioId = intent.getIntExtra(App.COMERCIO_POSITION, 0)
        bindComponents()
    }

    private fun bindComponents() {
        list_produtos = findViewById(R.id.info_recycler_produtos)
        list_produtos.layoutManager = LinearLayoutManager(this)
        list_produtos.adapter = ProdutoAdapter(comercioId)
        list_produtos.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        txt_nome = findViewById(R.id.info_txt_nome)
        txt_nome.text = ComerciosDAO.getComercioAt(comercioId).nome
        txt_descricao = findViewById(R.id.info_txt_descricao)
        txt_descricao.text = ComerciosDAO.getComercioAt(comercioId).descricao
    }

}
