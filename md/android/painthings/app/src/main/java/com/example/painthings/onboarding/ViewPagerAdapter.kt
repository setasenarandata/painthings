package com.example.painthings.onboarding


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.example.painthings.R

class ViewPagerAdapter(private var context: Context) : PagerAdapter() {
    private var images = intArrayOf(
        R.drawable.image_welcome_1,
        R.drawable.image_welcome_2,
        R.drawable.image_welcome_3
    )
    private var headings = intArrayOf(
        R.string.welcome_1_heading,
        R.string.welcome_2_heading,
        R.string.welcome_3_heading,
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
        val view: View = layoutInflater.inflate(R.layout.activity_onboarding, container, false)
        val slideTitleImage = view.findViewById<View>(R.id.headingImageOnboarding) as ImageView
        val slideHeading = view.findViewById<View>(R.id.headingOnboarding) as TextView
        slideTitleImage.setImageResource(images[position])
        slideHeading.setText(headings[position])
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as LinearLayout)
    }
}