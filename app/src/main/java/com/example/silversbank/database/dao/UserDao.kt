package com.example.silversbank.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.silversbank.database.models.User
import com.example.silversbank.database.models.Login


@Dao
interface UserDao {

    @Query("SELECT username FROM user")
    fun getUsername(): List<String>

    @Query("SELECT username, password FROM user")
    fun getLogin(): List<Login>

    @Query("SELECT accontNumber FROM user")
    fun getAccNumber(): List<Int>

    @Query("SELECT * FROM user WHERE username = :username")
    fun getAccountUser(username:String): User

    @Query("SELECT balance FROM user WHERE accontNumber =:accNumber")
    fun getBalance(accNumber: Int): Double

    @Query("UPDATE user SET balance = :value WHERE accontNumber = :accNumber")
    fun transferValue(value:Double, accNumber:Int)

    @Insert
    fun RegisterUser(user: User)
}