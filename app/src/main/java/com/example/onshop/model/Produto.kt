package com.example.onshop.model

data class Produto (
    val id: Int,
    val image: String,
    val name : String,
    val description: String,
    val price: Double,
    val categoryId: Int
)