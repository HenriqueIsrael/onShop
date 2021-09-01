package com.example.onshop.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.onshop.databinding.CadastroFragmentBinding
import com.example.onshop.databinding.SplashFragmentBinding

class CadastroFragment: Fragment() {

    private var _binding: CadastroFragmentBinding? = null
    private val binding: CadastroFragmentBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= CadastroFragmentBinding.inflate(inflater, container,false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }



}