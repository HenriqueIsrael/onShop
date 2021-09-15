package com.example.onshop.repository

import com.example.onshop.dados.CarrinhoDAO

class PagamentoRepository(private val carrinhoDAO: CarrinhoDAO) {
    fun getPrecoProdutos(): Double {
        var total = 0.00
        carrinhoDAO.listaProdutosCarrinho().forEach {
            total += it.preco.toDouble()
        }
        return total
    }


}