package com.example.onshop.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.onshop.fragments.ProdutosFragment

class ViewPagerAdapter(fragment: Fragment, private val ordenar: Int): FragmentStateAdapter(fragment) {
    //Numero de paginas do viewpager
    override fun getItemCount(): Int {
        return 3
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