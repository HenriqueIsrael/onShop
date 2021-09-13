package com.example.onshop.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.onshop.repository.InfoProdutoRepository

class InfoProdutoViewModel(private val infoProdutoRepository: InfoProdutoRepository): ViewModel() {

    private val _coracaoColorido = MutableLiveData<Boolean>()
    val coracaoColorido: LiveData<Boolean> = _coracaoColorido

    private val _carrinhoColorido = MutableLiveData<Boolean>()
    val carrinhoColorido: LiveData<Boolean> = _carrinhoColorido

    fun cliqueBotaoFavorito() {
        if (coracaoColorido.value == true) {
            _coracaoColorido.postValue(false)
        } else {
            _coracaoColorido.postValue(true)
        }
    }

    fun cliqueBotaoCarrinho() {
        if(carrinhoColorido.value == true) {
            _carrinhoColorido.postValue(false)
        } else {
            _carrinhoColorido.postValue(true)
        }
    }


}