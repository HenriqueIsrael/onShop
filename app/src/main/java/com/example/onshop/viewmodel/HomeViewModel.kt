package com.example.onshop.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onshop.model.Categorias
import com.example.onshop.repository.HomeRepository
import kotlinx.coroutines.launch
import java.lang.Exception

class HomeViewModel(private val homeRepository: HomeRepository): ViewModel() {
    private val _listaCategoriasLiveData = MutableLiveData<List<Categorias>>()
    val listaCategoriasLiveData: LiveData<List<Categorias>> = _listaCategoriasLiveData

    private val _erroLiveData = MutableLiveData<String>()
    val erroLiveData: LiveData<String> = _erroLiveData

    fun getCategorias() {
        viewModelScope.launch {
            try {
                _listaCategoriasLiveData.postValue(homeRepository.getCategorias())
            } catch (e: Exception) {
                _erroLiveData.postValue(e.message)
            }
        }
    }
}