package com.example.onshop.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.onshop.adapter.ViewPagerAdapter
import com.example.onshop.databinding.HomeFragmentBinding
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment: Fragment() {
    private var _binding: HomeFragmentBinding?= null
    private val binding: HomeFragmentBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = HomeFragmentBinding.inflate(inflater, container, false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewPagerProdutos.adapter = ViewPagerAdapter(this)

        TabLayoutMediator(
            binding.tabLayoutCategorias,
            binding.viewPagerProdutos
        ) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Cadeiras"
                }
                1 -> {
                    tab.text = "Notebooks"
                }
                2 -> {
                    tab.text = "Celulares"
                }
            }
        }.attach()

    }
}