package com.example.painthings.emotions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.painthings.R
import com.example.painthings.databinding.ActivityCreateNewPostBinding
import com.example.painthings.network.PostBody
import com.google.android.material.textfield.TextInputEditText
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody

class CreateNewPost : AppCompatActivity() {
    companion object {
        const val EXTRA_YEAR = "extra_year"
        const val EXTRA_ARTIST = "extra_artist"
        const val EXTRA_TITLE = "extra_title"
        const val EXTRA_PAINTINGS = "extra_paintings"
        const val EXTRA_ID = "extra_id"
    }

    private lateinit var year: TextView
    private lateinit var artist: TextView
    private lateinit var title: TextView
    private lateinit var paintings: ImageView
    private lateinit var buttonPost: Button
    private lateinit var journalEditText: TextInputEditText
    private lateinit var myBinding: ActivityCreateNewPostBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        myBinding = ActivityCreateNewPostBinding.inflate(layoutInflater)
        setContentView(myBinding.root)

        val emotionArray = intent.getIntArrayExtra("emotions")


        title = findViewById(R.id.tvArtTitleJournal)
        year = findViewById(R.id.tvArtYearJournal)
        artist = findViewById(R.id.tvArtArtistJournal)
        paintings = findViewById(R.id.ivPaintingJournal)

        buttonPost = findViewById(R.id.journalPostButton)

        journalEditText = findViewById(R.id.journalInput)

        val titleIntent = intent.getStringExtra(EXTRA_TITLE)
        val yearIntent = intent.getStringExtra(EXTRA_YEAR)
        val artistIntent = intent.getStringExtra(EXTRA_ARTIST)
        val paintingsIntent = intent.getStringExtra(EXTRA_PAINTINGS)

        val idPaintings = intent.getStringExtra(EXTRA_ID)

        title.text = titleIntent
        year.text = yearIntent
        artist.text = artistIntent
        Glide.with(this)
            .load(paintingsIntent)
            .into(paintings)

        buttonPost.setOnClickListener {
            post(emotionArray!!, idPaintings!!)
        }
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            myBinding.journalProgressBar.visibility = View.VISIBLE
        } else {
            myBinding.journalProgressBar.visibility = View.GONE
        }
    }

    private fun post(array: IntArray, id: String) {
        myBinding.apply {
            val journal = journalEditText.text.toString()
            val payload = PostBody(
                array[0],
                array[1],
                array[2],
                array[3],
                array[4],
                array[5],
                id,
                journal
            )

//            if (locationSwitch.isChecked) {
//                viewModel.postWithLocation(description, imageMultipart, token, userLat, userLon)
//                showLoading(true)
//            } else {
//                // Call the API without location information
//                viewModel.post(description, imageMultipart, token)
//                showLoading(true)
//            }
        }
    }
}