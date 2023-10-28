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
import com.bharath.bharath_instagramfollowingpage.data.Followers
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import de.hdodenhof.circleimageview.CircleImageView

class RemoveFollowersAdapter(
    private val context: Context,

    val listener: RemoveRecyclerViewClickListener,
) :
    ListAdapter<Followers, RemoveFollowersAdapter.RemoveFollowrsRecyclerViewHolder>(
        ItemCallBackDiffUtil()
    ) {

    inner class RemoveFollowrsRecyclerViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        private val image: CircleImageView = itemView.findViewById(R.id.ProfileImage)
        private val handleName: TextView = itemView.findViewById(R.id.handleName)
        private val userName: TextView = itemView.findViewById(R.id.userName)
        private val followButton: Button = itemView.findViewById(R.id.followButton)


        fun bindIt(followers: Followers) {
            Glide.with(context)
                .load(followers.personImage)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .dontAnimate()
                .into(image)

            handleName.text = followers.userName
            userName.text = followers.personName
            followButton.text = context.resources.getText((R.string.remove))

            followButton.setOnClickListener {
                listener.onItemClickToRemoveFollower(followers)
            }
        }
    }

    private class ItemCallBackDiffUtil : DiffUtil.ItemCallback<Followers>() {
        override fun areItemsTheSame(
            oldItem: Followers,
            newItem: Followers,
        ): Boolean {
            return oldItem.id == newItem.id

        }

        override fun areContentsTheSame(
            oldItem: Followers,
            newItem: Followers,
        ): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): RemoveFollowrsRecyclerViewHolder {
        return RemoveFollowrsRecyclerViewHolder(
            LayoutInflater.from(context).inflate(R.layout.person_data_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RemoveFollowrsRecyclerViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bindIt(currentItem)

    }

    interface RemoveRecyclerViewClickListener {
        fun onItemClickToRemoveFollower(follwers: Followers)
    }
}