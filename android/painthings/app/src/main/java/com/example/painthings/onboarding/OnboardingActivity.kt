package com.example.painthings.onboarding

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
import com.example.painthings.ui.HomeActivity
import com.example.painthings.ui.auth.AuthActivity

class OnboardingActivity : AppCompatActivity() {
    private lateinit var mSLideViewPager: ViewPager
    private lateinit var mDotLayout: LinearLayout
    private lateinit var dots: Array<TextView?>
    private lateinit var viewPagerAdapter: ViewPagerAdapter
    private lateinit var nextbtn: Button
    private lateinit var skipbtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.onboarding_layout)
        nextbtn = findViewById(R.id.nextButton)
        skipbtn = findViewById(R.id.skipButton)

        val sharedPrefs = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        Log.d("SHARED PREFS IN ONBOARDING", sharedPrefs.getString("token", null).toString())
        val skipLogin: Boolean = sharedPrefs.getString("token", null) != null

        if (skipLogin) {
            val i = Intent(this@OnboardingActivity, HomeActivity::class.java)
            startActivity(i)
            finish()
        }

        nextbtn.setOnClickListener {
            if (getitem(0) < 2) mSLideViewPager.setCurrentItem(getitem(1), true)
            else {
                val i = Intent(this@OnboardingActivity, AuthActivity::class.java)
                startActivity(i)
                finish()
            }
        }
        skipbtn.setOnClickListener {
            Log.d("SKIP LOGIN", skipLogin.toString())
            if (skipLogin) {
                Log.d("SKIP LOGIN", "SKIPPING")
                val i = Intent(this@OnboardingActivity, HomeActivity::class.java)
                startActivity(i)
                finish()
            } else {
                val i = Intent(this@OnboardingActivity, AuthActivity::class.java)
                startActivity(i)
                finish()
            }

        }
        mSLideViewPager = findViewById<View>(R.id.viewPager) as ViewPager
        mDotLayout = findViewById<View>(R.id.pageIndicator) as LinearLayout
        viewPagerAdapter = ViewPagerAdapter(this)
        mSLideViewPager.adapter = viewPagerAdapter
        setUpindicator(0)
        mSLideViewPager.addOnPageChangeListener(viewListener)
    }

    fun setUpindicator(position: Int) {
        dots = arrayOfNulls(3)
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

    private fun getitem(i: Int): Int {
        return mSLideViewPager.currentItem + i
    }
}