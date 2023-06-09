package com.example.painthings.art

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.painthings.databinding.ItemArtBinding
import com.example.painthings.network.WikiArtDetailResponse

class ArtAdapter : RecyclerView.Adapter<ArtAdapter.ArtViewHolder>() {

    private val list = ArrayList<WikiArtDetailResponse>()
    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    fun setList(res: ArrayList<WikiArtDetailResponse>) {
        list.clear()
        list.addAll(res)
        notifyDataSetChanged()
    }

    inner class ArtViewHolder(private val binding: ItemArtBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(art: WikiArtDetailResponse) {
            binding.root.setOnClickListener {
                onItemClickCallback?.onItemClick(art)
            }
            binding.apply {
                Glide.with(itemView).load(art.image)
                    .transition(DrawableTransitionOptions.withCrossFade()).into(ivPainting)
                tvArtArtist.text = art.artistName
                tvArtTitle.text = art.title
                tvArtYear.text = art.completitionYear.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtViewHolder {
        val view = ItemArtBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArtViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ArtViewHolder, position: Int) {
        holder.bind(list[position])
    }

    interface OnItemClickCallback {
        fun onItemClick(data: WikiArtDetailResponse)
    }
}