package com.example.silversbank.database

import android.content.Context
import androidx.room.RoomDatabase
import androidx.room.Database
import androidx.room.Room
import com.example.silversbank.database.dao.UserDao
import com.example.silversbank.database.models.User


@Database(entities = [User::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object{
        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun getDao(context: Context): AppDataBase =
            INSTANCE ?: synchronized(this){
                INSTANCE ?: dbbuilder(context).also{ INSTANCE = it}
            }


        fun dbbuilder(context: Context)=
            Room.databaseBuilder(
                context.applicationContext,
                AppDataBase::class.java, "Bank-Database"
            ).build()
    }


}