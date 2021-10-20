package com.example.onshop.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.onshop.FuncoesAuxiliares.convertePreco
import com.example.onshop.R
import com.example.onshop.fragments.ProdutosFragment
import com.example.onshop.model.Produto
import com.squareup.picasso.Picasso
import java.text.NumberFormat
import java.util.*

class ProdutosRecyclerViewDestaquesAdapter(
    private val listaProdutos: List<Produto>,
    private val ordem: Int,
    private val cliqueNoProduto: CliqueNoProduto
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount(): Int = listaProdutos.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (ordem == 1) {
            return ListaViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.modelo_item_lista, parent, false)
            )
        }
        return BlocoViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.modelo_item_bloco, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is BlocoViewHolder) {
            holder.bind(listaProdutos,position,cliqueNoProduto)
        } else if (holder is ListaViewHolder) {
            holder.bind(listaProdutos,position,cliqueNoProduto)
        }
    }

    class BlocoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val nomeItem: TextView = itemView.findViewById(R.id.nome_produto_bloco)
        private val imagem: ImageView = itemView.findViewById(R.id.imagem_produto_bloco)
        private val descricao: TextView = itemView.findViewById(R.id.descricao_produto_bloco)
        private val preco: TextView = itemView.findViewById(R.id.preco_produto_bloco)

        fun bind(listaProdutos: List<Produto>, position: Int, cliqueNoProduto: CliqueNoProduto) {
            nomeItem.text = listaProdutos[position].name
            preco.text = convertePreco(listaProdutos[position].price)
            descricao.text = listaProdutos[position].description
            Picasso.with(imagem.context).load(listaProdutos[position].image)
                .into(imagem)
            itemView.setOnClickListener {
                cliqueNoProduto.clicouNoProduto(
                    listaProdutos[position].image,
                    listaProdutos[position].name,
                    listaProdutos[position].description,
                    listaProdutos[position].price.toString()
                )
            }
        }

    }

    class ListaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val nomeItem: TextView = itemView.findViewById(R.id.nome_produto_lista)
        private val imagem: ImageView = itemView.findViewById(R.id.imagem_produto_lista)
        private val descricao: TextView = itemView.findViewById(R.id.descricao_produto_lista)
        private val preco: TextView = itemView.findViewById(R.id.preco_produto_lista)

        fun bind(listaProdutos: List<Produto>, position: Int, cliqueNoProduto: CliqueNoProduto) {
            nomeItem.text = listaProdutos[position].name
            preco.text = convertePreco(listaProdutos[position].price)
            descricao.text = listaProdutos[position].description
            Picasso.with(imagem.context).load(listaProdutos[position].image)
                .into(imagem)
            itemView.setOnClickListener {
                cliqueNoProduto.clicouNoProduto(
                    listaProdutos[position].image,
                    listaProdutos[position].name,
                    listaProdutos[position].description,
                    listaProdutos[position].price.toString()
                )
            }
        }
    }
}