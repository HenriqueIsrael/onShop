package com.example.onshop.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.onshop.model.Categorias
import com.example.onshop.repository.PagamentoRepository

class PagamentoViewModel(private val pagamentoRepository: PagamentoRepository): ViewModel() {

    private val _precoProdutosLiveData = MutableLiveData<Double>()
    val precoProdutosLiveData: LiveData<Double> = _precoProdutosLiveData

    fun getPrecoProdutos(){
        _precoProdutosLiveData.postValue(pagamentoRepository.getPrecoProdutos())
    }
}