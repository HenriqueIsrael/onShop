package com.example.onshop.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.onshop.R
import com.example.onshop.databinding.LoginFragmentBinding
import com.example.onshop.viewmodel.LoginViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment: Fragment() {

    private var _binding: LoginFragmentBinding?= null
    private val binding: LoginFragmentBinding get() = _binding!!
    private val viewModel: LoginViewModel by viewModel()
    private var auth = Firebase.auth

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

        binding.btEfetuarLogin.setOnClickListener {
            val email = binding.campoEmail.text.toString()
            val senha = binding.campoSenha.text.toString()
            auth.signInWithEmailAndPassword(email,senha)
                .addOnCompleteListener(requireActivity()) { task ->
                    if (task.isSuccessful) {
                        findNavController().navigate(R.id.action_loginFragment_to_homeActivity)
                    } else {
                        Toast.makeText(requireContext(), "Credenciais inválidas!", Toast.LENGTH_SHORT).show()
                    }
                }
        }



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