package com.example.onshop.fragments

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.onshop.databinding.CadastroFragmentBinding
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser


class CadastroFragment : Fragment() {

    private var _binding: CadastroFragmentBinding? = null
    private val binding: CadastroFragmentBinding get() = _binding!!

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
            if (binding.campoEmailCadastrar.text.toString()
                    .isEmpty() || binding.campoSenhaCadastrar.text.toString()
                    .isEmpty() || binding.campoConfirmarSenhaCadastrar.text.toString() != binding.campoSenhaCadastrar.text.toString()
            ) {
                Toast.makeText(requireContext(), "Preencha os campos corretamente!", Toast.LENGTH_SHORT)
                    .show()
            } else {
                val email: String = binding.campoEmailCadastrar.text.toString()
                val senha: String = binding.campoSenhaCadastrar.text.toString()

                FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,senha)
                    .addOnCompleteListener{
                        if(!it.isSuccessful){
                            Log.d("cadastro","funcionou ${it.result!!.user!!.uid}")
                        }
                    }
            }
        }
    }


}