package com.example.painthings.ui.detail

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.painthings.R
import com.example.painthings.databinding.FragmentDetailBinding
import com.example.painthings.network.WikiArtDetailResponse
import com.google.android.material.button.MaterialButton

class DetailFragment(art: WikiArtDetailResponse) : Fragment() {
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private lateinit var shareBtn: MaterialButton
    private val title = art.title
    private val artist = art.artistName
    private val description = art.description
    private val image = art.image


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        val rootView = binding.root

        _binding!!.tvDetail.text = title
        _binding!!.tvArtist.text = artist

        if (description == "") {
            val noDesc = "No description provided by WikiArt"
            _binding!!.tvDescription.text = noDesc
        } else {
            _binding!!.tvDescription.text = description
        }
        Glide.with(this)
            .load(image)
            .into(_binding!!.ivDetail)

        // Get the overlay view
        val overlayView = rootView.findViewById<View>(R.id.overlay)

        // Set the overlay click listener
        overlayView.setOnClickListener {
            requireActivity().onBackPressed()
        }

        shareBtn = binding.btnShare
        shareBtn.setOnClickListener {
            shareImage()
        }
        return rootView
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun shareImage() {
//        val shareIntent = Intent(Intent.ACTION_SEND)
//        shareIntent.type = "image/png"
//        startActivity(Intent.createChooser(shareIntent, "Share Image"))
    }
}