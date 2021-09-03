package com.example.onshop.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.onshop.repository.LoginRepository

class LoginViewModel(private val loginRepository: LoginRepository) : ViewModel(){
    fun saveLogin(email: String, senha: String) {
        loginRepository.saveLogin(email,senha)
    }


}