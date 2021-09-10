package com.example.onshop.repository

import com.example.onshop.ApiService
import com.example.onshop.model.Categorias

class HomeRepository (private val apiService: ApiService){
    suspend fun getCategorias(): List<Categorias> {
        val response = apiService.getCategorias()
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw Exception("Erro ao fazer requisição das categorias")
        }
    }
}