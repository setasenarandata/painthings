package com.example.painthings.emotions

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.example.painthings.R
import com.example.painthings.art.ArtActivity
import com.example.painthings.ui.HomeActivity

class EmotionsActivity : AppCompatActivity() {
    private lateinit var mSLideViewPager: ViewPager
    private lateinit var mDotLayout: LinearLayout
    private lateinit var dots: Array<TextView?>
    private lateinit var viewPagerAdapter: EmotionsViewPagerAdapter
    private lateinit var nextbtn: Button
    private lateinit var backBtn: Button

    private val counterValues = mutableListOf(0, 0, 0, 0, 0, 0)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.emotions_layout)
        nextbtn = findViewById(R.id.nextButton)
        backBtn = findViewById(R.id.backButton)

        nextbtn.setOnClickListener {
            val currentEmotion = getItem(0)

            // Save the previous counter value for the current emotion
            counterValues[currentEmotion] = viewPagerAdapter.getCounter()

            if (currentEmotion < 5) {
                if (counterValues[getItem(1)] == 0) viewPagerAdapter.resetCounter()
                else viewPagerAdapter.setCounter(counterValues[getItem(1)])

                mSLideViewPager.setCurrentItem(getItem(1), true)
            } else {
                val i = Intent(this@EmotionsActivity, ArtActivity::class.java)

                i.putExtra("EMOTION_ARRAY", counterValues.toIntArray())
                Log.d("FINALEMOTION", counterValues.toString())
                startActivity(i)
                finish()
            }

            viewPagerAdapter.notifyDataSetChanged()
        }

        backBtn.setOnClickListener {
            val currentEmotion = getItem(0)

            // Save the previous counter value for the current emotion
            counterValues[currentEmotion] = viewPagerAdapter.getCounter()

            if (currentEmotion > 0) {
                if (counterValues[getItem(-1)] == 0) viewPagerAdapter.resetCounter()
                else viewPagerAdapter.setCounter(counterValues[getItem(-1)])
                mSLideViewPager.setCurrentItem(getItem(-1), true)
            } else {
                val i = Intent(this@EmotionsActivity, HomeActivity::class.java)
                startActivity(i)
                finish()
            }

            viewPagerAdapter.notifyDataSetChanged()
        }


        mSLideViewPager = findViewById<View>(R.id.viewPagerEmotions) as ViewPager
        mDotLayout = findViewById<View>(R.id.pageIndicator) as LinearLayout
        viewPagerAdapter = EmotionsViewPagerAdapter(this)
        mSLideViewPager.adapter = viewPagerAdapter
        setUpindicator(0)
        mSLideViewPager.addOnPageChangeListener(viewListener)
    }

    fun setUpindicator(position: Int) {
        dots = arrayOfNulls(6)
        mDotLayout.removeAllViews()
        for (i in dots.indices) {
            dots[i] = TextView(this)
            dots[i]!!.text = Html.fromHtml("&#8226")
            dots[i]!!.textSize = 35f
            dots[i]!!.setTextColor(resources.getColor(R.color.inactive, applicationContext.theme))
            mDotLayout.addView(dots[i])
        }
        dots[position]!!.setTextColor(resources.getColor(R.color.white, applicationContext.theme))
    }

    private var viewListener: ViewPager.OnPageChangeListener = object :
        ViewPager.OnPageChangeListener {
        override fun onPageScrolled(
            position: Int, positionOffset: Float, positionOffsetPixels: Int
        ) {
        }

        override fun onPageSelected(position: Int) {
            setUpindicator(position)
        }

        override fun onPageScrollStateChanged(state: Int) {}
    }

    private fun getItem(i: Int): Int {
        return mSLideViewPager.currentItem + i
    }
}