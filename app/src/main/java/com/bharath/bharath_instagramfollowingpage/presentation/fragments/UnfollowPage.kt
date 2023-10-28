package com.bharath.bharath_instagramfollowingpage.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bharath.bharath_instagramfollowingpage.R
import com.bharath.bharath_instagramfollowingpage.data.Followers
import com.bharath.bharath_instagramfollowingpage.data.FollowingData
import com.bharath.bharath_instagramfollowingpage.presentation.viewmodel.UnfollowViewModel
import com.bharath.bharath_instagramfollowingpage.presentation.adapters.RemoveFollowersAdapter
import com.bharath.bharath_instagramfollowingpage.presentation.adapters.UnFollowAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class UnfollowPage : Fragment(), UnFollowAdapter.UnfollowRecyclerViewClickListener,
    RemoveFollowersAdapter.RemoveRecyclerViewClickListener {

    private val viewmodel by viewModels<UnfollowViewModel>()
    private lateinit var recyclerview: RecyclerView
    private lateinit var backButton: ImageView
    private lateinit var unfollowAdapter: UnFollowAdapter
    private lateinit var removeFollowersAdapter: RemoveFollowersAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_unfollow_page, container, false)
        val mode = requireArguments().getInt("Mode")
        recyclerview = v.findViewById(R.id.unfollow_recyclerView)
        backButton = v.findViewById(R.id.unfollow_backButton)
        recyclerview.layoutManager = LinearLayoutManager(requireContext())

        setUpRecyclerView(mode)
        onClickObjects()


        return v
    }


    private fun setUpRecyclerView(mode: Int) {
        if (mode == 0) {
            removeFollowersAdapter = RemoveFollowersAdapter(
                requireContext(),

                this

            )
            recyclerview.adapter = removeFollowersAdapter
            viewmodel.getAllFollowers()
            viewmodel.viewModelScope.launch {
                viewmodel.followers.collect { list ->
                    removeFollowersAdapter.submitList(list)
                }
            }

        } else {
            unfollowAdapter = UnFollowAdapter(
                requireContext(),

                this
            )
            recyclerview.adapter = unfollowAdapter
            viewmodel.getAllFollowing()
            viewmodel.viewModelScope.launch {
                viewmodel.following.collect { list ->
                    unfollowAdapter.submitList(list)
                }
            }
        }
    }

    private fun onClickObjects() {
        backButton.setOnClickListener {
            findNavController()
                .navigateUp()
        }
    }

    override fun onItemClickToUnfollow(following: FollowingData) {
        viewmodel.unfollow(following)
    }

    override fun onItemClickToRemoveFollower(follwers: Followers) {
        viewmodel.removeFollower(follwers)
    }


}