package com.example.onshop.repository

import com.example.onshop.dados.CarrinhoDAO
import com.example.onshop.model.ModeloCarrinho

class CarrinhoRepository(private val carrinhoDAO: CarrinhoDAO) {
    fun getListaProdutosCarrinho(): List<ModeloCarrinho>{
        return carrinhoDAO.listaProdutosCarrinho()
    }

}