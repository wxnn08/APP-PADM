package com.wesley.fucas.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.wesley.fucas.R
import com.wesley.fucas.model.ComerciosDAO
import com.wesley.fucas.viewmodel.InfoComercioViewModel
import kotlinx.android.synthetic.main.list_item_info_produto.view.*

class InfoComercioAdapter(val idComercio : Int, val infoComercioViewModel: InfoComercioViewModel)
    : RecyclerView.Adapter<InfoComercioAdapter.ProdutosViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutosViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_info_produto, parent, false)
        return ProdutosViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return infoComercioViewModel.sizeProdutos(idComercio)
    }

    override fun onBindViewHolder(holder: ProdutosViewHolder, position: Int) {
        val produto = infoComercioViewModel.getComercioById(idComercio).getProdutoAt(position)
        holder.nome?.text = produto.nome
        holder.descricao?.text = produto.descricao
        holder.valor?.text = "R$ " + String.format("%.2f", produto.valor)
        if(produto.existeImagem()) {
            val uri = ComerciosDAO.getComercioById(idComercio).getProdutoAt(position).uriFoto
            Picasso.get().load(uri).into(holder.img)
        }

        if(!produto.isChecked) holder.card.visibility =  View.GONE

    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    class ProdutosViewHolder (v : View) : RecyclerView.ViewHolder(v) {
        val nome : TextView? = v.produto_txt_nome
        val descricao : TextView? = v.produto_txt_descricao
        val valor : TextView? = v.produto_txt_valor
        val card : CardView = v.produto_card_item
        val img : ImageView = v.produto_img_foto
    }
}
