package com.example.onshop

import android.content.Context
import com.example.onshop.repository.LoginRepository
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
        androidContext().getSharedPreferences("saveData", Context.MODE_PRIVATE)
    }
}