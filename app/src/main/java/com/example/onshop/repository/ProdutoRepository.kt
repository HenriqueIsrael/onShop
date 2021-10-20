package com.example.onshop.repository

import com.example.onshop.ApiService
import com.example.onshop.model.Categorias
import com.example.onshop.model.Id
import com.example.onshop.model.Produto

class ProdutoRepository(private val apiService: ApiService) {
    suspend fun getProdutos(categoria: Int): List<Produto> {
        val response = apiService.getProdutos(categoria)
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw Exception("Erro ao fazer requisição dos produtos")
        }
    }
}