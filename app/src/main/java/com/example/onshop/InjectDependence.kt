package com.example.onshop

import android.content.Context
import com.example.onshop.dados.AppDatabase
import com.example.onshop.repository.HomeRepository
import com.example.onshop.repository.InfoProdutoRepository
import com.example.onshop.repository.LoginRepository
import com.example.onshop.repository.ProdutoRepository
import com.example.onshop.sharedpreference.SessionManager
import com.example.onshop.viewmodel.*
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
    single {
        ApiService.getEndPointInstance()
    }
    viewModel {
        ProdutoViewModel(get())
    }
    factory {
        ProdutoRepository(get())
    }
    viewModel {
        HomeViewModel(get())
    }
    factory {
        HomeRepository(get())
    }
    viewModel {
        InfoProdutoViewModel(get())
    }
    factory {
        InfoProdutoRepository(get())
    }
    single {
        AppDatabase.getInstanceDatabase(androidContext()).favoritoDAO()
    }
}