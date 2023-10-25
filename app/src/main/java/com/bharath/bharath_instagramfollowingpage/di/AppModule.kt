package com.bharath.bharath_instagramfollowingpage.di

import android.app.Application
import androidx.room.Room
import com.bharath.bharath_instagramfollowingpage.data.database.MyDataBase
import com.bharath.bharath_instagramfollowingpage.data.database.Repository
import com.bharath.bharath_instagramfollowingpage.data.database.RepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Singleton
    @Provides
    fun provideRoomDataBase(app: Application): MyDataBase = Room.databaseBuilder(
        app, MyDataBase::class.java, "MyDb"
    ).build()


    @Singleton
    @Provides
    fun provideDatabaseRepo(dataBase: MyDataBase): Repository = RepositoryImpl(
        dataBase.dao
    )
}