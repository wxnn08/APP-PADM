package com.wesley.fucas.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wesley.fucas.App
import com.wesley.fucas.R
import com.wesley.fucas.model.ComerciosDAO
import com.wesley.fucas.viewmodel.GerenciarComercioViewModel
import com.wesley.fucas.viewmodel.InfoComercioViewModel


class InfoComercio : AppCompatActivity() {

    private lateinit var list_produtos : RecyclerView
    private lateinit var txt_nome : TextView
    private lateinit var txt_descricao : TextView
    private lateinit var infoComercioViewModel: InfoComercioViewModel
    private var comercioId : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_comercio)

        comercioId = intent.getIntExtra(App.COMERCIO_POSITION, 0)
        infoComercioViewModel = ViewModelProviders.of(this).get(InfoComercioViewModel::class.java)

        bindComponents()
    }

    private fun bindComponents() {
        list_produtos = findViewById(R.id.info_recycler_produtos)
        list_produtos.layoutManager = LinearLayoutManager(this)
        list_produtos.adapter = InfoComercioAdapter(comercioId, infoComercioViewModel)

        txt_nome = findViewById(R.id.gerenciar_txt_nome)
        txt_nome.text = ComerciosDAO.getComercioById(comercioId).nome
        txt_descricao = findViewById(R.id.gerenciar_txt_descricao)
        txt_descricao.text = ComerciosDAO.getComercioById(comercioId).descricao
    }

}
