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
import com.example.onshop.viewmodel.HomeViewModel
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {
    private var _binding: HomeFragmentBinding? = null
    private val binding: HomeFragmentBinding get() = _binding!!
    private val viewModel: HomeViewModel by viewModel()

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

        viewModel.getCategorias()

        viewModel.listaCategoriasLiveData.observe(viewLifecycleOwner, {
            binding.viewPagerProdutos.adapter = ViewPagerAdapter(this, ORDENAR_BLOCOS, it.size)
            binding.tabLayoutCategorias.tabMode = TabLayout.MODE_SCROLLABLE
            TabLayoutMediator(
                binding.tabLayoutCategorias,
                binding.viewPagerProdutos
            ) { tab, position ->
                tab.text = it[position].nome
//                when (position) {
//                    0 -> {
//                        tab.text = "Cadeiras"
//                    }
//                    1 -> {
//                        tab.text = "Notebooks"
//                    }
//                    2 -> {
//                        tab.text = "Celulares"
//                    }
//                }
            }.attach()
        })

        binding.toolbarDestaque.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.ordenarLista -> {
                    binding.viewPagerProdutos.adapter = ViewPagerAdapter(
                        this,
                        ORDENAR_LISTA,
                        5
                    )
                    true
                }
                R.id.ordenarBlocos -> {
                    binding.viewPagerProdutos.adapter = ViewPagerAdapter(
                        this,
                        ORDENAR_BLOCOS,
                        5
                    )
                    true
                }
                else -> false
            }

        }
    }

    companion object {
        const val ORDENAR_LISTA = 1
        const val ORDENAR_BLOCOS = 2
    }
}