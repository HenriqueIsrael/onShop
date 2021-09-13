package com.example.onshop.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.onshop.R
import com.example.onshop.databinding.HomeActivityBinding
import com.example.onshop.databinding.InfoProdutoActivityBinding

class InfoProdutoActivity : AppCompatActivity() {
    private lateinit var binding: InfoProdutoActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = InfoProdutoActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}