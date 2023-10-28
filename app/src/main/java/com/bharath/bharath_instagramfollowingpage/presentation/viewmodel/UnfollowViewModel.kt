package com.bharath.bharath_instagramfollowingpage.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bharath.bharath_instagramfollowingpage.data.Followers
import com.bharath.bharath_instagramfollowingpage.data.FollowingData
import com.bharath.bharath_instagramfollowingpage.data.database.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UnfollowViewModel @Inject constructor(
    private val repository: Repository,
) : ViewModel() {

    private val _following = MutableStateFlow(emptyList<FollowingData>())
    val following = _following.asStateFlow()

    private val _followers = MutableStateFlow(emptyList<Followers>())
    val followers = _followers.asStateFlow()


    fun getAllFollowing() {
        viewModelScope.launch(Dispatchers.IO) {

            repository.getAllFollowingPersons().collect {
                _following.tryEmit(it)
            }

        }

    }

    fun getAllFollowers() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllFollowers().collect {
                _followers.tryEmit(it)
            }
        }
    }

    fun removeFollower(followers: Followers) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertIntoFollowRequests(followingRequests = followers.toFollowRequests())
            repository.deleteFollowers(followers)
        }
    }

    fun unfollow(followingData: FollowingData) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insert(followingData.toPersonData(false))
            repository.deleteFollowing(followingData)
        }
    }

}