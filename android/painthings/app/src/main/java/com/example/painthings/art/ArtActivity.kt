package com.example.painthings.art

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.painthings.R
import com.example.painthings.emotions.Emotions

class ArtActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_art)

        val emotionArray = intent.getIntArrayExtra("EMOTION_ARRAY")
        var emotions = Emotions(emotionArray!![0], emotionArray!![1], emotionArray!![2], emotionArray!![3], emotionArray!![4], emotionArray!![5])

        Log.d("LOVE", emotions.love.toString())
        Log.d("SAD", emotions.sad.toString())
        Log.d("ANGER", emotions.anger.toString())
        Log.d("HAPPINESS", emotions.happiness.toString())
        Log.d("DISGUST", emotions.disgust.toString())
        Log.d("OPTIMISM", emotions.optimism.toString())


    }
}