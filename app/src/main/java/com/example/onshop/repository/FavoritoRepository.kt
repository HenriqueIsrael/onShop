package com.example.onshop.repository

import com.example.onshop.dados.FavoritoDAO
import com.example.onshop.model.ModeloFavorito

class FavoritoRepository(private val favoritoDAO: FavoritoDAO) {
    fun getListaProdutosFavoritos(): List<ModeloFavorito>{
        return favoritoDAO.listaProdutosFavorito()
    }
}