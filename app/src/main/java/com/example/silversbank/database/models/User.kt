package com.example.silversbank.database.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    val username: String,
    val password: String,
    val balance: Double,
    val accontNumber: Int
){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}



