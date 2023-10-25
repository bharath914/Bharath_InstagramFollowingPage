package com.bharath.bharath_instagramfollowingpage.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bharath.bharath_instagramfollowingpage.data.Followers
import com.bharath.bharath_instagramfollowingpage.data.FollowingData
import com.bharath.bharath_instagramfollowingpage.data.FollowingRequests
import com.bharath.bharath_instagramfollowingpage.data.PersonData

@Database(
    entities = [PersonData::class, FollowingData::class, Followers::class, FollowingRequests::class],
    version = 1
)
abstract class MyDataBase : RoomDatabase() {
    abstract val dao: MyDao
}