package com.example.myapplication.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplication.data.model.User

@Dao
interface UserDao {
    @Query("SELECT * FROM User")
    fun getAll(): List<User>

    @Query("SELECT * FROM User WHERE name = :username LIMIT 1")
    suspend fun getUserByName(username: String): User?

    @Query("SELECT * FROM User WHERE name = :username AND password = :password")
    suspend fun login(username: String, password: String): User?

    @Query("SELECT * FROM User WHERE name = :username")
    suspend fun checkUserName(username: String): User?

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun register(user: User): Long

    @Delete
    fun delete(user: User)
}