package com.bharath.bharath_instagramfollowingpage.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.bharath.bharath_instagramfollowingpage.data.Followers
import com.bharath.bharath_instagramfollowingpage.data.FollowingData
import com.bharath.bharath_instagramfollowingpage.data.FollowingRequests
import com.bharath.bharath_instagramfollowingpage.data.PersonData
import kotlinx.coroutines.flow.Flow

@Dao
interface MyDao {

    /*
    Insert Functions
     */
    @Insert(entity = PersonData::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(personData: PersonData)

    @Insert(entity = FollowingData::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertToFollowing(followingData: FollowingData)

    @Insert(entity = FollowingRequests::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertIntoFollowRequests(followingRequests: FollowingRequests)

    @Insert(entity = Followers::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertIntoFollowers(followers: Followers)


    /*
    delete / update
     */


    @Update(entity = PersonData::class)
    suspend fun update(personData: PersonData)

    @Delete(entity = PersonData::class)
    suspend fun delete(personData: PersonData)

    @Delete(entity = FollowingRequests::class)
    suspend fun deleteFollowRequests(followingRequests: FollowingRequests)

    @Delete(entity = Followers::class)
    suspend fun deleteFollower(followers: Followers)

    @Delete(entity = FollowingData::class)
    suspend fun deleteFollowingPerson(followingData: FollowingData)

    /*
    required queries
     */
    @Query("SELECT COUNT(*) FROM FollowingPersons")
    fun getFollowingCount(): Flow<Int>


    @Query("SELECT * FROM PersonData")
    fun getAllSuggestions(): Flow<List<PersonData>>

    @Query("SELECT * FROM  FollowingRequests")
    fun getAllFollowingRequests(): Flow<List<FollowingRequests>>


    @Query("SELECT COUNT(*) FROM FollowersTable")
    fun getAllFollowersCount(): Flow<Int>

    @Query("SELECT * FROM FollowersTable")
    fun getAllFollowers(): Flow<List<Followers>>

    @Query("SELECT * FROM FollowingPersons")
    fun getFollowingPersons(): Flow<List<FollowingData>>

}