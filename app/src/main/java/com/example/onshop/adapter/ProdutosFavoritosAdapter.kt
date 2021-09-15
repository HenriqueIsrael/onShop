package com.example.onshop.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.onshop.R
import com.example.onshop.model.ModeloFavorito
import com.example.onshop.model.Produto
import com.squareup.picasso.Picasso

class ProdutosFavoritosAdapter(
    private val produtosFavoritos: List<ModeloFavorito>,
    private val cliqueNoProduto: CliqueNoProduto
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount(): Int {
        return produtosFavoritos.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val card = LayoutInflater.from(parent.context)
            .inflate(R.layout.modelo_produto_favorito, parent, false)
        return produtoFavoritoViewHolder(card)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is produtoFavoritoViewHolder) {
            Picasso.with(holder.imagem.context).load(produtosFavoritos[position].imagem)
                .into(holder.imagem)
            holder.nome.text = produtosFavoritos[position].nomeItem
            holder.itemView.setOnClickListener {
                cliqueNoProduto.clicouNoProduto(
                    produtosFavoritos[position].imagem,
                    produtosFavoritos[position].nomeItem,
                    produtosFavoritos[position].descricao,
                    produtosFavoritos[position].preco
                )
            }
        }
    }

    class produtoFavoritoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imagem: ImageView = itemView.findViewById(R.id.modelo_produto_favorito_imagem)
        val nome: TextView = itemView.findViewById(R.id.modelo_favorito_produto_nome)
    }

}