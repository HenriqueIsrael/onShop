package com.example.onshop.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.onshop.databinding.CadastroFragmentBinding
import com.example.onshop.viewmodel.CadastroViewModel
import com.google.firebase.auth.FirebaseAuth
import org.koin.androidx.viewmodel.ext.android.viewModel


class CadastroFragment : Fragment() {

    private var _binding: CadastroFragmentBinding? = null
    private val binding: CadastroFragmentBinding get() = _binding!!
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
                binding.campoEmailCadastrar.text.toString(),
                binding.campoSenhaCadastrar.text.toString(),
                binding.campoConfirmarSenhaCadastrar.text.toString()
            )
        }

        viewModel.validaDadosLiveData.observe(viewLifecycleOwner,{
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(it.email, it.senha)
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        Toast.makeText(requireContext(), "Cadastro realizado com sucesso!", Toast.LENGTH_LONG).show()
                        findNavController().navigateUp()
                    }
                }
        })

        viewModel.erroLiveData.observe(viewLifecycleOwner,{
            Toast.makeText(requireContext(),it,Toast.LENGTH_LONG).show()
        })
    }
}