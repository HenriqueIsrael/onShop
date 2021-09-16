package com.example.onshop.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.onshop.FuncoesAuxiliares.convertePreco
import com.example.onshop.R
import com.example.onshop.databinding.InfoProdutoFragmentBinding
import com.example.onshop.fragments.CarrinhoFragment.Companion.DESCRICAO_PRODUTO
import com.example.onshop.fragments.CarrinhoFragment.Companion.IMAGEM_PRODUTO
import com.example.onshop.fragments.CarrinhoFragment.Companion.NOME_PRODUTO
import com.example.onshop.fragments.CarrinhoFragment.Companion.PRECO_PRODUTO
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

        viewModel.verificaProdutoFavorito(intent.getStringExtra(NOME_PRODUTO)!!)
        viewModel.verificaProdutoCarrinho(intent.getStringExtra(NOME_PRODUTO)!!)

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
                Toast.makeText(requireContext(),"Produto adicionado aos favoritos",Toast.LENGTH_SHORT).show()
                viewModel.enviaProdutoFavorito(
                    intent.getStringExtra(IMAGEM_PRODUTO)!!,
                    intent.getStringExtra(NOME_PRODUTO)!!,
                    intent.getStringExtra(DESCRICAO_PRODUTO)!!,
                    intent.getStringExtra(PRECO_PRODUTO)!!
                )
            } else {
                Toast.makeText(requireContext(),"Produto removido dos favoritos",Toast.LENGTH_SHORT).show()
                viewModel.deletaProdutoFavorito(
                    intent.getStringExtra(NOME_PRODUTO)!!
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
                Toast.makeText(requireContext(),"Produto adicionado ao carrinho",Toast.LENGTH_SHORT).show()
                viewModel.enviaProdutoCarrinho(
                    intent.getStringExtra(IMAGEM_PRODUTO)!!,
                    intent.getStringExtra(NOME_PRODUTO)!!,
                    intent.getStringExtra(DESCRICAO_PRODUTO)!!,
                    intent.getStringExtra(PRECO_PRODUTO)!!
                )
            } else {
                Toast.makeText(requireContext(),"Produto removido do carrinho",Toast.LENGTH_SHORT).show()
                viewModel.deletaProdutoCarrinho(
                    intent.getStringExtra(NOME_PRODUTO)!!
                )
            }
        })

        binding.btComprarAgora.setOnClickListener {
            viewModel.cliqueBotaoCarrinho()
            findNavController().navigate(R.id.action_infoProdutoFragment_to_pagamentoFragment2)
        }

    }

    private fun setaDadosProdutos() {
        val intent = requireActivity().intent

        Picasso.with(binding.imagemInfoProduto.context).load(intent.getStringExtra(IMAGEM_PRODUTO))
            .into(binding.imagemInfoProduto)

        binding.nomeInfoProduto.text = intent.getStringExtra(NOME_PRODUTO)

        binding.descricaoInfoProduto.text = intent.getStringExtra(DESCRICAO_PRODUTO)

        binding.precoInfoProduto.text = convertePreco(intent.getStringExtra(PRECO_PRODUTO)!!.toDouble())
    }
}
