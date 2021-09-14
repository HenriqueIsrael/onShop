package com.example.onshop.dados

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.onshop.model.ModeloCarrinho

@Dao
interface CarrinhoDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun inserirProdutoCarrinho(modeloCarrinho: ModeloCarrinho)

    @Query("DELETE FROM ModeloCarrinho WHERE nomeItem = :nomeItem")
    fun deletaProdutoCarrinho(nomeItem: String)

    @Query("SELECT * FROM ModeloCarrinho")
    fun  listaProdutosCarrinho() : List<ModeloCarrinho>
}