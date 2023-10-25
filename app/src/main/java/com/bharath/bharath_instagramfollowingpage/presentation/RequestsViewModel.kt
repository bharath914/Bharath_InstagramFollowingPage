package com.bharath.bharath_instagramfollowingpage.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bharath.bharath_instagramfollowingpage.data.FollowingRequests
import com.bharath.bharath_instagramfollowingpage.data.database.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RequestsViewModel
@Inject constructor(private val repository: Repository) : ViewModel() {


    private val _followingRequests = MutableStateFlow(emptyList<FollowingRequests>())
    val followingRequests
        get() = _followingRequests.asStateFlow()

    init {
        getFollowingRequests()
    }

    private fun getFollowingRequests() {
        viewModelScope.launch(Dispatchers.IO) {

            repository.getAllFollowingRequests().collectLatest {
                _followingRequests.tryEmit(it)
            }
        }
    }

    private fun insertIntoFollowers(followingRequests: FollowingRequests) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertIntoFollowers(followingRequests.toFollowers())
        }
    }

    fun deleteFollowRequest(followingRequests: FollowingRequests) {
        insertIntoFollowers(followingRequests)
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteFollowRequests(followingRequests)
        }
    }

    fun insertToFollowingRequests(followingRequests: List<FollowingRequests>) {
        viewModelScope.launch(Dispatchers.IO) {

            followingRequests.forEach {

                repository.insertIntoFollowRequests(it)
            }
        }
    }
}