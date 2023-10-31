package com.bharath.bharath_instagramfollowingpage.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bharath.bharath_instagramfollowingpage.data.PersonData
import com.bharath.bharath_instagramfollowingpage.data.database.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel // creates an instance of viewmodel through the lifecycle of viewmodel

/*
Here we are injecting the repository for our database operations.
but in the clean architecture we need to create an use-case class to access it.

 */
class HomeViewModel @Inject constructor(
    private val repository: Repository,
) : ViewModel() {

    private val _followingCount = MutableStateFlow(0)
    val followingCount = _followingCount.asStateFlow()

    // Stateflows are similar to livedata but the dataflow will be in states
    // The data will be collected only when the data is changed as it is flowed in states
    private val _followersCount = MutableStateFlow(0)
    val followersCount = _followersCount.asStateFlow()
    private val _suggestionList = MutableStateFlow(emptyList<PersonData>())
    val suggestionList = _suggestionList.asStateFlow()

    init {
        getSuggestionsList()
        getFollowingCount()
        getFollowrsList()
    }

    fun getSuggestionsList() {
        /*
        we are getting the list using IO thread for smooth experience
        as if we use main block it causes blocking of ui elements
         */
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllSuggestions().collect { list ->
                _suggestionList.tryEmit(
                    list
                )
                Log.d("SuggestionList", "getSuggestionsList: Getting.............sti ")
            }
        }
    }

    fun getFollowrsList() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllFollowersCount().collect {
                _followersCount.tryEmit(it)
            }
        }
    }

    fun getFollowingCount() {
        viewModelScope.launch(Dispatchers.IO) {

            repository.getFollowingCount().collect {
                _followingCount.tryEmit(it)
            }
        }
    }

    fun insertToDb(item: PersonData) {
        viewModelScope.launch(Dispatchers.Default) {
            repository.insert(item)
        }
    }

    fun insertToFollowingDb(item: PersonData) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertToFollowing(item.toFollowingData())
            repository.delete(personData = item)
        }
        getFollowingCount()
    }
}