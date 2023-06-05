package com.example.painthings.emotions

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.viewpager.widget.PagerAdapter
import com.example.painthings.R

class EmotionsViewPagerAdapter(private var context: Context) : PagerAdapter() {
    private var counter = 0
    private var headings = intArrayOf(
        R.string.emotion_heading_1,
        R.string.emotion_heading_2,
        R.string.emotion_heading_3,
        R.string.emotion_heading_4,
        R.string.emotion_heading_5,
        R.string.emotion_heading_6,
    )

    private var subtitle = intArrayOf(
        R.string.emotion_subtitle_1,
        R.string.emotion_subtitle_2,
        R.string.emotion_subtitle_3,
        R.string.emotion_subtitle_4,
        R.string.emotion_subtitle_5,
        R.string.emotion_subtitle_6,
    )

    override fun getCount(): Int {
        return headings.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as LinearLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val layoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view: View = layoutInflater.inflate(R.layout.activity_emotions, container, false)
        val slideTitle = view.findViewById<View>(R.id.emotionTitle) as TextView
        val slideSubtitle = view.findViewById<View>(R.id.emotionSubtitle) as TextView
        val slideCounter = view.findViewById<View>(R.id.emotionCounter) as TextView

        val plusButton = view.findViewById<AppCompatButton>(R.id.plusButton)
        val minusButton = view.findViewById<AppCompatButton>(R.id.minusButton)

        plusButton.setOnClickListener {
            if (counter < 5) counter++
            slideCounter.text = counter.toString()
        }

        minusButton.setOnClickListener {
            if (counter > 0) counter--
            slideCounter.text = counter.toString()
        }

        slideTitle.setText(headings[position])
        slideSubtitle.setText(subtitle[position])
        slideCounter.text = getCounter().toString()
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as LinearLayout)
    }

    fun getCounter(): Int {
        return counter
    }

    fun setCounter(value: Int): Int {
        counter = value
        return counter
    }

    fun resetCounter() {
        counter = 0
    }

    override fun getItemPosition(`object`: Any): Int {
        return POSITION_NONE
    }
}