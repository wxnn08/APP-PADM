package com.wesley.fucas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wesley.fucas.model.ComerciosDAO
import kotlinx.android.synthetic.main.loja_list_item.view.*

class CatalogoAdapter : RecyclerView.Adapter<CatalogoAdapter.LojaViewHolder>() {

    override fun onBindViewHolder(holder: LojaViewHolder, position: Int) {
        val loja = ComerciosDAO.getLojaAt(position)
        holder.title.text = loja.nome
        holder.descricao.text = loja.descricao
        holder.avaliacao.text = "${(loja.avaliacao/10)}.${loja.avaliacao%10}"
    }

    class LojaViewHolder(v : View) : RecyclerView.ViewHolder(v) {
        val title = v.list_txt_nome
        val descricao = v.list_txt_descricao
        val avaliacao = v.list_txt_avaliacao
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LojaViewHolder {
        return LojaViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.loja_list_item, parent, false))
    }

    override fun getItemCount(): Int {
        return ComerciosDAO.instance.size()
    }
}