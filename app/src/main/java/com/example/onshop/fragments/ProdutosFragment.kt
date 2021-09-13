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
import com.example.onshop.adapter.CliqueNoProduto
import com.example.onshop.adapter.RecyclerViewAdapter
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

        viewModel.getProdutos(requireArguments().getInt("posicao"))

        viewModel.listaProdutosLiveData.observe(viewLifecycleOwner,{
            binding.recyclerViewProdutos.adapter = RecyclerViewAdapter(
                it,
                requireArguments().getInt("ordenar"),this@ProdutosFragment
            )
        })

        if (requireArguments().getInt("ordenar") == 1) {
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
        val intent = Intent(requireActivity(), InfoProdutoActivity::class.java).apply {
            putExtra("imagem",imagem)
            putExtra("nomeItem",nomeItem)
            putExtra("descricao",descricao)
            putExtra("preco", preco)
        }
        startActivity(intent)
    }
}


