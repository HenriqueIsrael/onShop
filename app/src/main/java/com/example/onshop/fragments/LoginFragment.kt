package com.example.onshop.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.onshop.R
import com.example.onshop.databinding.LoginFragmentBinding
import com.example.onshop.viewmodel.LoginViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment: Fragment() {

    private var _binding: LoginFragmentBinding?= null
    private val binding: LoginFragmentBinding get() = _binding!!
    private val viewModel: LoginViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = LoginFragmentBinding.inflate(inflater, container, false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.switchDefaultTrue()

        viewModel.switchDefaultTrueLiveData.observe(viewLifecycleOwner, {
            if(it)
                binding.switchSalvaLogin.toggle()
        })

        viewModel.getEmail()

        viewModel.emailLiveData.observe(viewLifecycleOwner, {
            binding.campoEmail.setText(it)
        })

        viewModel.getSenha()

        viewModel.senhaLiveData.observe(viewLifecycleOwner,{
            binding.campoSenha.setText(it)
        })

        binding.switchSalvaLogin.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){
                viewModel.saveLogin(binding.campoEmail.text.toString(), binding.campoSenha.text.toString())
            } else {
                viewModel.deleteLogin()
            }
        }



        binding.cadastreSe.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_cadastroFragment)
        }

    }
}