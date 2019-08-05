package com.wesley.fucas

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Catalogo : AppCompatActivity() {

    private var modo : Boolean = false
    private lateinit var list_lojas : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalogo_lojas)
        setSupportActionBar(findViewById(R.id.simple_appbar))


        bindComponents()
        defineMode()

    }

    private fun defineMode() {
        modo = intent.getBooleanExtra("LOGIN",false)
    }

    private fun bindComponents() {
        list_lojas = findViewById(R.id.catalogo_recycler_lojas)
        list_lojas.layoutManager = LinearLayoutManager(this)
        list_lojas.adapter = CatalogoAdapter()
    }

}

