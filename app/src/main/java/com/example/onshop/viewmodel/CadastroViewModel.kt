package com.example.onshop.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onshop.model.User
import kotlinx.coroutines.launch

class CadastroViewModel : ViewModel() {

    private val _validaDadosLiveData = MutableLiveData <User>()
    val validaDadosLiveData: LiveData<User> = _validaDadosLiveData

    private val _erroLiveData = MutableLiveData <String>()
    val erroLiveData: LiveData<String> = _erroLiveData

    fun validaDadosLogin(email: String, senha: String, confirmaSenha: String) {
            if (email.isEmpty() || senha.isEmpty() || confirmaSenha != senha) {
                _erroLiveData.postValue("Preencha os campos corretamente!")
            } else{
                _validaDadosLiveData.postValue(User(email, senha))
            }
    }
}