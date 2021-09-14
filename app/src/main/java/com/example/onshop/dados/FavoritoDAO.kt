package com.example.onshop.dados

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.onshop.model.ModeloCarrinho
import com.example.onshop.model.ModeloFavorito

@Dao
interface FavoritoDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun inserirFavorito(modeloFavorito: ModeloFavorito)

    @Query("DELETE FROM ModeloFavorito WHERE nomeItem = :nomeItem")
    fun deletaProdutoFavorito(nomeItem: String)

    @Query("SELECT * FROM ModeloFavorito")
    fun  listaProdutosFavorito() : List<ModeloFavorito>

    @Query("SELECT nomeItem FROM  ModeloFavorito WHERE nomeItem = :nomeItem")
    fun verificaProdutoFavorito(nomeItem: String): String
}