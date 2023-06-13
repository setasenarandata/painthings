package com.example.painthings.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.painthings.R
import com.example.painthings.databinding.ItemDateListBinding
import com.example.painthings.model.HomeDate
import java.util.*

class HomeDateAdapter(private val dateList: List<HomeDate>, private val dateItemClickListener: DateItemClickListener) :
    RecyclerView.Adapter<HomeDateAdapter.ViewHolder>() {

//    private var dateItemClickListener: DateItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = ItemDateListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return dateList.count()
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(dateList, position)
        holder.itemView.setOnClickListener {
            for (i in dateList.indices) {
                dateList[i].isClicked = false
            }
            dateList[position].isClicked = !dateList[position].isClicked
            dateItemClickListener.onDateItemClicked(dateList[position].cal!!.time)
            // Make api call
            notifyDataSetChanged()
        }
    }

    class ViewHolder(private val itemBinding: ItemDateListBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun setData(dateList: List<HomeDate>, position: Int) {

            if (dateList[position].isClicked) {
                itemBinding.tvDate.setTextColor(Color.WHITE)
                itemBinding.layoutDate.background = ContextCompat.getDrawable(
                    itemBinding.root.context,
                    R.drawable.background_rounded
                )
                itemBinding.tvDay.visibility = View.VISIBLE
            } else {
                itemBinding.tvDate.setTextColor(
                    ContextCompat.getColor(
                        itemBinding.root.context,
                        R.color.dateBtnColor
                    )
                )
                itemBinding.layoutDate.setBackgroundColor(Color.TRANSPARENT)
                itemBinding.tvDay.visibility = View.GONE
            }


            val dayOfWeekInMonth: Int = dateList[position].cal?.get(Calendar.DAY_OF_WEEK)!!
            var dayOfWeekInMonthStr = ""
            when (dayOfWeekInMonth - 1) {
                1 -> dayOfWeekInMonthStr = " , Monday"
                2 -> dayOfWeekInMonthStr = " , Tuesday"
                3 -> dayOfWeekInMonthStr = " , Wednesday"
                4 -> dayOfWeekInMonthStr = " , Thursday"
                5 -> dayOfWeekInMonthStr = " , Friday"
                6 -> dayOfWeekInMonthStr = " , Saturday"
                0 -> dayOfWeekInMonthStr = " , Sunday"
            }

            itemBinding.apply {
                tvDate.text = dateList[position].cal?.get(Calendar.DATE).toString()
                tvDay.text = dayOfWeekInMonthStr
            }
        }
    }

    interface DateItemClickListener {
        fun onDateItemClicked(date: Date)
    }
}