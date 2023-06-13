package com.example.painthings.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.painthings.R
import com.example.painthings.databinding.ActivityAuthBinding

class AuthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.auth_container, LoginFragment())
                .commit()
        }
    }
}