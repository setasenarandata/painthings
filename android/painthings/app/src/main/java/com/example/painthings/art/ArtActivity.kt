package com.example.painthings.art

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.painthings.R
import com.example.painthings.databinding.ActivityArtBinding
import com.example.painthings.emotions.CreateNewPost
import com.example.painthings.emotions.Emotions
import com.example.painthings.network.ArtResponse
import com.example.painthings.network.WikiArtDetailResponse
import com.example.painthings.view_model.EmotionViewModel
import io.github.muddz.styleabletoast.StyleableToast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtActivity : AppCompatActivity() {
    private lateinit var emotionViewModel: EmotionViewModel
    private lateinit var binding: ActivityArtBinding
    private lateinit var adapter: ArtAdapter
    private lateinit var refreshButton: Button
    private var clusterNumber: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_art)

        binding = ActivityArtBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        adapter = ArtAdapter()

        refreshButton = findViewById(R.id.btRefresh)

        val emotionArray = intent.getIntArrayExtra("EMOTION_ARRAY")
        val emotions = Emotions(emotionArray!![0], emotionArray[1], emotionArray[2], emotionArray[3], emotionArray[4], emotionArray[5])

        adapter.setOnItemClickCallback(object : ArtAdapter.OnItemClickCallback {
            override fun onItemClick(
                data: WikiArtDetailResponse,
                title: TextView,
                artist: TextView,
                year: TextView,
                paintings: ImageView
            ) {
                val paintingsPair = Pair<View?, String?>(paintings, "sharedElementTransPaintings")
                val titlePair = Pair.create<View?, String?>(title, "sharedElementTransTitle")
                val artistPair = Pair.create<View?, String?>(artist, "sharedElementTransArtist")
                val yearPair = Pair.create<View?, String?>(year, "sharedElementTransYear")
                Intent(this@ArtActivity, CreateNewPost::class.java).also {
                    it.putExtra(CreateNewPost.EXTRA_YEAR, data.completitionYear)
                    it.putExtra(CreateNewPost.EXTRA_ARTIST, data.artistName)
                    it.putExtra(CreateNewPost.EXTRA_TITLE, data.title)
                    it.putExtra(CreateNewPost.EXTRA_PAINTINGS, data.image)
                    it.putExtra(CreateNewPost.EXTRA_ID, data.id)
                    it.putExtra("emotions", emotionArray)
                    startActivity(it, ActivityOptionsCompat.makeSceneTransitionAnimation(
                        this@ArtActivity, titlePair, artistPair, yearPair, paintingsPair
                    ).toBundle())
                }
            }
        })

        emotionViewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[EmotionViewModel::class.java]

        emotionViewModel.getResCluster().observe(this@ArtActivity) {
            showLoading(false)
            if (it.cluster != "INVALID") {
                clusterNumber = it.cluster.substring(1,2).toInt()
                fetchArtCluster(clusterNumber)
            } else {
                StyleableToast.makeText(this, "Cluster INVALID", Toast.LENGTH_LONG, R.style.mytoast).show()
            }
        }

        emotionViewModel.getClusterContainer().observe(this@ArtActivity) {
            showLoading(false)
            if (it.isNotEmpty()) {
                CoroutineScope(Dispatchers.Main).launch {
                    fetchWikiArt(it)
                }
            } else {
                StyleableToast.makeText(this, "Container INVALID", Toast.LENGTH_LONG, R.style.mytoast).show()
            }
        }

        emotionViewModel.getWikiArtList().observe(this@ArtActivity) {
            if (it.isNotEmpty()) {
                adapter.setList(it)
                showLoading(false)
                refreshButton.visibility = View.VISIBLE
            } else {
                StyleableToast.makeText(this, "WikiArt INVALID", Toast.LENGTH_LONG, R.style.mytoast).show()
            }
        }

        binding.apply {
            rvArtResponse.layoutManager = LinearLayoutManager(this@ArtActivity)
            rvArtResponse.setHasFixedSize(true)
            rvArtResponse.adapter = adapter
        }

        predictCluster(emotions)

        refreshButton.setOnClickListener {
            fetchArtCluster(clusterNumber)
        }
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