package com.example.onshop.repository

import com.example.onshop.dados.FavoritoDAO
import com.example.onshop.model.ModeloFavorito
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FavoritoRepository(private val favoritoDAO: FavoritoDAO) {

    suspend fun getListaProdutosFavoritos(): List<ModeloFavorito>{
        return withContext(Dispatchers.IO) {
            favoritoDAO.listaProdutosFavorito()
        }
    }
}