package com.example.painthings.ui.home

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.core.graphics.drawable.toBitmap
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.painthings.R
import com.example.painthings.databinding.FragmentHomeBinding
import com.example.painthings.ui.HomeActivity
import com.example.painthings.ui.detail.DetailFragment
import com.example.painthings.adapter.HomeDateAdapter
import com.example.painthings.emotions.Emotions
import com.example.painthings.emotions.EmotionsActivity
import com.example.painthings.model.HomeDate
import com.google.android.material.button.MaterialButton
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.justin.popupbarchart.GraphValue
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.util.*

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var addEmotionsButton: FloatingActionButton
    private lateinit var shareBtn: MaterialButton
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val sharedPreferences = requireContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val name = sharedPreferences.getString("name", "User")!!

        // greet user
        val greetingString = resources.getString(R.string.greet_user)
        val greeting = String.format(greetingString, name)
        _binding!!.tvHomeGreet.text = greeting

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        addEmotionsButton = _binding!!.fabAdd
        addEmotionsButton.setOnClickListener {
            val i = Intent(requireContext(), EmotionsActivity::class.java)
            startActivity(i)
        }
        shareBtn = _binding!!.btnShare
        shareBtn.setOnClickListener {
            shareImage()
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initLittleCalendar()

        // Nembak ke api terus nanti setiap ganti hari
        val emotion = Emotions(1, 2,3,5,2,3)

        setBarGraph(emotion)
        setListeners()
    }

    private fun setListeners() {
        binding.apply {
            ivToday.setOnClickListener {
                (requireActivity() as HomeActivity).addFragment(
                    DetailFragment(),
                    true,
                    DetailFragment::class.java.simpleName
                )
            }
        }
    }

    private fun initLittleCalendar() {
        val date = Calendar.getInstance()
        val numDay = date.get(Calendar.DATE).toString()

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
            adapter = HomeDateAdapter(homeDateList)
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
                        progress = emotions.sad * 20,
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
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "image/png"
        startActivity(Intent.createChooser(shareIntent, "Share Image"))
    }
}