package com.example.onshop.fragments

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.onshop.R
import com.example.onshop.activities.InfoProdutoActivity
import com.example.onshop.adapter.CliqueNoProduto
import com.example.onshop.adapter.ProdutosFavoritosAdapter
import com.example.onshop.databinding.FavoritoFragmentBinding
import com.example.onshop.viewmodel.FavoritoViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoritoFragment: Fragment(), CliqueNoProduto {
    private var _binding: FavoritoFragmentBinding?= null
    private val binding: FavoritoFragmentBinding get() = _binding!!
    private val viewModel: FavoritoViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FavoritoFragmentBinding.inflate(inflater, container, false)
        return _binding!!.root
    }

    override fun onResume() {
        super.onResume()
        viewModel.getListaProdutosFavoritos()
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btExplorarProdutos.setOnClickListener {
            findNavController().navigate(R.id.action_favoritoFragment_to_homeFragment)
        }

        viewModel.listaProdutosFavoritos.observe(viewLifecycleOwner,{
            binding.recyclerviewProdutosFavoritos.isVisible = true
            binding.recyclerviewProdutosFavoritos.adapter = ProdutosFavoritosAdapter(it,this@FavoritoFragment)
        })

        viewModel.listaVaziaProdutosFavoritos.observe(viewLifecycleOwner,{
            binding.recyclerviewProdutosFavoritos.isVisible = false
        })

        viewModel.loadingLiveData.observe(viewLifecycleOwner,{
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