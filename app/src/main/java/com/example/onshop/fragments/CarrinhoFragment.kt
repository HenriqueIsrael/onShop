package com.example.onshop.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.onshop.R
import com.example.onshop.activities.InfoProdutoActivity
import com.example.onshop.adapter.CarrinhoAdapter
import com.example.onshop.adapter.CliqueNoProduto
import com.example.onshop.databinding.CarrinhoFragmentBinding
import com.example.onshop.viewmodel.CarrinhoViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class CarrinhoFragment : Fragment(), CliqueNoProduto {
    private var _binding: CarrinhoFragmentBinding? = null
    private val binding: CarrinhoFragmentBinding get() = _binding!!
    private val viewModel: CarrinhoViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = CarrinhoFragmentBinding.inflate(inflater, container, false)
        return _binding!!.root
    }

    override fun onResume() {
        super.onResume()
        viewModel.getListaProdutosCarrinho()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btExplorarProdutos.setOnClickListener {
            findNavController().navigate(R.id.action_carrinhoFragment_to_homeFragment)
        }

        binding.btFinalizarCompra.setOnClickListener {
            findNavController().navigate(R.id.action_carrinhoFragment_to_fluxoPagamentoActivity)
        }

        viewModel.listaProdutosCarrinho.observe(viewLifecycleOwner, {
            binding.recyclerviewCarrinho.isVisible = true
            binding.recyclerviewCarrinho.adapter = CarrinhoAdapter(it, this@CarrinhoFragment)
        })

        viewModel.listaVaziaProdutosCarrinho.observe(viewLifecycleOwner, {
            binding.recyclerviewCarrinho.isVisible = false
        })

        viewModel.loadingLiveData.observe(viewLifecycleOwner, {
            binding.loading.isVisible = it
        })
    }

    override fun clicouNoProduto(
        imagem: String,
        nomeItem: String,
        descricao: String,
        preco: String
    ) {
        startActivity(Intent(requireActivity(), InfoProdutoActivity::class.java).apply {
            putExtra(IMAGEM_PRODUTO, imagem)
            putExtra(NOME_PRODUTO, nomeItem)
            putExtra(DESCRICAO_PRODUTO, descricao)
            putExtra(PRECO_PRODUTO, preco)
        })
    }
    companion object {
        const val IMAGEM_PRODUTO = "imagem"
        const val NOME_PRODUTO = "nomeItem"
        const val DESCRICAO_PRODUTO = "descricao"
        const val PRECO_PRODUTO = "preco"
    }
}