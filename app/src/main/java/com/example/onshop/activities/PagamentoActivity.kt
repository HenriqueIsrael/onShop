package com.example.onshop.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.onshop.R
import com.example.onshop.databinding.HomeActivityBinding
import com.example.onshop.databinding.InfoProdutoActivityBinding
import com.example.onshop.databinding.PagamentoActivityBinding

class PagamentoActivity : AppCompatActivity() {
    private lateinit var binding: PagamentoActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = PagamentoActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}