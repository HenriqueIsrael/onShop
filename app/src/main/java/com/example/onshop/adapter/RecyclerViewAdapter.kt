package com.example.onshop.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.onshop.R

class RecyclerViewAdapter(private val ordem: Int, private val posicaoPagina: Int) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
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

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(posicaoPagina==0){
            if (holder is BlocoViewHolder) {
                holder.nomeItem.text = "posicao ${position}"
                holder.imagem.setImageResource(R.drawable.cadeira)
            } else if (holder is ListaViewHolder) {
                holder.nomeItem.text = "posicao ${position}"
                holder.imagem.setImageResource(R.drawable.cadeira)
            }
        } else if(posicaoPagina ==1){
            if (holder is BlocoViewHolder) {
                holder.nomeItem.text = "posicao ${position}"
                holder.imagem.setImageResource(R.drawable.notebook)
            } else if (holder is ListaViewHolder) {
                holder.nomeItem.text = "posicao ${position}"
                holder.imagem.setImageResource(R.drawable.notebook)
            }
        } else if(posicaoPagina==2) {
            if (holder is BlocoViewHolder) {
                holder.nomeItem.text = "posicao ${position}"
                holder.imagem.setImageResource(R.drawable.celular)
            } else if (holder is ListaViewHolder) {
                holder.nomeItem.text = "posicao ${position}"
                holder.imagem.setImageResource(R.drawable.celular)
            }
        }
    }

    override fun getItemCount(): Int {
        return 10
    }

    class BlocoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nomeItem: TextView = itemView.findViewById(R.id.nome_do_item)
        val imagem: ImageView = itemView.findViewById(R.id.imagem_produto_bloco)
    }

    class ListaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nomeItem: TextView = itemView.findViewById(R.id.titulo_produto)
        val imagem: ImageView = itemView.findViewById(R.id.imagem_produto_lista)
    }

}