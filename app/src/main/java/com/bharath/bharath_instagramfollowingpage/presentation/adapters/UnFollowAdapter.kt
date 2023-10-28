package com.bharath.bharath_instagramfollowingpage.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bharath.bharath_instagramfollowingpage.R
import com.bharath.bharath_instagramfollowingpage.data.FollowingData
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import de.hdodenhof.circleimageview.CircleImageView


class UnFollowAdapter(
    private val context: Context,

    val listener: UnfollowRecyclerViewClickListener,
) :
    ListAdapter<FollowingData, UnFollowAdapter.UnfollowRecyclerViewHolder>(ItemCallBackDiffUtil()) {

    inner class UnfollowRecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val image: CircleImageView = itemView.findViewById(R.id.ProfileImage)
        private val handleName: TextView = itemView.findViewById(R.id.handleName)
        private val userName: TextView = itemView.findViewById(R.id.userName)
        private val followButton: Button = itemView.findViewById(R.id.followButton)


        fun bindIt(followingData: FollowingData) {
            Glide.with(context)
                .load(followingData.personImage)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .dontAnimate()
                .into(image)

            handleName.text = followingData.userName
            userName.text = followingData.personName
            followButton.text = context.resources.getText((R.string.unfollow))
            followButton.setOnClickListener {
                listener.onItemClickToUnfollow(followingData)
            }
        }
    }

    private class ItemCallBackDiffUtil : DiffUtil.ItemCallback<FollowingData>() {
        override fun areItemsTheSame(
            oldItem: FollowingData,
            newItem: FollowingData,
        ): Boolean {
            return oldItem.id == newItem.id

        }

        override fun areContentsTheSame(
            oldItem: FollowingData,
            newItem: FollowingData,
        ): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UnfollowRecyclerViewHolder {
        return UnfollowRecyclerViewHolder(
            LayoutInflater.from(context).inflate(R.layout.person_data_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: UnfollowRecyclerViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bindIt(currentItem)

    }

    interface UnfollowRecyclerViewClickListener {
        fun onItemClickToUnfollow(following: FollowingData)
    }
}