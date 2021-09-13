package com.example.onshop.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.onshop.databinding.InfoProdutoFragmentBinding
import com.squareup.picasso.Picasso
import java.text.NumberFormat
import java.util.*

class InfoProdutoFragment : Fragment() {
    private var _binding: InfoProdutoFragmentBinding? = null
    private val binding: InfoProdutoFragmentBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = InfoProdutoFragmentBinding.inflate(inflater, container, false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolbarProduto.setNavigationOnClickListener {
            requireActivity().finish()
        }

        val intent = requireActivity().intent

        setaDadosProdutos()
    }

    private fun setaDadosProdutos() {
        val intent = requireActivity().intent

        Picasso.with(binding.imagemInfoProduto.context).load(intent.getStringExtra("imagem"))
            .into(binding.imagemInfoProduto)

        binding.nomeInfoProduto.text = intent.getStringExtra("nomeItem")

        binding.descricaoInfoProduto.text = intent.getStringExtra("descricao")

        binding.precoInfoProduto.text = "R$ "+ intent.getStringExtra("preco")
    }
}
