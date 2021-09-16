package com.example.onshop.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onshop.model.Categorias
import com.example.onshop.model.Produto
import com.example.onshop.repository.ProdutoRepository
import kotlinx.coroutines.launch
import java.lang.Exception

class ProdutoViewModel(private val produtoRepository: ProdutoRepository) : ViewModel() {

    private val _listaProdutosLiveData = MutableLiveData<List<Produto>>()
    val listaProdutosLiveData: LiveData<List<Produto>> = _listaProdutosLiveData

    fun getProdutos(posicao: Int) {
        viewModelScope.launch {
            try {
                when (posicao) {
                    0 -> {
                        _listaProdutosLiveData.postValue(produtoRepository.getProdutos(CADEIRAS))
                    }
                    1 -> {
                        _listaProdutosLiveData.postValue(produtoRepository.getProdutos(NOTEBOOKS))
                    }
                    2 -> {
                        _listaProdutosLiveData.postValue(produtoRepository.getProdutos(CELULARES))
                    }
                    3 -> {
                        _listaProdutosLiveData.postValue(produtoRepository.getProdutos(HEADSETS))
                    }
                    4 -> {
                        _listaProdutosLiveData.postValue(produtoRepository.getProdutos(MOUSES))
                    }
                }

            } catch (e: Exception) { }
        }
    }

    companion object {
        const val CADEIRAS = 1
        const val NOTEBOOKS = 2
        const val CELULARES = 3
        const val HEADSETS = 4
        const val MOUSES = 5
    }
}