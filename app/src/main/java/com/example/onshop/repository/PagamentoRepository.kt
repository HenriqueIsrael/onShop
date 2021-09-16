package com.example.onshop.repository

import com.example.onshop.dados.CarrinhoDAO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PagamentoRepository(private val carrinhoDAO: CarrinhoDAO) {

    suspend fun getPrecoProdutos(): Double {
        return withContext(Dispatchers.IO) {
            var total = 0.00
            carrinhoDAO.listaProdutosCarrinho().forEach {
                total += it.preco.toDouble()
            }
            total
        }
    }
}