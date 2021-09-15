package com.example.onshop.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.onshop.R
import com.example.onshop.databinding.PagamentoFragmentBinding
import com.example.onshop.viewmodel.PagamentoViewModel
import com.example.onshop.viewmodel.ProdutoViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.NumberFormat
import java.util.*

class PagamentoFragment: Fragment() {
    private var _binding: PagamentoFragmentBinding?= null
    private val binding: PagamentoFragmentBinding get() = _binding!!
    private val viewModel: PagamentoViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = PagamentoFragmentBinding.inflate(inflater, container, false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btEfetuarPagamento.setOnClickListener {
            findNavController().navigate(R.id.action_pagamentoFragment_to_finalizarCompraFragment)
        }

        binding.toolbarPagamento.setNavigationOnClickListener {
            requireActivity().finish()
        }

        viewModel.getPrecoProdutos()

        viewModel.precoProdutosLiveData.observe(viewLifecycleOwner,{
            binding.pagamentoPreco.text = convertePreco(it)
        })
    }
    fun convertePreco(preco: Double): String {
        return NumberFormat.getCurrencyInstance(Locale("pt", "BR"))
            .format(preco)
    }
}