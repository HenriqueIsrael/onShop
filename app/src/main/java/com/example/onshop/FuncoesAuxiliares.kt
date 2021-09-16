package com.example.onshop

import android.util.Patterns
import java.text.NumberFormat
import java.util.*

object FuncoesAuxiliares {
    fun convertePreco(preco: Double): String {
        return NumberFormat.getCurrencyInstance(Locale("pt", "BR"))
            .format(preco)
    }

    fun String.emailValido() = !(Patterns.EMAIL_ADDRESS.matcher(this).matches())
}