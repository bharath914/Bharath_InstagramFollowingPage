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
import com.bharath.bharath_instagramfollowingpage.data.FollowingRequests
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import de.hdodenhof.circleimageview.CircleImageView


class RequestsAdapter(
    val context: Context,
    private val listener: ReqRecyclerViewClickListener,
) : ListAdapter<FollowingRequests, RequestsAdapter.RequestsRecyclerViewHolder>(ItemCallBackDiffUtil()) {

    inner class RequestsRecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: CircleImageView = itemView.findViewById(R.id.ProfileImage)
        val handleName: TextView = itemView.findViewById(R.id.handleName)
        val userName: TextView = itemView.findViewById(R.id.userName)
        val followButton: Button = itemView.findViewById(R.id.followButton)


        fun bindIt(followingRequests: FollowingRequests) {
            Glide.with(context)
                .load(followingRequests.personImage)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .dontAnimate()
                .into(image)

            handleName.text = followingRequests.userName
            userName.text = followingRequests.personName
            followButton.text = context.resources.getText((R.string.accept))
            followButton.setOnClickListener {
                listener.onItemClick(followingRequests)
            }
        }
    }

    private class ItemCallBackDiffUtil : DiffUtil.ItemCallback<FollowingRequests>() {
        override fun areItemsTheSame(
            oldItem: FollowingRequests,
            newItem: FollowingRequests,
        ): Boolean {
            return oldItem.id == newItem.id

        }

        override fun areContentsTheSame(
            oldItem: FollowingRequests,
            newItem: FollowingRequests,
        ): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RequestsRecyclerViewHolder {
        return RequestsRecyclerViewHolder(
            LayoutInflater.from(context).inflate(R.layout.person_data_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RequestsRecyclerViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bindIt(currentItem)

    }

    interface ReqRecyclerViewClickListener {
        fun onItemClick(followingRequests: FollowingRequests)
    }
}