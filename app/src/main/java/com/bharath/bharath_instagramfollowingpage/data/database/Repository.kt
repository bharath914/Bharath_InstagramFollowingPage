package com.bharath.bharath_instagramfollowingpage.data.database

import com.bharath.bharath_instagramfollowingpage.data.Followers
import com.bharath.bharath_instagramfollowingpage.data.FollowingData
import com.bharath.bharath_instagramfollowingpage.data.FollowingRequests
import com.bharath.bharath_instagramfollowingpage.data.PersonData
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


interface Repository {
    suspend fun insert(personData: PersonData)
    suspend fun getFollowingCount(): Flow<Int>
    suspend fun getAllSuggestions(): Flow<List<PersonData>>
    suspend fun insertToFollowing(followingData: FollowingData)
    suspend fun update(personData: PersonData)
    suspend fun delete(personData: PersonData)

    suspend fun insertIntoFollowRequests(followingRequests: FollowingRequests)
    suspend fun insertIntoFollowers(followers: Followers)
    suspend fun deleteFollowRequests(followingRequests: FollowingRequests)
    suspend fun getAllFollowersCount(): Flow<Int>
    suspend fun getAllFollowingRequests(): Flow<List<FollowingRequests>>
}

class RepositoryImpl @Inject constructor(
    private val dao: MyDao,
) : Repository {
    override suspend fun insert(personData: PersonData) {
        dao.insert(personData)
    }

    override suspend fun getFollowingCount(): Flow<Int> {
        return dao.getFollowingCount()
    }

    override suspend fun getAllSuggestions(): Flow<List<PersonData>> {
        return dao.getAllSuggestions()
    }

    override suspend fun insertToFollowing(followingData: FollowingData) {
        return dao.insertToFollowing(followingData)
    }

    override suspend fun update(personData: PersonData) {
        dao.update(personData)
    }

    override suspend fun delete(personData: PersonData) {
        dao.delete(personData)
    }

    override suspend fun insertIntoFollowRequests(followingRequests: FollowingRequests) {
        dao.insertIntoFollowRequests(followingRequests)
    }

    override suspend fun insertIntoFollowers(followers: Followers) {
        dao.insertIntoFollowers(followers)
    }

    override suspend fun deleteFollowRequests(followingRequests: FollowingRequests) {
        dao.deleteFollowRequests(followingRequests)
    }

    override suspend fun getAllFollowersCount(): Flow<Int> {
        return dao.getAllFollowersCount()
    }

    override suspend fun getAllFollowingRequests(): Flow<List<FollowingRequests>> {
        return dao.getAllFollowingRequests()
    }


}