package com.example.onshop.model

data class Produto (
    val id: Int,
    val imagem: String,
    val nome : String,
    val descricao: String,
    val preco: Double,
    val categoriaId: Int
)