package com.example.onshop.dados

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.onshop.model.ModeloFavorito

@Dao
interface FavoritoDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun inserirFavorito(modeloFavorito: ModeloFavorito)

    @Query("DELETE FROM ModeloFavorito WHERE nomeItem = :nomeItem")
    fun deletaProdutoFavorito(nomeItem: String)
}