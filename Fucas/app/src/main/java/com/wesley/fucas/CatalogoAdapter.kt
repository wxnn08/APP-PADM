package com.wesley.fucas

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.wesley.fucas.model.ComerciosDAO
import kotlinx.android.synthetic.main.loja_list_item.view.*

class CatalogoAdapter : RecyclerView.Adapter<CatalogoAdapter.ComerciosViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComerciosViewHolder {
        return ComerciosViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.loja_list_item, parent, false))
    }

    override fun getItemCount(): Int {
        return ComerciosDAO.instance.size()
    }

    override fun onBindViewHolder(holder: ComerciosViewHolder, position: Int) {
        val comercio = ComerciosDAO.getComercioAt(position)
        holder.title.text = comercio.nome
        holder.descricao.text = comercio.descricao
        holder.avaliacao.text = "${comercio.avaliacao}"

        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, InfoComercio::class.java)
            intent.putExtra(App.COMERCIO_POSITION, position)
            ContextCompat.startActivity(it.context, intent, null)
        }
    }


    inner class ComerciosViewHolder(v : View) : RecyclerView.ViewHolder(v) {
        val title = v.list_txt_nome
        val descricao = v.list_txt_descricao
        val avaliacao = v.list_txt_avaliacao
        val avaliar = v.list_button_avaliar
        val custo = v.list_txt_custo
    }
}