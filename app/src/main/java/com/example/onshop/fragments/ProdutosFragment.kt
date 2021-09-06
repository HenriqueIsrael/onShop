package com.example.onshop.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.onshop.adapter.RecyclerViewAdapter
import com.example.onshop.databinding.CadastroFragmentBinding
import com.example.onshop.databinding.ProdutosFragmentBinding
import com.example.onshop.viewmodel.CadastroViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProdutosFragment : Fragment() {
    private var _binding: ProdutosFragmentBinding? = null
    private val binding: ProdutosFragmentBinding get() = _binding!!

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
        binding.recyclerViewProdutos.adapter = RecyclerViewAdapter()
    }
}