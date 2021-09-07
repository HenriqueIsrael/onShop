package com.example.onshop.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onshop.model.User
import kotlinx.coroutines.launch

class CadastroViewModel : ViewModel() {

    private val _validaEmailLiveData = MutableLiveData <String>()
    val validaEmailLiveData: LiveData<String> = _validaEmailLiveData

    private val _validaSenhaLiveData = MutableLiveData <String>()
    val validaSenhaLiveData: LiveData<String> = _validaSenhaLiveData

    private val _erroLiveData = MutableLiveData <String>()
    val erroLiveData: LiveData<String> = _erroLiveData

    private val _fazCadastroLiveData = MutableLiveData <User>()
    val fazCadastroLiveData: LiveData<User> = _fazCadastroLiveData

    fun validaDadosLogin(email: String, senha: String, confirmaSenha: String) {
            if (email.isEmpty() ||  email.contains(" ")) {
                _validaEmailLiveData.postValue("Preencha o campo de email corretamente xx@yyy.com")
            } else if(senha.isEmpty() || confirmaSenha != senha){
                _validaSenhaLiveData.postValue("Senhas não correspondentes")
            } else{
                _fazCadastroLiveData.postValue(User(email,senha))
            }
    }
}