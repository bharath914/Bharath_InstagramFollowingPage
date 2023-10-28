package com.bharath.bharath_instagramfollowingpage.presentation.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bharath.bharath_instagramfollowingpage.R
import com.bharath.bharath_instagramfollowingpage.data.FakePersonsData
import com.bharath.bharath_instagramfollowingpage.data.FollowingRequests
import com.bharath.bharath_instagramfollowingpage.presentation.viewmodel.RequestsViewModel
import com.bharath.bharath_instagramfollowingpage.presentation.adapters.RequestsAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class RequestsFragment : Fragment(), RequestsAdapter.ReqRecyclerViewClickListener {

    lateinit var recyclerview: RecyclerView
    lateinit var acceptButton: Button
    lateinit var adap: RequestsAdapter
    lateinit var sharedPreferences: SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    private val viewModel by viewModels<RequestsViewModel>()
    lateinit var fakePersonsData: FakePersonsData
    lateinit var list: List<FollowingRequests>
    lateinit var backButton: ImageView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        val v = inflater.inflate(R.layout.fragment_requests, container, false)
        recyclerview = v.findViewById(R.id.rq_recyclerView)
        backButton = v.findViewById(R.id.backButton)
        onClicks()
        adap = RequestsAdapter(requireContext(), this)
        sharedPreferences = requireActivity().getSharedPreferences("sf", Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()
        val isf = sharedPreferences.getBoolean("isFirstTimeReq", true)
        if (isf) {
            fakePersonsData = FakePersonsData()
            list = fakePersonsData.generateFakeDataFollowRequests()
            insertToDb()


        }

        recyclerview.layoutManager = LinearLayoutManager(requireContext())
        recyclerview.adapter = adap
        viewModel.viewModelScope.launch {

            viewModel.followingRequests.collect { reqList ->
                adap.submitList(reqList)

            }

        }


        return v
    }

    override fun onItemClick(followingRequests: FollowingRequests) {
        viewModel.deleteFollowRequest(followingRequests)
    }

    private fun onClicks() {
        backButton.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun insertToDb() {

        viewModel.insertToFollowingRequests(list)

        editor.putBoolean("isFirstTimeReq", false)
        editor.apply()
    }


}