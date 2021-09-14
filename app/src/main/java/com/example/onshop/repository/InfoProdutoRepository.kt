package com.example.onshop.repository

import com.example.onshop.dados.FavoritoDAO
import com.example.onshop.model.ModeloFavorito

class InfoProdutoRepository(private val favoritoDAO: FavoritoDAO) {
    fun salvaProduto(imagem: String, nomeItem: String, descricao: String, preco: String) {
        favoritoDAO.inserirFavorito(
            ModeloFavorito(
                imagem,
                nomeItem,
                descricao,
                preco
            )
        )
    }

    fun deletaFilme(nomeItem: String) {
        favoritoDAO.deletaProdutoFavorito(nomeItem)
    }

}