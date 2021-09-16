package com.example.onshop.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onshop.SingleLiveEvent
import com.example.onshop.model.Categorias
import com.example.onshop.model.User
import com.example.onshop.repository.PagamentoRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class PagamentoViewModel(private val pagamentoRepository: PagamentoRepository): ViewModel() {

    private val _precoProdutosLiveData = MutableLiveData<Double>()
    val precoProdutosLiveData: LiveData<Double> = _precoProdutosLiveData

    private val _validaCamposPagamentoLiveData = MutableLiveData <String>()
    val validaCamposPagamentoLiveData: LiveData<String> = _validaCamposPagamentoLiveData

    private val _loadingLiveData = SingleLiveEvent <Boolean>()
    val loadingLiveData: LiveData<Boolean> = _loadingLiveData

    private val _realizaPagamentoLiveData = MutableLiveData <Boolean>()
    val realizaPagamentoLiveData: LiveData<Boolean> = _realizaPagamentoLiveData

    fun getPrecoProdutos(){
        _precoProdutosLiveData.postValue(pagamentoRepository.getPrecoProdutos())
    }

    fun validaCamposPagamento(endereco: String, numero: String, cep: String, numeroCartao: String, validadeCartao: String, cvvCartao: String) {
        if(endereco.isEmpty() || numero.isEmpty() || cep.isEmpty() || numeroCartao.isEmpty() || validadeCartao.isEmpty() || cvvCartao.isEmpty()){
            _validaCamposPagamentoLiveData.postValue("Preencha os campos corretamente")
            _realizaPagamentoLiveData.postValue(false)
        } else {
            viewModelScope.launch {
                _loadingLiveData.postValue(true)
                delay(2000L)
                _realizaPagamentoLiveData.postValue(true)
                _loadingLiveData.postValue(false)
            }
        }
    }
}