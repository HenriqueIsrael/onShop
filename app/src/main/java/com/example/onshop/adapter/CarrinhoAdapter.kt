package com.example.onshop.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.onshop.R
import com.example.onshop.model.ModeloCarrinho
import com.squareup.picasso.Picasso
import java.text.NumberFormat
import java.util.*

class CarrinhoAdapter(
    private val produtosCarrinho: List<ModeloCarrinho>,
    private val cliqueNoProduto: CliqueNoProduto
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount(): Int {
        return produtosCarrinho.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val card = LayoutInflater.from(parent.context)
            .inflate(R.layout.modelo_produto_carrinho,parent, false)
        return produtoCarrinhoViewHolder(card)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is produtoCarrinhoViewHolder){
            Picasso.with(holder.imagem.context).load(produtosCarrinho[position].imagem)
                .into(holder.imagem)
            holder.nome.text = produtosCarrinho[position].nomeItem
            holder.preco.text = convertePreco(produtosCarrinho[position].preco.toDouble())
            holder.itemView.setOnClickListener {
                cliqueNoProduto.clicouNoProduto(
                    produtosCarrinho[position].imagem,
                    produtosCarrinho[position].nomeItem,
                    produtosCarrinho[position].descricao,
                    produtosCarrinho[position].preco
                )
            }
        }
    }

    class produtoCarrinhoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imagem: ImageView = itemView.findViewById(R.id.modelo_produto_carrinho_imagem)
        val nome: TextView = itemView.findViewById(R.id.modelo_carrinho_produto_nome)
        val preco: TextView = itemView.findViewById(R.id.modelo_carrinho_carrinho_preco)
    }
    fun convertePreco(preco: Double): String {
        return NumberFormat.getCurrencyInstance(Locale("pt", "BR"))
            .format(preco)
    }
}