package com.example.onshop.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.onshop.model.User
import com.example.onshop.repository.LoginRepository

class LoginViewModel(private val loginRepository: LoginRepository) : ViewModel(){

    private val _emailLiveData = MutableLiveData <String>()
    val emailLiveData: LiveData <String> = _emailLiveData

    private val _senhaLiveData = MutableLiveData <String>()
    val senhaLiveData: LiveData <String> = _senhaLiveData

    private val _switchDefaultTrueLiveData = MutableLiveData <Boolean>()
    val switchDefaultTrueLiveData : LiveData <Boolean> = _switchDefaultTrueLiveData

    private val _validaDadosLiveData = MutableLiveData <User>()
    val validaDadosLiveData: LiveData<User> = _validaDadosLiveData

    private val _erroLiveData = MutableLiveData <String>()
    val erroLiveData: LiveData<String> = _erroLiveData

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
        if(email.isEmpty() || senha.isEmpty()){
            _erroLiveData.postValue("Preencha os campos corretamente!")
        } else {
            _validaDadosLiveData.postValue(User(email,senha))
        }
    }
}