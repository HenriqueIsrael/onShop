package com.example.onshop.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ModeloFavorito(
    val imagem: String,
    val nomeItem: String
){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
