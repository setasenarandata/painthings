package com.example.painthings.ui.home

import android.Manifest
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Canvas
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
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import coil.ImageLoader
import coil.request.ImageRequest
import coil.request.SuccessResult
import com.bumptech.glide.Glide
import com.example.painthings.R
import com.example.painthings.adapter.HomeDateAdapter
import com.example.painthings.databinding.FragmentHomeBinding
import com.example.painthings.emotions.Emotions
import com.example.painthings.emotions.EmotionsActivity
import com.example.painthings.model.HomeDate
import com.example.painthings.network.WikiArtDetailResponse
import com.example.painthings.ui.HomeActivity
import com.example.painthings.ui.auth.AuthActivity
import com.example.painthings.ui.detail.DetailFragment
import com.example.painthings.view_model.ChartViewModel
import com.google.android.material.button.MaterialButton
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.justin.popupbarchart.GraphValue
import de.hdodenhof.circleimageview.CircleImageView
import io.github.muddz.styleabletoast.StyleableToast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.*


class HomeFragment : Fragment(), HomeDateAdapter.DateItemClickListener {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var viewModel: ChartViewModel
    private lateinit var addEmotionsButton: FloatingActionButton
    private lateinit var shareBtn: MaterialButton
    private lateinit var ivToday: ImageView
    private lateinit var tvTitleToday: TextView
    private lateinit var tvArtistToday: TextView
    private lateinit var bottomContent: LinearLayout
    private lateinit var circleImage: CircleImageView
    private lateinit var todayTitle: TextView
    private var isValid: Boolean = true
    private var artId: String = "empty"
    private var imageUrl = ""
    private val binding get() = _binding!!
    private val STORAGE_PERMISSION_CODE = 100
    private var selectedDate: String = SimpleDateFormat(
        "dd-MM-yyyy",
        Locale.getDefault()
    ).format(
        Date().time
    )

    private var myCalendar = Calendar.getInstance()
    private var jakartaTimeZone = TimeZone.getTimeZone("Asia/Jakarta")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val sharedPreferences = requireContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val name = sharedPreferences.getString("name", "User")!!
        val noPost = "You haven\'t posted anything today"

        myCalendar.timeZone = jakartaTimeZone

        // greet user
        val greetingString = resources.getString(R.string.greet_user)
        val greeting = String.format(greetingString, name)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        addEmotionsButton = _binding!!.fabAdd
        _binding!!.tvHomeGreet.text = greeting
        addEmotionsButton.setOnClickListener {
            addNewEmotions()
        }

        ivToday = _binding!!.ivToday
        tvTitleToday = _binding!!.tvTodayTitle
        tvArtistToday = _binding!!.tvTodayArtist
        bottomContent = _binding!!.layoutContentToday
        circleImage = _binding!!.circleImageView
        todayTitle = _binding!!.tvToday

        bottomContent.visibility = View.GONE

        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[ChartViewModel::class.java]

        viewModel.getChartStatus().observe(viewLifecycleOwner) {
            showLoading(false)
            if (it.uuid != "" && it.createdAt == selectedDate) {
                val dateFormat = "About ${it.createdAt}"
                isValid = false
                todayTitle.text = dateFormat
                val emotion = Emotions(
                    it.love,
                    it.sadness,
                    it.anger,
                    it.happiness,
                    it.disgust,
                    it.optimism
                )
                setBarGraph(emotion)
                artId = it.art_id!!
                CoroutineScope(Dispatchers.Main).launch {
                    setAboutToday(artId)
                }
            } else {
                Log.d("WHERE", "INSIDE ELSE EMOTIONS 0")
                setBarGraph(Emotions(0, 0, 0, 0, 0, 0))
                bottomContent.visibility = View.GONE
                todayTitle.text = noPost
            }
        }

        viewModel.getArtStatus().observe(viewLifecycleOwner) {
            if (it.id == artId) {
                tvArtistToday.text = it.artistName
                tvTitleToday.text = it.title
                imageUrl = it.image.toString()
                Glide.with(this)
                    .load(it.image)
                    .into(ivToday)
                bottomContent.visibility = View.VISIBLE
                setListeners(it)
            } else {
                StyleableToast.makeText(requireContext(), "Error fetching about today", Toast.LENGTH_LONG, R.style.mytoast).show()
            }
        }

        circleImage.setOnClickListener {
            val builder = AlertDialog.Builder(requireContext())
            builder.setTitle("Logout")
            builder.setMessage("Are you sure you want to logout?")
            builder.setPositiveButton("Yes") { dialog, _ ->
                // Call the logout() function or perform any other desired action
                logout()
                dialog.dismiss()
            }
            builder.setNegativeButton("No") { dialog, _ ->
                dialog.dismiss()
            }
            val dialog = builder.create()
            dialog.show()
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initLittleCalendar()
        getPostByDate()
    }

    private fun setListeners(art: WikiArtDetailResponse) {
        binding.apply {
            bottomContent.setOnClickListener {
                (requireActivity() as HomeActivity).addFragment(
                    DetailFragment(art),
                    true,
                    DetailFragment::class.java.simpleName
                )
            }

            shareBtn = _binding!!.btnShare
            shareBtn.setOnClickListener {
                if (checkPermission()) {
                    Log.d("CLICKED", "INITIATED")
                    saveAndShareImage()
                } else {
                    Log.d("CLICKED", "DENIED")
                    requestPermission()
                }
            }
        }
    }

    private fun initLittleCalendar() {
        val numDay = myCalendar.get(Calendar.DATE).toString()

        val homeDateList: ArrayList<HomeDate> = ArrayList()

        for (dates in getDaysList()) {
            val homeDate = if (dates.get(Calendar.DATE).toString() == numDay) {
                HomeDate(dates, true)
            } else {
                HomeDate(dates)
            }
            homeDateList.add(homeDate)
        }

        binding.rvDate.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = HomeDateAdapter(homeDateList, this@HomeFragment)
        }
    }

    private fun setBarGraph(emotions: Emotions) {
        binding.bcEmotions.apply {
            setGraphValues(
                arrayListOf(
                    GraphValue(
                        day = 1,
                        id = 1,
                        progress = emotions.love * 20,
                        isToday = false,
                        showToolTip = false
                    ),
                    GraphValue(
                        day = 2,
                        id = 2,
                        progress = emotions.sadness * 20,
                        isToday = false,
                        showToolTip = false
                    ),
                    GraphValue(
                        day = 3,
                        id = 3,
                        progress = emotions.anger * 20,
                        isToday = false,
                        showToolTip = false
                    ),
                    GraphValue(
                        day = 4,
                        id = 4,
                        progress = emotions.happiness * 20,
                        isToday = false,
                        showToolTip = false
                    ),
                    GraphValue(
                        day = 5,
                        id = 5,
                        progress = emotions.disgust * 20,
                        isToday = false,
                        showToolTip = false
                    ),
                    GraphValue(
                        day = 6,
                        id = 6,
                        progress = emotions.optimism * 20,
                        isToday = false,
                        showToolTip = false
                    ),
                )
            )
        }
    }

    private fun getDaysList(): List<Calendar> {

        val readOnlyView = mutableListOf<Calendar>()
        val calendar = Calendar.getInstance()
        val days = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
        var index = 0
        while (index < days) {
            readOnlyView += getDaysPlus(index)
            index++
        }
        return readOnlyView
    }

    private fun getDaysPlus(daysAgo: Int): Calendar {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.DAY_OF_MONTH, 1)
        calendar.add(Calendar.DAY_OF_MONTH, +daysAgo)

        return calendar
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun saveAndShareImage() {
        lifecycleScope.launch {
            Log.d("IMAGEURL", imageUrl )
            val bitMap = getBitMap(imageUrl)
            withContext(Dispatchers.IO) {
                val file =  File("${Environment.getExternalStorageDirectory()}/painthings/${tvTitleToday.text}.jpg");
                val fileOutputStream = FileOutputStream(file)
                bitMap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream)
                fileOutputStream.flush()
                fileOutputStream.close()

                val stringPath = MediaStore.Images.Media.insertImage(requireActivity().getContentResolver(), bitMap, "Share Image", null)
                val uri = Uri.parse(stringPath)

                val feedIntent = Intent(Intent.ACTION_SEND)
                feedIntent.type = "image/*"
                feedIntent.putExtra(Intent.EXTRA_STREAM, uri)
                feedIntent.setPackage("com.instagram.android")

                val storiesIntent = Intent("com.instagram.share.ADD_TO_STORY")
                storiesIntent.setDataAndType(uri, "jpg")
                storiesIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                storiesIntent.setPackage("com.instagram.android")

                val i = Intent(Intent.ACTION_SEND);
                i.type = "image/*";
                i.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                i.putExtra(Intent.EXTRA_STREAM, Uri.parse(stringPath));

                requireActivity().grantUriPermission(
                    "com.instagram.android", uri, Intent.FLAG_GRANT_READ_URI_PERMISSION
                )

                val chooserIntent = Intent.createChooser(feedIntent, "Share to...")
                chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, arrayOf(storiesIntent, i))
                startActivity(chooserIntent)
            };

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
                STORAGE_PERMISSION_CODE
            )
        }
    }

    private val storageActivityResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        Log.d("RESULTLAUNCHER", "INITIATED")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            if (Environment.isExternalStorageManager()) {
                Log.d("RESULTLAUNCHER", "INITIATED 2")
                saveAndShareImage()

            } else {
                Log.d("RESULTLAUNCHER", "DENIED")
            }
        }  else {
            ActivityCompat.requestPermissions(requireActivity(),
                arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE),
                STORAGE_PERMISSION_CODE
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

        if (requestCode == STORAGE_PERMISSION_CODE) {
            if (grantResults.isNotEmpty()) {
                val write = grantResults[0] == PackageManager.PERMISSION_GRANTED
                val read = grantResults[1] == PackageManager.PERMISSION_GRANTED

                if (write && read){
                    Log.d("ONREQUEST", "INITIATED 2")
                    saveAndShareImage()
                } else {
                    Log.d("ONREQUEST", "DENIED")
                }

            }
        }
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            binding.progressBarChart.visibility = View.VISIBLE
        } else {
            binding.progressBarChart.visibility = View.GONE
        }
    }

    private fun getPostByDate() {
        binding.apply {
            showLoading(true)
            viewModel.getChart(selectedDate)
        }
    }

    override fun onDateItemClicked(date: Date) {
        val isoDateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
        val isoDate = isoDateFormat.format(date)

        selectedDate = isoDate
        getPostByDate()
    }

    private fun logout() {
        val sharedPrefs = requireContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val editor = sharedPrefs.edit()
        editor.clear()
        editor.apply()

        StyleableToast.makeText(requireContext(), "See ya!", Toast.LENGTH_LONG, R.style.mytoast).show()
        val intent = Intent(requireContext(), AuthActivity::class.java)
        startActivity(intent)
    }

    private fun addNewEmotions() {
        if (isValid) {
            val i = Intent(requireContext(), EmotionsActivity::class.java)
            startActivity(i)
        } else {
            StyleableToast.makeText(requireContext(), "You can only make one journal a day.", Toast.LENGTH_LONG, R.style.mytoast).show()
        }
    }

    private suspend fun setAboutToday(artId: String) {
        binding.apply {
            viewModel.getArtDetails(artId)
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