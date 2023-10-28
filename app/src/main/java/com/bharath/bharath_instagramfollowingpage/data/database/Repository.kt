package com.bharath.bharath_instagramfollowingpage.data.database

import com.bharath.bharath_instagramfollowingpage.data.Followers
import com.bharath.bharath_instagramfollowingpage.data.FollowingData
import com.bharath.bharath_instagramfollowingpage.data.FollowingRequests
import com.bharath.bharath_instagramfollowingpage.data.PersonData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject


interface Repository {
    suspend fun insert(personData: PersonData)
    suspend fun getFollowingCount(): Flow<Int>
    suspend fun getAllSuggestions(): Flow<List<PersonData>>
    suspend fun insertToFollowing(followingData: FollowingData)
    suspend fun update(personData: PersonData)
    suspend fun delete(personData: PersonData)

    suspend fun deleteFollowers(followers: Followers)
    suspend fun deleteFollowing(followingData: FollowingData)

    suspend fun insertIntoFollowRequests(followingRequests: FollowingRequests)
    suspend fun insertIntoFollowers(followers: Followers)
    suspend fun deleteFollowRequests(followingRequests: FollowingRequests)
    suspend fun getAllFollowersCount(): Flow<Int>
    suspend fun getAllFollowingRequests(): Flow<List<FollowingRequests>>


    suspend fun getAllFollowers(): Flow<List<Followers>>
    suspend fun getAllFollowingPersons(): Flow<List<FollowingData>>
}

class RepositoryImpl @Inject constructor(
    private val dao: MyDao,
) : Repository {
    override suspend fun insert(personData: PersonData) {
        dao.insert(personData)
    }

    override suspend fun getFollowingCount(): Flow<Int> {
        return withContext(Dispatchers.IO) {
            dao.getFollowingCount()
        }
    }

    override suspend fun getAllSuggestions(): Flow<List<PersonData>> {
        return withContext(Dispatchers.IO) {
            dao.getAllSuggestions()
        }
    }

    override suspend fun insertToFollowing(followingData: FollowingData) {
        withContext(Dispatchers.IO) {
            dao.insertToFollowing(followingData)
        }
    }

    override suspend fun update(personData: PersonData) {
        withContext(Dispatchers.IO) {
            dao.update(personData)
        }
    }

    override suspend fun delete(personData: PersonData) {
        dao.delete(personData)
    }

    override suspend fun deleteFollowers(followers: Followers) {
        withContext(Dispatchers.IO) {
            dao.deleteFollower(followers)
        }
    }

    override suspend fun deleteFollowing(followingData: FollowingData) {
        withContext(Dispatchers.IO) {
            dao.deleteFollowingPerson(followingData)
        }
    }

    override suspend fun insertIntoFollowRequests(followingRequests: FollowingRequests) {
        withContext(Dispatchers.IO) {
            dao.insertIntoFollowRequests(followingRequests)
        }
    }

    override suspend fun insertIntoFollowers(followers: Followers) {
        withContext(Dispatchers.IO) {
            dao.insertIntoFollowers(followers)
        }
    }

    override suspend fun deleteFollowRequests(followingRequests: FollowingRequests) {
        withContext(Dispatchers.IO) {
            dao.deleteFollowRequests(followingRequests)
        }
    }

    override suspend fun getAllFollowersCount(): Flow<Int> {
        return withContext(Dispatchers.IO) {
            dao.getAllFollowersCount()
        }
    }

    override suspend fun getAllFollowingRequests(): Flow<List<FollowingRequests>> {
        return withContext(Dispatchers.IO) {
            dao.getAllFollowingRequests()
        }
    }

    override suspend fun getAllFollowers(): Flow<List<Followers>> {
        return withContext(Dispatchers.IO) {

            dao.getAllFollowers()
        }
    }

    override suspend fun getAllFollowingPersons(): Flow<List<FollowingData>> {
        return withContext(Dispatchers.IO) {
            dao.getFollowingPersons()
        }
    }


}