package com.example.painthings.art

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import com.example.painthings.R
import com.example.painthings.databinding.ActivityArtBinding
import com.example.painthings.emotions.Emotions
import com.example.painthings.view_model.ChartViewModel
import com.example.painthings.view_model.EmotionViewModel

class ArtActivity : AppCompatActivity() {
    private lateinit var emotionViewModel: EmotionViewModel
    private lateinit var binding: ActivityArtBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_art)

        binding = ActivityArtBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        emotionViewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[EmotionViewModel::class.java]

        emotionViewModel.getResCluster().observe(this@ArtActivity) {
//            showLoading(false)
            if (it.cluster != "INVALID") {
                Log.d("RESCLUSTER", it.cluster)
            } else {
                Log.d(TAG, "INVALID")
            }
        }

        val emotionArray = intent.getIntArrayExtra("EMOTION_ARRAY")
        var emotions = Emotions(emotionArray!![0], emotionArray!![1], emotionArray!![2], emotionArray!![3], emotionArray!![4], emotionArray!![5])

        Log.d("LOVE", emotions.love.toString())
        Log.d("SADNESS", emotions.sadness.toString())
        Log.d("ANGER", emotions.anger.toString())
        Log.d("HAPPINESS", emotions.happiness.toString())
        Log.d("DISGUST", emotions.disgust.toString())
        Log.d("OPTIMISM", emotions.optimism.toString())

        predictCluster(emotions)
    }

    private fun predictCluster(emotions: Emotions) {
        binding.apply {
//            showLoading(true)
            emotionViewModel.getCluster(emotions)
        }
    }
}