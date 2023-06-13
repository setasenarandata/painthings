package com.example.painthings.onboarding

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.util.Log
import android.view.View
import android.webkit.CookieManager
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.example.painthings.R
import com.example.painthings.network.LoginBody
import com.example.painthings.ui.HomeActivity
import com.example.painthings.ui.auth.AuthActivity
import com.example.painthings.view_model.LoginViewModel

class OnboardingActivity : AppCompatActivity() {
    private lateinit var mSLideViewPager: ViewPager
    private lateinit var mDotLayout: LinearLayout
    private lateinit var dots: Array<TextView?>
    private lateinit var viewPagerAdapter: ViewPagerAdapter
    private lateinit var nextbtn: Button
    private lateinit var skipbtn: Button
    private lateinit var viewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.onboarding_layout)
        nextbtn = findViewById(R.id.nextButton)
        skipbtn = findViewById(R.id.skipButton)

        val sharedPrefs = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val cookie = sharedPrefs.getString("cookies", null)
        val name = sharedPrefs.getString("name", null)

        Log.d("COOKIESCOY", cookie.toString())

        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[LoginViewModel::class.java]

        viewModel.getLoginStatus().observe(this@OnboardingActivity) {
            if (it.name == name) {
                val i = Intent(this@OnboardingActivity, HomeActivity::class.java)
                startActivity(i)
                finish()
            } else {
                Toast.makeText(this@OnboardingActivity, "Please login again", Toast.LENGTH_LONG).show()
            }
        }

        if (cookie != null) getMe(cookie)
        else getMe("dummyCookie")

        nextbtn.setOnClickListener {
            if (getitem(0) < 2) mSLideViewPager.setCurrentItem(getitem(1), true)
            else {
                val i = Intent(this@OnboardingActivity, AuthActivity::class.java)
                startActivity(i)
                finish()
            }
        }
        skipbtn.setOnClickListener {
            val i = Intent(this@OnboardingActivity, AuthActivity::class.java)
            startActivity(i)
            finish()
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

    private fun getMe(cookie: String) {
        viewModel.getMe(cookie)
    }
}