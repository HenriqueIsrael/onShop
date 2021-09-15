package com.example.onshop.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onshop.SingleLiveEvent
import com.example.onshop.model.ModeloCarrinho
import com.example.onshop.repository.CarrinhoRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CarrinhoViewModel(private val carrinhoRepository: CarrinhoRepository) : ViewModel() {

    private val _listaProdutosCarrinho = MutableLiveData<List<ModeloCarrinho>>()
    val listaProdutosCarrinho: LiveData<List<ModeloCarrinho>> = _listaProdutosCarrinho

    private val _loadingLiveData = SingleLiveEvent<Boolean>()
    val loadingLiveData: LiveData<Boolean> = _loadingLiveData

    private val _listaVaziaProdutosCarrinho = MutableLiveData<Unit>()
    val listaVaziaProdutosCarrinho: LiveData<Unit> = _listaVaziaProdutosCarrinho

    fun getListaProdutosCarrinho() {
        viewModelScope.launch {
            _loadingLiveData.postValue(true)
            delay(1000L)
            if(carrinhoRepository.getListaProdutosCarrinho().isNotEmpty()){
                _listaProdutosCarrinho.postValue(carrinhoRepository.getListaProdutosCarrinho())
            } else {
                _listaVaziaProdutosCarrinho.postValue(Unit)
            }
            _loadingLiveData.postValue(false)
        }

    }
}