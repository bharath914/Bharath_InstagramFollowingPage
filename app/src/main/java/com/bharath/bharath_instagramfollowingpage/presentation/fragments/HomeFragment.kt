package com.bharath.bharath_instagramfollowingpage.presentation.fragments

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.HORIZONTAL
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.bharath.bharath_instagramfollowingpage.R
import com.bharath.bharath_instagramfollowingpage.data.FakePersonsData
import com.bharath.bharath_instagramfollowingpage.data.PersonData
import com.bharath.bharath_instagramfollowingpage.data.database.HighLightsData
import com.bharath.bharath_instagramfollowingpage.presentation.viewmodel.HomeViewModel
import com.bharath.bharath_instagramfollowingpage.presentation.adapters.GridRecyclerViewAdap
import com.bharath.bharath_instagramfollowingpage.presentation.adapters.HighLightsAdapter
import com.bharath.bharath_instagramfollowingpage.presentation.adapters.ListRecylerViewAdapter
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@AndroidEntryPoint // tells dagger hilt to inject something here
class HomeFragment : Fragment(), ListRecylerViewAdapter.RecyclerViewClickListener,
    GridRecyclerViewAdap.RecyclerViewClickListenerGrid {


    private val viewModel by viewModels<HomeViewModel>()

    private lateinit var profileImage: CircleImageView

    private lateinit var recycler: RecyclerView
    private lateinit var adapter: ListRecylerViewAdapter
    private lateinit var imageButton: ImageView
    private lateinit var fakeData: FakePersonsData
    private lateinit var gridAdapter: GridRecyclerViewAdap
    private lateinit var list: List<PersonData>
    private lateinit var highLightsList: List<HighLightsData>
    private lateinit var followersCount: TextView

    private lateinit var highLightsAdapter: HighLightsAdapter
    private lateinit var suggestionList: List<PersonData>
    private var isList = true
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: Editor
    private lateinit var followingCount: TextView

    private lateinit var requestsButton: TextView
    private lateinit var horizontalRecycler: RecyclerView


    private lateinit var followers: LinearLayout
    private lateinit var following: LinearLayout


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_home, container, false)
        fakeData = FakePersonsData()
        recycler = v.findViewById(R.id.recyclerViewHome)
        imageButton = v.findViewById(R.id.LayoutChangerButton)
        requestsButton = v.findViewById(R.id.requests)
        followingCount = v.findViewById(R.id.FollowingCount)
        followersCount = v.findViewById(R.id.followersCount)
        horizontalRecycler = v.findViewById(R.id.storyHighlightsRecycler)
        adapter = ListRecylerViewAdapter(requireContext(), this)
        gridAdapter = GridRecyclerViewAdap(requireContext(), this)
        highLightsAdapter = HighLightsAdapter(requireContext())
        followersCount = v.findViewById(R.id.followersCount)
        profileImage = v.findViewById(R.id.profileImageHome)
        following = v.findViewById(R.id.FollowingLayout)
        followers = v.findViewById(R.id.followersLayout)

        sharedPreferences = requireActivity().getSharedPreferences("sf", MODE_PRIVATE)
        editor = sharedPreferences.edit()
        list = fakeData.generateFakeDataSuggestions()
        highLightsList = fakeData.generateFakeHighlights()
        horizontalRecycler.layoutManager =
            GridLayoutManager(requireContext(), VERTICAL, HORIZONTAL, false)
        horizontalRecycler.adapter = highLightsAdapter
        highLightsAdapter.submitList(highLightsList)


        val isf = sharedPreferences.getBoolean("isFirstTime", true)
        if (isf) {
            insertToDb()


        }
        viewModel.viewModelScope.launch {
            viewModel.suggestionList.collect {
                suggestionList = it
                adapter.submitList(it)
                gridAdapter.submitList(it)
            }
        }


        Glide.with(requireContext())
            .load("https://www.channelnews.com.au/wp-content/uploads/2021/05/bezos.jpg")
            .into(profileImage)

        setRecyler()
        setUpObservers()
        onClickListeners()

        return v


    }

    private fun insertToDb() {

        viewModel.viewModelScope.launch(Dispatchers.IO) {
            for (i in list) {
                viewModel.insertToDb(i)

            }
        }
        editor.putBoolean("isFirstTime", false)
        editor.apply()
        viewModel.getSuggestionsList()
    }

    private fun setUpObservers() {
        viewModel.viewModelScope.launch {

            viewModel.followingCount.collect {

                followingCount.text = it.toString()

            }

        }
        viewModel.viewModelScope.launch {
            viewModel.followersCount.collect {
                followersCount.text = it.toString()
            }
        }
    }

    private fun setRecyler() {


        recycler.layoutManager = LinearLayoutManager(context)
        recycler.adapter = adapter
        adapter.submitList(suggestionList)
    }

    private fun setGridRecyler() {
        recycler.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        recycler.adapter = gridAdapter
        gridAdapter.submitList(suggestionList)
    }

    private fun onClickListeners() {
        imageButton.setOnClickListener {
            if (isList) {
                imageButton.setImageResource(R.drawable.gridview)
                setGridRecyler()

            } else {
                imageButton.setImageResource(R.drawable.listview)
                setRecyler()
            }
            isList = !isList
        }
        requestsButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_requestsFragment)
        }

        followers.setOnClickListener {
            val bundle = Bundle()
            bundle.putInt("Mode", 0)
            navigateToUnfollowPage(bundle)
        }
        following.setOnClickListener {
            val bundle = Bundle()
            bundle.putInt("Mode", 1)
            navigateToUnfollowPage(bundle)
        }


    }

    fun navigateToUnfollowPage(
        bundle: Bundle,
    ) {
        findNavController().navigate(R.id.action_homeFragment_to_unfollowPage, args = bundle)
    }

    override fun onItemClick(personData: PersonData) {

        viewModel.insertToFollowingDb(personData)

    }

}