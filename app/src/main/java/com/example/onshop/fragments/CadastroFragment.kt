package com.example.onshop.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.onshop.R
import com.example.onshop.databinding.CadastroFragmentBinding
import com.example.onshop.viewmodel.CadastroViewModel
import com.google.firebase.auth.FirebaseAuth
import org.koin.androidx.viewmodel.ext.android.viewModel


class CadastroFragment : Fragment() {

    private var _binding: CadastroFragmentBinding? = null
    private val binding: CadastroFragmentBinding get() = _binding!!
    /*
    private val binding: CadastroFragmentBinding by lazy{
       CadastroFragmentBinding.inflate(inflater, container, false)
    }
    */
    private val viewModel: CadastroViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = CadastroFragmentBinding.inflate(inflater, container, false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolbarCadastro.setNavigationOnClickListener {
            findNavController().navigateUp()
        }

        binding.btCadastrar.setOnClickListener {
            viewModel.validaDadosLogin(
                binding.campoEmailCadastro.text.toString(),
                binding.campoSenhaCadastro.text.toString(),
                binding.campoSenhaConfirmarCadastro.text.toString()
            )
        }

        viewModel.fazCadastroLiveData.observe(viewLifecycleOwner,{
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(it.email, it.senha)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(requireContext(), "Cadastro realizado com sucesso!", Toast.LENGTH_LONG).show()
                        findNavController().navigate(R.id.action_cadastroFragment_to_homeActivity)
                    } else {
                        AlertDialog.Builder(requireContext()).setMessage("Por favor, insira um e-mail válido e uma senha com pelo menos 6 caracteres.").show()
                    }
                }
        })

        viewModel.loadingLiveData.observe(viewLifecycleOwner,{
            binding.loadingCadastro.isVisible = it
        })


        viewModel.validaEmailLiveData.observe(viewLifecycleOwner,{
            binding.cadastroCampoEmail.error = it
        })

        binding.campoEmailCadastro.addTextChangedListener {
            binding.cadastroCampoEmail.isErrorEnabled = false
        }

        viewModel.validaSenhaLiveData.observe(viewLifecycleOwner,{
            binding.cadastroCampoSenha.error = it
        })

        binding.campoSenhaCadastro.addTextChangedListener {
            binding.cadastroCampoSenha.isErrorEnabled = false
        }

        viewModel.validaSenhaLiveData.observe(viewLifecycleOwner,{
            binding.cadastroCampoConfirmarSenha.error = it
        })

        binding.campoSenhaConfirmarCadastro.addTextChangedListener {
            binding.cadastroCampoConfirmarSenha.isErrorEnabled = false
        }
    }
}