package com.example.onshop.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.onshop.R
import com.example.onshop.databinding.CarrinhoFragmentBinding

class CarrinhoFragment: Fragment() {
    private var _binding: CarrinhoFragmentBinding?= null
    private val binding: CarrinhoFragmentBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = CarrinhoFragmentBinding.inflate(inflater, container, false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btExplorarProdutos.setOnClickListener {
            findNavController().navigate(R.id.action_carrinhoFragment_to_homeFragment)
        }
    }
}