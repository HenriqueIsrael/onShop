package com.example.onshop.repository

import com.example.onshop.dados.CarrinhoDAO
import com.example.onshop.dados.FavoritoDAO
import com.example.onshop.model.ModeloCarrinho
import com.example.onshop.model.ModeloFavorito
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class InfoProdutoRepository(
    private val favoritoDAO: FavoritoDAO,
    private val carrinhoDAO: CarrinhoDAO
) {

    suspend fun salvaProdutoFavorito(
        imagem: String,
        nomeItem: String,
        descricao: String,
        preco: String
    ) {
        withContext(Dispatchers.IO) {
            favoritoDAO.inserirFavorito(
                ModeloFavorito(
                    imagem,
                    nomeItem,
                    descricao,
                    preco
                )
            )
        }
    }

    suspend fun deletaProdutoFavorito(nomeItem: String) {
        withContext(Dispatchers.IO) {
            favoritoDAO.deletaProdutoFavorito(nomeItem)
        }
    }

    suspend fun salvaProdutoCarrinho(imagem: String, nomeItem: String, descricao: String, preco: String) {
        withContext(Dispatchers.IO) {
            carrinhoDAO.inserirProdutoCarrinho(
                ModeloCarrinho(
                    imagem,
                    nomeItem,
                    descricao,
                    preco
                )
            )
        }
    }

    suspend fun deletaProdutoCarrinho(nomeItem: String) {
        withContext(Dispatchers.IO) {
            carrinhoDAO.deletaProdutoCarrinho(nomeItem)
        }
    }

    suspend fun verificaProdutoFavorito(nomeItem: String): String {
        return withContext(Dispatchers.IO) {
            favoritoDAO.verificaProdutoFavorito(nomeItem)
        }
    }

    suspend fun verificaProdutoCarrinho(nomeItem: String): String {
        return withContext(Dispatchers.IO) {
            carrinhoDAO.verificaProdutoCarrinho(nomeItem)
        }
    }
}