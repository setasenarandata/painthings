package com.example.painthings.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.painthings.R
import com.example.painthings.databinding.ActivityHomeBinding
import com.example.painthings.databinding.ActivityLoginBinding
import com.example.painthings.emotions.EmotionsActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var addEmotionsButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_home)

        addEmotionsButton = findViewById(R.id.addEmotionsButton)
        addEmotionsButton.setOnClickListener {
            val i = Intent(this@HomeActivity, EmotionsActivity::class.java)
            startActivity(i)
            finish()
        }


    }
}