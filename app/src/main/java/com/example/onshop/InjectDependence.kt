package com.example.onshop

import android.content.Context
import com.example.onshop.repository.LoginRepository
import com.example.onshop.sharedpreference.SessionManager
import com.example.onshop.viewmodel.CadastroViewModel
import com.example.onshop.viewmodel.LoginViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val injectDependence = module {
    viewModel {
        LoginViewModel(get())
    }
    factory {
        LoginRepository(get())
    }
    single {
        SessionManager((androidContext().getSharedPreferences("saveData", Context.MODE_PRIVATE)))
    }
    viewModel {
        CadastroViewModel()
    }
}