package com.example.onshop.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.onshop.SingleLiveEvent
import com.example.onshop.model.User
import com.example.onshop.repository.LoginRepository

class LoginViewModel(private val loginRepository: LoginRepository) : ViewModel(){

    private val _emailLiveData = MutableLiveData <String>()
    val emailLiveData: LiveData <String> = _emailLiveData

    private val _senhaLiveData = MutableLiveData <String>()
    val senhaLiveData: LiveData <String> = _senhaLiveData

    private val _switchDefaultTrueLiveData = MutableLiveData <Boolean>()
    val switchDefaultTrueLiveData : LiveData <Boolean> = _switchDefaultTrueLiveData

    private val _validaDadosLiveData = SingleLiveEvent <User>()
    val validaDadosLiveData: LiveData<User> = _validaDadosLiveData

    private val _erroEmailLiveData = SingleLiveEvent <String>()
    val erroEmailLiveData: LiveData<String> = _erroEmailLiveData

    private val _erroSenhaLiveData = SingleLiveEvent <String>()
    val erroSenhaLiveData: LiveData<String> = _erroSenhaLiveData

    fun saveLogin(email: String, senha: String) {
        loginRepository.saveLogin(email,senha)
    }

    fun deleteLogin() {
        loginRepository.saveLogin("","")
    }

    fun getEmail(){
        _emailLiveData.postValue(loginRepository.getEmail())
    }

    fun getSenha(){
        _senhaLiveData.postValue(loginRepository.getSenha())
    }

    fun switchDefaultTrue() {
        if((loginRepository.getEmail().isNotEmpty()) && (loginRepository.getSenha().isNotEmpty())){
            _switchDefaultTrueLiveData.postValue(true)
        } else {
            _switchDefaultTrueLiveData.postValue(false)
        }
    }

    fun validaDadosLogin(email: String, senha: String) {
        when {
            email.isEmpty() -> {
                _erroEmailLiveData.postValue("E-mail inválido")
            }
            senha.isEmpty() -> {
                _erroSenhaLiveData.postValue("Senha inválida")
            }
            else -> {
                _validaDadosLiveData.postValue(User(email,senha))
            }
        }
    }
}