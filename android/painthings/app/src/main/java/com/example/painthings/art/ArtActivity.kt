package com.example.painthings.art

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.painthings.R
import com.example.painthings.databinding.ActivityArtBinding
import com.example.painthings.emotions.Emotions
import com.example.painthings.network.ArtResponse
import com.example.painthings.view_model.ChartViewModel
import com.example.painthings.view_model.EmotionViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtActivity : AppCompatActivity() {
    private lateinit var emotionViewModel: EmotionViewModel
    private lateinit var binding: ActivityArtBinding
    private lateinit var adapter: ArtAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_art)

        binding = ActivityArtBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        adapter = ArtAdapter()

        emotionViewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[EmotionViewModel::class.java]

        emotionViewModel.getResCluster().observe(this@ArtActivity) {
            showLoading(false)
            if (it.cluster != "INVALID") {
                Toast.makeText(this, "Cluster done. Fetching cluster container...", Toast.LENGTH_LONG).show()
                Log.d("RESCLUSTER", it.cluster)
                val clusterNumber = it.cluster.substring(1,2).toInt()
                fetchArtCluster(clusterNumber)
            } else {
                Log.e("RESCLUSTER", "INVALID")
            }
        }

        emotionViewModel.getClusterContainer().observe(this@ArtActivity) {
            showLoading(false)
            if (it.isNotEmpty()) {
                Toast.makeText(this, "Container fetched. Generating result from WikiArt...", Toast.LENGTH_LONG).show()
                Log.d("CLUSTERCONTAINER", it.size.toString())
                CoroutineScope(Dispatchers.Main).launch {
                    fetchWikiArt(it)
                }
            } else {
                Log.d("CLUSTERCONTAINER", "INVALID")
            }
        }
        emotionViewModel.getWikiArtList().observe(this@ArtActivity) {
            Log.d("INSIDEWIKIART", it.size.toString())
            if (it.isNotEmpty()) {
                Toast.makeText(this, "Data fetching done", Toast.LENGTH_LONG).show()
                adapter.setList(it)
                showLoading(false)
            } else {
                Log.d("WIKIARTLIST", "INVALID")
            }
        }


        binding.apply {
            rvArtResponse.layoutManager = LinearLayoutManager(this@ArtActivity)
            rvArtResponse.setHasFixedSize(true)
            rvArtResponse.adapter = adapter
        }

        val emotionArray = intent.getIntArrayExtra("EMOTION_ARRAY")
        val emotions = Emotions(emotionArray!![0], emotionArray[1], emotionArray[2], emotionArray[3], emotionArray[4], emotionArray[5])

        Log.d("LOVE", emotions.love.toString())
        Log.d("SADNESS", emotions.sadness.toString())
        Log.d("ANGER", emotions.anger.toString())
        Log.d("HAPPINESS", emotions.happiness.toString())
        Log.d("DISGUST", emotions.disgust.toString())
        Log.d("OPTIMISM", emotions.optimism.toString())

        predictCluster(emotions)
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            binding.artProgressBar.visibility = View.VISIBLE
        } else {
            binding.artProgressBar.visibility = View.GONE
        }
    }

    private suspend fun fetchWikiArt(it: List<ArtResponse>) {
        binding.apply {
            showLoading(true)
            emotionViewModel.callWikiArt(it)
        }
    }

    private fun predictCluster(emotions: Emotions) {
        binding.apply {
            showLoading(true)
            emotionViewModel.getCluster(emotions)
        }
    }

    private fun fetchArtCluster(cluster: Int) {
        binding.apply {
            showLoading(true)
            emotionViewModel.fetchCluster(cluster)
        }
    }
}