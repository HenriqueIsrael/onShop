package com.example.onshop.repository

import com.example.onshop.sharedpreference.SessionManager

class LoginRepository(private val sharedPreference: SessionManager) {
    fun saveLogin(email: String, senha: String) {
        sharedPreference.saveLogin(email,senha)
    }

    fun getEmail(): String {
        return sharedPreference.getEmail()!!
    }

    fun getSenha(): String {
        return sharedPreference.getSenha()!!
    }


}