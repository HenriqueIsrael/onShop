package com.example.onshop.repository

import com.example.onshop.dados.CarrinhoDAO
import com.example.onshop.model.ModeloCarrinho
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CarrinhoRepository(private val carrinhoDAO: CarrinhoDAO) {

    suspend fun getListaProdutosCarrinho(): List<ModeloCarrinho>{
        return withContext(Dispatchers.IO){
            carrinhoDAO.listaProdutosCarrinho()
        }
    }

}