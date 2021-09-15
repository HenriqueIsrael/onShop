package com.example.onshop.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.onshop.R
import com.example.onshop.databinding.FinalizarComprasFragmentBinding

class FinalizarCompraFragment: Fragment() {

    private var _binding: FinalizarComprasFragmentBinding?= null
    private val binding: FinalizarComprasFragmentBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FinalizarComprasFragmentBinding.inflate(inflater, container, false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolbar3.setNavigationOnClickListener {
            findNavController().navigate(R.id.action_finalizarCompraFragment_to_homeActivity2)
        }
    }
}