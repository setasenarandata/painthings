package com.example.painthings.ui.home

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.painthings.R
import com.example.painthings.databinding.FragmentHomeBinding
import com.example.painthings.ui.HomeActivity
import com.example.painthings.ui.detail.DetailFragment
import com.example.painthings.adapter.HomeDateAdapter
import com.example.painthings.emotions.Emotions
import com.example.painthings.emotions.EmotionsActivity
import com.example.painthings.model.HomeDate
import com.example.painthings.ui.auth.AuthActivity
import com.example.painthings.view_model.ChartViewModel
import com.google.android.material.button.MaterialButton
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.justin.popupbarchart.GraphValue
import de.hdodenhof.circleimageview.CircleImageView
import io.github.muddz.styleabletoast.StyleableToast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
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
    private var isValid: Boolean = true
    private var artId: String = "empty"
    private val binding get() = _binding!!
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

        shareBtn = _binding!!.btnShare
        shareBtn.setOnClickListener {
            shareImage()
        }

        val layoutContentPosted = _binding!!.layoutContentPosted
        val layoutContentNotPosted = _binding!!.layoutContentNotPosted

        ivToday = _binding!!.ivToday
        tvTitleToday = _binding!!.tvTodayTitle
        tvArtistToday = _binding!!.tvTodayArtist
        bottomContent = _binding!!.layoutContentBottom
        circleImage = _binding!!.circleImageView

        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[ChartViewModel::class.java]

        viewModel.getChartStatus().observe(viewLifecycleOwner) {
            showLoading(false)
            if (it.uuid != "" && it.createdAt == selectedDate) {
                isValid = false
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
                setBarGraph(Emotions(0, 0, 0, 0, 0, 0))
                layoutContentPosted.visibility = View.GONE
                layoutContentNotPosted.visibility = View.VISIBLE
            }
        }

        viewModel.getArtStatus().observe(viewLifecycleOwner) {
            if (it.id == artId) {
                tvArtistToday.text = it.artistName
                tvTitleToday.text = it.title
                Glide.with(this)
                    .load(it.image)
                    .into(ivToday)
                layoutContentPosted.visibility = View.VISIBLE
                layoutContentNotPosted.visibility = View.GONE
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
        setListeners()
    }

    private fun setListeners() {
        binding.apply {
            layoutContentPosted.setOnClickListener {
                (requireActivity() as HomeActivity).addFragment(
                    DetailFragment(),
                    true,
                    DetailFragment::class.java.simpleName
                )
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

    private fun shareImage() {
   /*     val drawableResId = R.drawable.starry_night
        val drawable = ContextCompat.getDrawable(requireContext(), drawableResId)
        val bitmap = drawable?.toBitmap()

        val cachePath = File(requireContext().cacheDir, "images")
        cachePath.mkdirs()
        val imagePath = File(cachePath, "image.png")
        val imageUri = FileProvider.getUriForFile(
            requireContext(),
            "com.your.package.name.fileprovider",
            imagePath
        )

        try {
            val stream = FileOutputStream(imagePath)
            bitmap?.compress(Bitmap.CompressFormat.PNG, 100, stream)
            stream.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }

        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "image/png"
        shareIntent.putExtra(Intent.EXTRA_STREAM, imageUri)

        startActivity(Intent.createChooser(shareIntent, "Share Image"))*/
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
}