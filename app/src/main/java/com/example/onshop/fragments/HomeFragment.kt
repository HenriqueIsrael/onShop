package com.example.onshop.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.onshop.R
import com.example.onshop.adapter.ViewPagerAdapter
import com.example.onshop.databinding.HomeFragmentBinding
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : Fragment() {
    private var _binding: HomeFragmentBinding? = null
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

        binding.viewPagerProdutos.adapter = ViewPagerAdapter(this, ORDENAR_BLOCOS)

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

        binding.toolbarDestaque.setNavigationOnClickListener {
            AlertDialog.Builder(requireContext()).setMessage("ABA LATERAL").show()
        }

        binding.toolbarDestaque.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.ordenarLista -> {
                    binding.viewPagerProdutos.adapter = ViewPagerAdapter(this, ORDENAR_LISTA)
                    true
                }
                R.id.ordenarBlocos -> {
                    binding.viewPagerProdutos.adapter = ViewPagerAdapter(this, ORDENAR_BLOCOS)
                    true
                }
                else -> false
            }

        }
    }
    companion object{
        const val ORDENAR_LISTA = 1
        const val ORDENAR_BLOCOS = 2
    }
}