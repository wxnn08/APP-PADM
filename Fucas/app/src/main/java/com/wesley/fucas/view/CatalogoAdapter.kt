package com.wesley.fucas.view

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.wesley.fucas.App
import com.wesley.fucas.R
import com.wesley.fucas.model.Comercio
import com.wesley.fucas.model.ComerciosDAO
import com.wesley.fucas.viewmodel.CatalogoViewModel
import kotlinx.android.synthetic.main.list_item_loja.view.*

class CatalogoAdapter (val catalogoViewModel: CatalogoViewModel): RecyclerView.Adapter<CatalogoAdapter.ComerciosViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComerciosViewHolder {
        return ComerciosViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item_loja, parent, false))
    }

    override fun getItemCount(): Int {
        return catalogoViewModel.sizeComercios()
    }

    override fun onBindViewHolder(holder: ComerciosViewHolder, position: Int) {
        val comercio = catalogoViewModel.getComercioAt(position)
        holder.title.text = comercio.nome
        holder.descricao.text = comercio.descricao
        holder.avaliacao.text = comercio.getMediaAvaliacao().toString()
        holder.custo.text = getCustoComercio(comercio)

        holder.avaliar.setOnClickListener {

        }

        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, InfoComercio::class.java)
            intent.putExtra(App.COMERCIO_POSITION, position)
            ContextCompat.startActivity(it.context, intent, null)
        }
    }

    private fun getCustoComercio(comercio: Comercio): String {
        var s = "$"
        var qtd = comercio.getMediaPrecos()
        while (qtd > 0) {
            s += "$"
            qtd--
        }
        return s
    }

    inner class ComerciosViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val title = view.list_txt_nome
        val descricao = view.list_txt_descricao
        val avaliacao = view.list_txt_avaliacao
        val avaliar = view.list_button_avaliar
        val custo = view.list_txt_custo
    }
}