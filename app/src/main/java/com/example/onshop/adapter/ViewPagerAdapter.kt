package com.example.onshop.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.onshop.fragments.ProdutosFragment

class ViewPagerAdapter(fragment: Fragment, private val ordenar: Int, private val paginaTotal: Int): FragmentStateAdapter(fragment) {
    //Numero de paginas do viewpager
    override fun getItemCount(): Int {
        return paginaTotal
    }

    //qual fragmento vai ser aberto em cada página
    override fun createFragment(position: Int): Fragment {
        return ProdutosFragment().also {
            it.arguments = Bundle().apply {
                putInt("posicao",position)
                putInt("ordenar",ordenar)
            }
        }
    }
}