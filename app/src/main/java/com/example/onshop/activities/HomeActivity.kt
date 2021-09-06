package com.example.onshop.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.onshop.R
import com.example.onshop.databinding.HomeActivityBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: HomeActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HomeActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigationView.setupWithNavController(
            (supportFragmentManager
                .findFragmentById(R.id.navHostFragmentHome) as NavHostFragment).navController
        )
    }
}
