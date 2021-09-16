package com.example.onshop.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.onshop.databinding.FluxoPagamentoActivityBinding

class FluxoPagamentoActivity : AppCompatActivity() {
    private lateinit var binding: FluxoPagamentoActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FluxoPagamentoActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}