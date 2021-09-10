package com.example.onshop

import com.example.onshop.model.Categorias
import com.example.onshop.model.Produto
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("produtos")
    suspend fun getProdutos(
        @Query("categoria_id") categoria : Int
    ): Response<List<Produto>>

    @GET("categorias")
    suspend fun getCategorias(): Response<List<Categorias>>

    companion object {
        fun getEndPointInstance(): ApiService {
            return Retrofit.Builder()
                .baseUrl("http://10.0.2.2:3000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(ApiService::class.java)
        }
    }
}