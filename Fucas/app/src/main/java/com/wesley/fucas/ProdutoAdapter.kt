package com.wesley.fucas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.wesley.fucas.model.ComerciosDAO
import kotlinx.android.synthetic.main.produto_list_item.view.*

class ProdutoAdapter(var comercioId : Int) : RecyclerView.Adapter<ProdutoAdapter.ProdutosViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutosViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.produto_list_item, parent, false)
        return ProdutosViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return ComerciosDAO.instance.getComercioAt(comercioId).produtos.size
    }

    override fun onBindViewHolder(holder: ProdutosViewHolder, position: Int) {
        val produtos = ComerciosDAO.instance.getComercioAt(comercioId).getProdutoAt(position)
        holder.nome?.text = produtos.nome
        holder.descricao?.text = produtos.descricao
        holder.valor?.text = "R$ " + String.format("%.2f", produtos.valor)
    }

    class ProdutosViewHolder (v : View) : RecyclerView.ViewHolder(v) {
        val nome : TextView? = v.produto_txt_nome
        val descricao : TextView? = v.produto_txt_descricao
        val valor : TextView? = v.produto_txt_valor
    }
}
