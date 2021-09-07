package com.example.onshop.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.onshop.adapter.RecyclerViewAdapter
import com.example.onshop.databinding.ProdutosFragmentBinding

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
        if(requireArguments().getInt("ordenar")==1){
            binding.recyclerViewProdutos.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        } else {
            binding.recyclerViewProdutos.layoutManager =  GridLayoutManager(requireContext(),2,GridLayoutManager.VERTICAL,false)
        }
        binding.recyclerViewProdutos.adapter = RecyclerViewAdapter(requireArguments().getInt("ordenar"), requireArguments().getInt("posicao"))
    }
}


