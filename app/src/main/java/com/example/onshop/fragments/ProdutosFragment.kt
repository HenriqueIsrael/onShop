package com.example.onshop.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.onshop.activities.InfoProdutoActivity
import com.example.onshop.adapter.CategoriasViewPagerAdapter.Companion.ORDENACAO_LISTA_DESTAQUES
import com.example.onshop.adapter.CategoriasViewPagerAdapter.Companion.POSICAO_VIEW_PAGER_CATEGORIAS
import com.example.onshop.adapter.CliqueNoProduto
import com.example.onshop.adapter.ProdutosRecyclerViewDestaquesAdapter
import com.example.onshop.databinding.ProdutosFragmentBinding
import com.example.onshop.viewmodel.ProdutoViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProdutosFragment : Fragment(), CliqueNoProduto {
    private var _binding: ProdutosFragmentBinding? = null
    private val binding: ProdutosFragmentBinding get() = _binding!!
    private val viewModel: ProdutoViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ProdutosFragmentBinding.inflate(inflater, container, false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getProdutos(requireArguments().getInt(POSICAO_VIEW_PAGER_CATEGORIAS))

        viewModel.listaProdutosLiveData.observe(viewLifecycleOwner,{
            binding.recyclerViewProdutos.adapter = ProdutosRecyclerViewDestaquesAdapter(
                it,
                requireArguments().getInt(ORDENACAO_LISTA_DESTAQUES),this@ProdutosFragment
            )
        })

        if (requireArguments().getInt(ORDENACAO_LISTA_DESTAQUES) == 1) {
            binding.recyclerViewProdutos.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        } else {
            binding.recyclerViewProdutos.layoutManager =
                GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)
        }
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


