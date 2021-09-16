package com.example.onshop.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.onshop.fragments.ProdutosFragment

class CategoriasViewPagerAdapter(
    fragment: Fragment, private val ordenar: Int,
    private val paginaTotal: Int
): FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = paginaTotal

    override fun createFragment(position: Int): Fragment {
        return ProdutosFragment().also {
            it.arguments = Bundle().apply {
                putInt(POSICAO_VIEW_PAGER_CATEGORIAS,position)
                putInt(ORDENACAO_LISTA_DESTAQUES,ordenar)
            }
        }
    }

    companion object{
        const val POSICAO_VIEW_PAGER_CATEGORIAS = "posicao"
        const val ORDENACAO_LISTA_DESTAQUES = "ordenar"
    }
}