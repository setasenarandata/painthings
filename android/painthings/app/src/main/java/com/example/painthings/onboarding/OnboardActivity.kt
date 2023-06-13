package com.example.painthings.onboarding

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.example.painthings.R
import com.example.painthings.ui.HomeActivity
import com.example.painthings.ui.auth.AuthActivity
import com.example.painthings.view_model.LoginViewModel
import io.github.muddz.styleabletoast.StyleableToast

class OnboardActivity : AppCompatActivity() {
    private lateinit var mSLideViewPager: ViewPager
    private lateinit var mDotLayout: LinearLayout
    private lateinit var dots: Array<TextView?>
    private lateinit var viewPagerAdapter: ViewPagerAdapter
    private lateinit var nextButton: Button
    private lateinit var skipButton: Button
    private lateinit var viewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.onboarding_layout)
        nextButton = findViewById(R.id.nextButton)
        skipButton = findViewById(R.id.skipButton)

        val sharedPrefs = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val cookie = sharedPrefs.getString("cookies", null)
        val name = sharedPrefs.getString("name", null)

        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[LoginViewModel::class.java]

        viewModel.getLoginStatus().observe(this@OnboardActivity) {
            if (it.name == name) {
                val i = Intent(this@OnboardActivity, HomeActivity::class.java)
                startActivity(i)
                finish()
            } else {
                StyleableToast.makeText(this, "Please login again", Toast.LENGTH_LONG, R.style.mytoast).show()
            }
        }

        if (cookie != null) getMe(cookie)
        else getMe("dummyCookie")

        nextButton.setOnClickListener {
            if (getItem(0) < 2) mSLideViewPager.setCurrentItem(getItem(1), true)
            else {
                val i = Intent(this@OnboardActivity, AuthActivity::class.java)
                startActivity(i)
                finish()
            }
        }
        skipButton.setOnClickListener {
            val i = Intent(this@OnboardActivity, AuthActivity::class.java)
            startActivity(i)
            finish()
        }
        mSLideViewPager = findViewById<View>(R.id.viewPager) as ViewPager
        mDotLayout = findViewById<View>(R.id.pageIndicator) as LinearLayout
        viewPagerAdapter = ViewPagerAdapter(this)
        mSLideViewPager.adapter = viewPagerAdapter
        setupIndicator(0)
        mSLideViewPager.addOnPageChangeListener(viewListener)
    }

    fun setupIndicator(position: Int) {
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
            setupIndicator(position)
        }

        override fun onPageScrollStateChanged(state: Int) {}
    }

    private fun getItem(i: Int): Int {
        return mSLideViewPager.currentItem + i
    }

    private fun getMe(cookie: String) {
        viewModel.getMe(cookie)
    }
}