package com.example.painthings.art

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.painthings.R

class ArtActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_art)

        val counterValues = intent.getIntArrayExtra("EMOTION_ARRAY")
        Log.d("INSIDEART", counterValues.toString())
    }
}