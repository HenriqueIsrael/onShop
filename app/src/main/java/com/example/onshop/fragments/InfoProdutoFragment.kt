package com.example.onshop.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.onshop.R
import com.example.onshop.databinding.InfoProdutoFragmentBinding
import com.example.onshop.viewmodel.InfoProdutoViewModel
import com.squareup.picasso.Picasso
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.NumberFormat
import java.util.*

class InfoProdutoFragment : Fragment() {
    private var _binding: InfoProdutoFragmentBinding? = null
    private val binding: InfoProdutoFragmentBinding get() = _binding!!
    private val viewModel: InfoProdutoViewModel by viewModel()
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

        viewModel.verificaProdutoFavorito(intent.getStringExtra("nomeItem")!!)
        viewModel.verificaProdutoCarrinho(intent.getStringExtra("nomeItem")!!)

        setaDadosProdutos()

        binding.btFavorito.setOnClickListener {
            viewModel.cliqueBotaoFavorito()
        }

        viewModel.coracaoColorido.observe(viewLifecycleOwner,{
            if(it){
                binding.btFavorito.setImageResource(R.drawable.ic_favoritar)
            } else {
                binding.btFavorito.setImageResource(R.drawable.ic_nao_favorito)
            }
        })

        viewModel.controleSalvaFavorito.observe(viewLifecycleOwner,{
            if(it){
                viewModel.enviaProdutoFavorito(
                    intent.getStringExtra("imagem")!!,
                    intent.getStringExtra("nomeItem")!!,
                    intent.getStringExtra("descricao")!!,
                    intent.getStringExtra("preco")!!
                )
            } else {
                viewModel.deletaProdutoFavorito(
                    intent.getStringExtra("nomeItem")!!
                )
            }
        })

        binding.btCarrinho.setOnClickListener {
            viewModel.cliqueBotaoCarrinho()
        }

        viewModel.carrinhoColorido.observe(viewLifecycleOwner,{
            if(it){
                binding.btCarrinho.setImageResource(R.drawable.ic_colocou_carrinho_compra)
            } else {
                binding.btCarrinho.setImageResource(R.drawable.ic_tirar_carrinho_compra)
            }
        })

        viewModel.controleColocaNoCarrinho.observe(viewLifecycleOwner,{
            if(it){
                viewModel.enviaProdutoCarrinho(
                    intent.getStringExtra("imagem")!!,
                    intent.getStringExtra("nomeItem")!!,
                    intent.getStringExtra("descricao")!!,
                    intent.getStringExtra("preco")!!
                )
            } else {
                viewModel.deletaProdutoCarrinho(
                    intent.getStringExtra("nomeItem")!!
                )
            }
        })

        binding.btComprarAgora.setOnClickListener {
            findNavController().navigate(R.id.action_infoProdutoFragment_to_pagamentoActivity2)
        }
    }

    private fun setaDadosProdutos() {
        val intent = requireActivity().intent

        Picasso.with(binding.imagemInfoProduto.context).load(intent.getStringExtra("imagem"))
            .into(binding.imagemInfoProduto)

        binding.nomeInfoProduto.text = intent.getStringExtra("nomeItem")

        binding.descricaoInfoProduto.text = intent.getStringExtra("descricao")

        binding.precoInfoProduto.text = convertePreco(intent.getStringExtra("preco")!!)
    }

    fun convertePreco(preco: String): String {
        return NumberFormat.getCurrencyInstance(Locale("pt", "BR"))
            .format(preco.toDouble())
    }
}
