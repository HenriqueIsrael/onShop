package com.example.onshop.repository

import com.example.onshop.dados.CarrinhoDAO
import com.example.onshop.dados.FavoritoDAO
import com.example.onshop.model.ModeloCarrinho
import com.example.onshop.model.ModeloFavorito

class InfoProdutoRepository(private val favoritoDAO: FavoritoDAO, private val carrinhoDAO: CarrinhoDAO) {
    fun salvaProdutoFavorito(imagem: String, nomeItem: String, descricao: String, preco: String) {
        favoritoDAO.inserirFavorito(
            ModeloFavorito(
                imagem,
                nomeItem,
                descricao,
                preco
            )
        )
    }

    fun deletaProdutoFavorito(nomeItem: String) {
        favoritoDAO.deletaProdutoFavorito(nomeItem)
    }

    fun salvaProdutoCarrinho(imagem: String, nomeItem: String, descricao: String, preco: String) {
        carrinhoDAO.inserirProdutoCarrinho(
            ModeloCarrinho(
                imagem,
                nomeItem,
                descricao,
                preco
            )
        )
    }

    fun deletaProdutoCarrinho(nomeItem: String){
        carrinhoDAO.deletaProdutoCarrinho(nomeItem)
    }

    fun verificaProdutoFavorito(nomeItem: String): String {
        return favoritoDAO.verificaProdutoFavorito(nomeItem)
    }

    fun verificaProdutoCarrinho(nomeItem: String): String {
        return carrinhoDAO.verificaProdutoCarrinho(nomeItem)
    }
}