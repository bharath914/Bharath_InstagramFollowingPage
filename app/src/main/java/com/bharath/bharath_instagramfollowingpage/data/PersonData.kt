package com.bharath.bharath_instagramfollowingpage.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


/*
These are essential data classes to store the information correctly in the table
@Entity = Entity / table name
@Primary Key = basically the identifier of the table

 */

@Entity(
    tableName = "PersonData"
)
data class PersonData(
    @PrimaryKey @ColumnInfo("id") val id: Int,
    @ColumnInfo("personName") val personName: String,
    @ColumnInfo("personImage") val personImage: String,
    @ColumnInfo("UserName") val userName: String,
    @ColumnInfo("isFollowing") val isFollowing: Boolean = false,

    ) {


    /*
    This is an extensive function
    to convert one data class to another dataclass
    here PersonData  ---> Following Data
     */

    fun toFollowingData(): FollowingData {
        return FollowingData(
            id, personName, personImage, userName, isFollowing
        )
    }
}

@Entity(
    tableName = "FollowingPersons"
)
data class FollowingData(
    @PrimaryKey @ColumnInfo("fid") val id: Int,
    @ColumnInfo("fpersonName") val personName: String,
    @ColumnInfo("fpersonImage") val personImage: String,
    @ColumnInfo("fUserName") val userName: String,
    @ColumnInfo("fisFollowing") val isFollowing: Boolean = true,
) {

    fun toPersonData(following: Boolean): PersonData {
        return PersonData(
            id, personName, personImage, userName, following
        )
    }
}


@Entity(
    tableName = "FollowingRequests"
)
data class FollowingRequests(
    @PrimaryKey @ColumnInfo("fid") val id: Int,
    @ColumnInfo("fpersonName") val personName: String,
    @ColumnInfo("fpersonImage") val personImage: String,
    @ColumnInfo("fUserName") val userName: String,

    ) {

    fun toFollowers(): Followers {
        return Followers(
            id, personName, personImage, userName
        )
    }

}

@Entity(
    tableName = "FollowersTable"
)
data class Followers(
    @PrimaryKey @ColumnInfo("fid") val id: Int,
    @ColumnInfo("fpersonName") val personName: String,
    @ColumnInfo("fpersonImage") val personImage: String,
    @ColumnInfo("fUserName") val userName: String,

    ) {

    fun toFollowRequests(): FollowingRequests {
        return FollowingRequests(
            id, personName, personImage, userName
        )
    }
}



