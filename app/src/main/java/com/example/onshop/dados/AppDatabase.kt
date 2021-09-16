package com.example.onshop.dados

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.onshop.model.ModeloCarrinho
import com.example.onshop.model.ModeloFavorito

@Database(
    entities = [ModeloFavorito::class, ModeloCarrinho::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun favoritoDAO(): FavoritoDAO

    abstract fun carrinhoDAO(): CarrinhoDAO

    companion object {
        private val NOME_DB = "Produtos favoritos"

        fun getInstanceDatabase(context: Context?): AppDatabase {
            return Room
                .databaseBuilder(context!!, AppDatabase::class.java, NOME_DB)
                .build()
        }
    }
}