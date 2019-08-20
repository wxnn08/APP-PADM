package com.wesley.fucas.view

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import com.wesley.fucas.R

import kotlinx.android.synthetic.main.activity_editar_produto.*

class EditarProduto : AppCompatActivity() {

    private lateinit var txtNome : EditText
    private lateinit var txtDescricao : EditText
    private lateinit var txtValor : EditText
    private lateinit var imgImagem : ImageView
    private lateinit var btnCapturar : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar_produto)
        setSupportActionBar(toolbar)


    }

}
