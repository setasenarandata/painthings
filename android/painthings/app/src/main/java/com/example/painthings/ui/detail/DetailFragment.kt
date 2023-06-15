package com.example.painthings.ui.detail

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.provider.Settings
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import coil.ImageLoader
import coil.request.ImageRequest
import coil.request.SuccessResult
import com.bumptech.glide.Glide
import com.example.painthings.R
import com.example.painthings.databinding.FragmentDetailBinding
import com.example.painthings.network.WikiArtDetailResponse
import com.google.android.material.button.MaterialButton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileOutputStream

class DetailFragment(art: WikiArtDetailResponse, journal: String) : Fragment() {
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private lateinit var shareBtn: MaterialButton
    private val title = art.title
    private val artist = art.artistName
    private val description = art.description
    private val image = art.image
    private val myJournal = journal
    private val storagePermissionCode = 100


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        val rootView = binding.root

        _binding!!.tvDetail.text = title
        _binding!!.tvArtist.text = artist
        _binding!!.tvMyJournal.text = myJournal

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
            if (checkPermission()) {
                Log.d("CLICKED", "INITIATED")
                saveAndShareImage()
            } else {
                Log.d("CLICKED", "DENIED")
                requestPermission()
            }
        }
        return rootView
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun saveAndShareImage() {
        lifecycleScope.launch {
            val bitMap = getBitMap(image.toString())
            withContext(Dispatchers.IO) {
                val file =  File("${Environment.getExternalStorageDirectory()}/${title}.jpg")
                val fileOutputStream = FileOutputStream(file)
                bitMap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream)
                fileOutputStream.flush()
                fileOutputStream.close()

                val stringPath = MediaStore.Images.Media.insertImage(requireActivity().contentResolver, bitMap, "generated_by_painthings", null)
                val uri = Uri.parse(stringPath)

                val feedIntent = Intent(Intent.ACTION_SEND)
                feedIntent.type = "image/*"
                feedIntent.putExtra(Intent.EXTRA_STREAM, uri)
                feedIntent.setPackage("com.instagram.android")

                val storiesIntent = Intent("com.instagram.share.ADD_TO_STORY")
                storiesIntent.setDataAndType(uri, "jpg")
                storiesIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                storiesIntent.setPackage("com.instagram.android")

                val i = Intent(Intent.ACTION_SEND)
                i.type = "image/*"
                i.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                i.putExtra(Intent.EXTRA_STREAM, Uri.parse(stringPath))

                requireActivity().grantUriPermission(
                    "com.instagram.android", uri, Intent.FLAG_GRANT_READ_URI_PERMISSION
                )

                val chooserIntent = Intent.createChooser(feedIntent, "Share to...")
                chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, arrayOf(storiesIntent, i))
                startActivity(chooserIntent)
            }

        }
    }

    private fun requestPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            try {
                Log.d("PERMISSION", "TRY INITIATED")
                val intent = Intent()
                intent.action = Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION
                val uri = Uri.fromParts("package", requireActivity().packageName, null)
                intent.data = uri
                storageActivityResultLauncher.launch(intent)

            } catch (e: java.lang.Exception) {
                val intent = Intent()
                intent.action = Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION
                storageActivityResultLauncher.launch(intent)
            }
        } else {
            ActivityCompat.requestPermissions(requireActivity(),
                arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE),
                storagePermissionCode
            )
        }
    }

    private val storageActivityResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            if (Environment.isExternalStorageManager()) {
                saveAndShareImage()

            } else {
                Log.d("TAG", "DENIED")
            }
        }  else {
            ActivityCompat.requestPermissions(requireActivity(),
                arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE),
                storagePermissionCode
            )
        }
    }

    private fun checkPermission(): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            Environment.isExternalStorageManager()
        }  else {
            val write = ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE)
            val read = ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.READ_EXTERNAL_STORAGE)
            write == PackageManager.PERMISSION_GRANTED && read == PackageManager.PERMISSION_GRANTED
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == storagePermissionCode) {
            if (grantResults.isNotEmpty()) {
                val write = grantResults[0] == PackageManager.PERMISSION_GRANTED
                val read = grantResults[1] == PackageManager.PERMISSION_GRANTED

                if (write && read){
                    saveAndShareImage()
                } else {
                    Log.d("TAG", "DENIED")
                }

            }
        }
    }

    private suspend fun getBitMap(url: String): Bitmap {
        val loading = ImageLoader(requireContext())
        val request = ImageRequest.Builder(requireContext())
            .data(url)
            .build()

        val result = (loading.execute(request) as SuccessResult).drawable
        return (result as BitmapDrawable).bitmap
    }
}