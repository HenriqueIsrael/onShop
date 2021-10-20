package com.example.onshop

import com.example.onshop.model.Categorias
import com.example.onshop.model.Id
import com.example.onshop.model.Produto
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("products/{id}")
    suspend fun getProdutos(
        @Path("id") categoryId : Int
    ): Response<List<Produto>>

    @GET("categories")
    suspend fun getCategorias(): Response<List<Categorias>>

    companion object {
        fun getEndPointInstance(): ApiService {
            return Retrofit.Builder()
                .baseUrl("https://onshop-api.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(ApiService::class.java)
        }
    }
}