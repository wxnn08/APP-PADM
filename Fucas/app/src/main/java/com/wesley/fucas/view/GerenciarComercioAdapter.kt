package com.wesley.fucas.view

import android.app.AlertDialog
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.squareup.picasso.Picasso
import com.wesley.fucas.App
import com.wesley.fucas.R
import com.wesley.fucas.model.ComerciosDAO
import com.wesley.fucas.model.Produto
import com.wesley.fucas.viewmodel.GerenciarComercioViewModel
import kotlinx.android.synthetic.main.list_item_gerenciar_produtos.view.*
import kotlinx.android.synthetic.main.list_item_loja.view.*

class GerenciarComercioAdapter (val gerenciarComercio : GerenciarComercio,
                                val gerenciarComercioViewModel: GerenciarComercioViewModel,
                                val idComercio : Int): RecyclerView.Adapter<GerenciarComercioAdapter.GerenciarComercioViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GerenciarComercioViewHolder {
        return GerenciarComercioViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_gerenciar_produtos, parent, false))
    }

    override fun getItemCount(): Int {
        return gerenciarComercioViewModel.sizeProdutos(idComercio)
    }

    override fun onBindViewHolder(holder: GerenciarComercioViewHolder, position: Int) {
        val produto = gerenciarComercioViewModel.getComercioById(idComercio).getProdutoAt(position)
        holder.nome.text = produto.nome
        holder.descricao.text = produto.descricao
        holder.valor.text = "R$ " + String.format("%.2f", produto.valor)
        holder.switch.isChecked = produto.isChecked

        if(produto.existeImagem()) {
            val uri = produto.uriFoto
            Picasso.get().load(uri).into(holder.img)
        }

        holder.switch.setOnCheckedChangeListener { _, b ->
            gerenciarComercioViewModel.changeChecked(idComercio, position, b)
        }

        holder.btnRemover.setOnClickListener {
            removerProduto(position, produto)
        }

        holder.btnEditar.setOnClickListener {
            editarProduto(position)
        }

    }

    private fun editarProduto(position: Int) {
        val intent = Intent(gerenciarComercio, EditarProduto::class.java).apply {
            putExtra(App.COMERCIO_POSITION, idComercio)
            putExtra(App.PRODUTO_POSITION, idComercio)
        }
        ContextCompat.startActivity(gerenciarComercio, intent, null)
    }

    private fun removerProduto(pos: Int, produto: Produto) {
        MaterialAlertDialogBuilder(gerenciarComercio).apply {
            setTitle("Remover produto")
            setMessage("Deseja remover o produto: ${produto.nome} ?")
            setPositiveButton("SIM"){ dialog, _ ->
                gerenciarComercioViewModel.removerProduto(idComercio, pos)
                gerenciarComercio.createSnack(R.string.gerenciar_produto_removido)
                notifyDataSetChanged()
            }
            setNegativeButton("NÃO") { _, _ ->
                gerenciarComercio.createSnack(R.string.gerenciar_produto_cancelado)
            }
        }.create().show()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    inner class GerenciarComercioViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val switch = view.gerenciar_recycler_switch
        val nome = view.gerenciar_recycler_txt_nome
        val descricao = view.gerenciar_recycler_txt_descricao
        val valor = view.gerenciar_recycler_txt_valor
        val img = view.gerenciar_recycler_img_foto
        val btnRemover = view.gerenciar_button_remover
        val btnEditar = view.gerenciar_button_editar
    }
}
