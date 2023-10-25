package com.bharath.bharath_instagramfollowingpage.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bharath.bharath_instagramfollowingpage.R
import com.bharath.bharath_instagramfollowingpage.data.PersonData
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import de.hdodenhof.circleimageview.CircleImageView

class ListRecylerViewAdapter(
    val context: Context,
    private val listener: RecyclerViewClickListener,
) : ListAdapter<PersonData, ListRecylerViewAdapter.ListRecyclerViewHolder>(ItemCallBackDiffUtil()) {

    inner class ListRecyclerViewHolder(itemView: View) : ViewHolder(itemView) {
        val image: CircleImageView = itemView.findViewById(R.id.ProfileImage)
        val handleName: TextView = itemView.findViewById(R.id.handleName)
        val userName: TextView = itemView.findViewById(R.id.userName)
        val followButton: Button = itemView.findViewById(R.id.followButton)
        fun bindIt(personData: PersonData) {
            Glide.with(context)
                .load(personData.personImage)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .dontAnimate()
                .into(image)

            handleName.text = personData.userName
            userName.text = personData.personName
            followButton.setOnClickListener {
                listener.onItemClick(personData)
            }
        }
    }

    private class ItemCallBackDiffUtil : ItemCallback<PersonData>() {
        override fun areItemsTheSame(oldItem: PersonData, newItem: PersonData): Boolean {
            return oldItem.id == newItem.id

        }

        override fun areContentsTheSame(oldItem: PersonData, newItem: PersonData): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListRecyclerViewHolder {
        return ListRecyclerViewHolder(
            LayoutInflater.from(context).inflate(R.layout.person_data_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ListRecyclerViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bindIt(currentItem)

    }

    interface RecyclerViewClickListener {
        fun onItemClick(personData: PersonData)
    }
}