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

/*
This uses a tool called Dagger Hilt , which is developed by google
for creating the objects of the class and we can pass the object throughout the application .

eg :we have  Class A(object 1 , object 2 , object 3)

    I want to create an object for this class in three classes
    Class B , C , D.
    At each class we need to provide the object values every time .
    class B{
    ```java```
    object 1 obj1 = "something"()
    object 2 obj2= "something"()
    object 3 obj3= "something"()
        val a = A(
            obj1,obj2,obj3
        )
    }
    We need to repeat this process each and every time when we want to create
    the object for class A or want to access some methods or functions from class A.

    --> Instead we can do this
    we will create a object for the class A in this module
    @Singleton -> Creates an instance throughout the application
    @Provides -> It will provide the class instance when we @Inject in another class

    from previous to now ->
     @Singleton
     @Provides

     fun provideClassA(Object obj1, Object obj2, Object obj3) = Class A(obj1,obj2,ojb3)

     also we need to create instances for objects as well

     @Singleton
     @Provides
     fun provideObject1 ()= Object1()

     @Singleton
     @Provides
     fun provideObject2 ()= Object2()

     @Singleton
     @Provides
     fun provideObject3 ()= Object3()


    and In the classes
    we do class B @Inject constructor (private val clsA :Class A){
        // we can our operations in  the class A
    }


 */
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