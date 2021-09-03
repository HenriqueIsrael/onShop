package com.example.onshop.sharedpreference

import android.content.SharedPreferences
import androidx.core.content.edit

class SessionManager(private val preference: SharedPreferences) {
    fun saveLogin(email: String, senha: String) {
        preference.edit {
            putString("email",email)
            putString("senha",senha)
        }
    }
}