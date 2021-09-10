package com.example.onshop.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.onshop.R
import com.example.onshop.model.Produto
import com.squareup.picasso.Picasso
import java.text.NumberFormat
import java.util.*

class RecyclerViewAdapter(
    private val listaProdutos: List<Produto>,
    private val ordem: Int
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    //Qual layout vai ser usado
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (ordem == 1) {
            return ListaViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.modelo_item_lista, parent, false)
            )
        } else {
            return BlocoViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.modelo_item_bloco, parent, false)
            )
        }

    }

    //Pega os dados e exibe na tela
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is BlocoViewHolder) {
            holder.nomeItem.text = listaProdutos[position].nome
            holder.preco.text = convertePreco(listaProdutos[position].preco)
            holder.descricao.text = listaProdutos[position].descricao
            Picasso.with(holder.imagem.context).load(listaProdutos[position].imagem)
                .into(holder.imagem)
        } else if (holder is ListaViewHolder) {
            holder.nomeItem.text = listaProdutos[position].nome
            holder.preco.text = convertePreco(listaProdutos[position].preco)
            holder.descricao.text = listaProdutos[position].descricao
            Picasso.with(holder.imagem.context).load(listaProdutos[position].imagem)
                .into(holder.imagem)
        }
    }


    override fun getItemCount(): Int {
        return listaProdutos.size
    }

    class BlocoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nomeItem: TextView = itemView.findViewById(R.id.nome_produto_bloco)
        val imagem: ImageView = itemView.findViewById(R.id.imagem_produto_bloco)
        val descricao: TextView = itemView.findViewById(R.id.descricao_produto_bloco)
        val preco: TextView = itemView.findViewById(R.id.preco_produto_bloco)
    }

    class ListaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nomeItem: TextView = itemView.findViewById(R.id.nome_produto_lista)
        val imagem: ImageView = itemView.findViewById(R.id.imagem_produto_lista)
        val descricao: TextView = itemView.findViewById(R.id.descricao_produto_lista)
        val preco: TextView = itemView.findViewById(R.id.preco_produto_lista)
    }

    fun convertePreco(preco: Double): String {
        return NumberFormat.getCurrencyInstance(Locale("pt", "BR"))
            .format(preco)
    }

}