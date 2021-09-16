package com.example.onshop.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.onshop.FuncoesAuxiliares.convertePreco
import com.example.onshop.R
import com.example.onshop.model.ModeloCarrinho
import com.squareup.picasso.Picasso
import java.text.NumberFormat
import java.util.*

class CarrinhoAdapter(
    private val produtosCarrinho: List<ModeloCarrinho>,
    private val cliqueNoProduto: CliqueNoProduto
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount(): Int = produtosCarrinho.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ProdutoCarrinhoViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.modelo_produto_carrinho, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ProdutoCarrinhoViewHolder) {
            holder.bind(produtosCarrinho, position, cliqueNoProduto)
        }
    }

    class ProdutoCarrinhoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val imagem: ImageView = itemView.findViewById(R.id.modelo_produto_carrinho_imagem)
        private val nome: TextView = itemView.findViewById(R.id.modelo_carrinho_produto_nome)
        private val preco: TextView = itemView.findViewById(R.id.modelo_carrinho_carrinho_preco)

        fun bind(
            produtosCarrinho: List<ModeloCarrinho>,
            position: Int,
            cliqueNoProduto: CliqueNoProduto
        ) {
            Picasso.with(imagem.context).load(produtosCarrinho[position].imagem)
                .into(imagem)
            nome.text = produtosCarrinho[position].nomeItem
            preco.text = convertePreco(produtosCarrinho[position].preco.toDouble())
            itemView.setOnClickListener {
                cliqueNoProduto.clicouNoProduto(
                    produtosCarrinho[position].imagem,
                    produtosCarrinho[position].nomeItem,
                    produtosCarrinho[position].descricao,
                    produtosCarrinho[position].preco
                )
            }
        }
    }
}
