package com.example.onshop.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onshop.model.ModeloCarrinho
import com.example.onshop.repository.InfoProdutoRepository
import kotlinx.coroutines.launch

class InfoProdutoViewModel(private val infoProdutoRepository: InfoProdutoRepository) : ViewModel() {

    private val _coracaoColorido = MutableLiveData<Boolean>()
    val coracaoColorido: LiveData<Boolean> = _coracaoColorido

    private val _carrinhoColorido = MutableLiveData<Boolean>()
    val carrinhoColorido: LiveData<Boolean> = _carrinhoColorido

    private val _controleSalvaFavorito = MutableLiveData<Boolean>()
    val controleSalvaFavorito: LiveData<Boolean> = _controleSalvaFavorito

    private val _controleColocaNoCarrinho = MutableLiveData<Boolean>()
    val controleColocaNoCarrinho: LiveData<Boolean> = _controleColocaNoCarrinho

    fun cliqueBotaoFavorito() {
        if (coracaoColorido.value == true) {
            _coracaoColorido.postValue(false)
            _controleSalvaFavorito.postValue(false)
        } else {
            _coracaoColorido.postValue(true)
            _controleSalvaFavorito.postValue(true)
        }
    }

    fun cliqueBotaoCarrinho() {
        if (carrinhoColorido.value == true) {
            _carrinhoColorido.postValue(false)
            _controleColocaNoCarrinho.postValue(false)
        } else {
            _carrinhoColorido.postValue(true)
            _controleColocaNoCarrinho.postValue(true)
        }
    }

    fun enviaProdutoFavorito(
        imagem: String,
        nomeItem: String,
        descricao: String,
        preco: String
    ) {
        viewModelScope.launch {
            infoProdutoRepository.salvaProdutoFavorito(imagem, nomeItem, descricao, preco)
        }

    }

    fun deletaProdutoFavorito(nomeItem: String) {
        viewModelScope.launch {
            infoProdutoRepository.deletaProdutoFavorito(nomeItem)
        }
    }

    fun enviaProdutoCarrinho(imagem: String, nomeItem: String, descricao: String, preco: String) {
        viewModelScope.launch {
            infoProdutoRepository.salvaProdutoCarrinho(imagem, nomeItem, descricao, preco)
        }

    }

    fun deletaProdutoCarrinho(nomeItem: String) {
        viewModelScope.launch {
            infoProdutoRepository.deletaProdutoCarrinho(nomeItem)
        }

    }

    fun verificaProdutoFavorito(nomeItem: String) {
        viewModelScope.launch {
            if (infoProdutoRepository.verificaProdutoFavorito(nomeItem).isNullOrEmpty()) {
                _coracaoColorido.postValue(false)
            } else {
                _coracaoColorido.postValue(true)
            }
        }
    }

    fun verificaProdutoCarrinho(nomeItem: String) {
        viewModelScope.launch {
            if (infoProdutoRepository.verificaProdutoCarrinho(nomeItem).isNullOrEmpty()) {
                _carrinhoColorido.postValue(false)
            } else {
                _carrinhoColorido.postValue(true)
            }
        }
    }
}