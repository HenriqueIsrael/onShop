package com.example.onshop.sharedpreference

import android.content.SharedPreferences
import androidx.core.content.edit

class SessionManager(private val preference: SharedPreferences) {
    fun saveLogin(email: String, senha: String) {
        preference.edit {
            putString(EMAIL,email)
            putString(SENHA,senha)
        }
    }

    fun getEmail(): String?{
        return preference.getString(EMAIL,"")
    }

    fun getSenha(): String?{
        return preference.getString(SENHA,"")
    }

    companion object{
        const val EMAIL = "email"
        const val SENHA = "senha"
    }
}