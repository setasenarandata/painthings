package com.example.painthings.ui.detail

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.example.painthings.R
import com.example.painthings.databinding.FragmentDetailBinding
import com.google.android.material.button.MaterialButton

class DetailFragment : Fragment() {
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private lateinit var shareBtn: MaterialButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        val rootView = binding.root

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
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "image/png"
        startActivity(Intent.createChooser(shareIntent, "Share Image"))
    }
}




