package com.bharath.bharath_instagramfollowingpage.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bharath.bharath_instagramfollowingpage.R
import com.bharath.bharath_instagramfollowingpage.data.database.HighLightsData
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import de.hdodenhof.circleimageview.CircleImageView

class HighLightsAdapter(
    private val context: Context,
) :
    ListAdapter<HighLightsData, HighLightsAdapter.HighlightsViewHolder>(ItemDiffUtilCallBack()) {
    inner class HighlightsViewHolder(itemview: View) : ViewHolder(itemview) {
        val image = itemview.findViewById<CircleImageView>(R.id.highlightImage)
        val name = itemview.findViewById<TextView>(R.id.storyHighlightName)

        fun bindIt(highLightsData: HighLightsData) {
            Glide.with(context)
                .load(highLightsData.image)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(image)

            name.text = highLightsData.name
        }

    }

    private class ItemDiffUtilCallBack : DiffUtil.ItemCallback<HighLightsData>() {
        override fun areItemsTheSame(oldItem: HighLightsData, newItem: HighLightsData): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: HighLightsData, newItem: HighLightsData): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HighlightsViewHolder {
        return HighlightsViewHolder(
            LayoutInflater.from(context).inflate(R.layout.story_highlight, parent, false)

        )
    }

    override fun onBindViewHolder(holder: HighlightsViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bindIt(currentItem)

    }
}