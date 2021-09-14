package com.example.onshop.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onshop.SingleLiveEvent
import com.example.onshop.model.ModeloFavorito
import com.example.onshop.repository.FavoritoRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class FavoritoViewModel(private val favoritoRepository: FavoritoRepository) : ViewModel() {

    private val _listaVaziaProdutosFavoritos = MutableLiveData<Unit>()
    val listaVaziaProdutosFavoritos: LiveData<Unit> = _listaVaziaProdutosFavoritos

    private val _listaProdutosFavoritos = MutableLiveData<List<ModeloFavorito>>()
    val listaProdutosFavoritos: LiveData<List<ModeloFavorito>> = _listaProdutosFavoritos

    private val _loadingLiveData = SingleLiveEvent<Boolean>()
    val loadingLiveData: LiveData<Boolean> = _loadingLiveData

    fun getListaProdutosFavoritos() {
        viewModelScope.launch {
            _loadingLiveData.postValue(true)
            delay(2000L)
            if (favoritoRepository.getListaProdutosFavoritos().isNotEmpty()) {
                _listaProdutosFavoritos.postValue(favoritoRepository.getListaProdutosFavoritos())
            } else {
                _listaVaziaProdutosFavoritos.postValue(Unit)
            }
            _loadingLiveData.postValue(false)
        }

    }
}