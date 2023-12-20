package com.bbs.learnandtest.roomlib

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * DAO interface to represent operations in the SQLite database
 * */
@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    suspend fun getAll(): List<User>

    @Query("SELECT * FROM user WHERE dni IN (:userDniArray)")
    fun loadAllByIds(userDniArray: Array<String>): List<User>

    @Query("SELECT * FROM user WHERE dni = :dni")
    fun getUserByDni(dni: String): User

    @Query("SELECT * FROM user WHERE surname LIKE :surname")
    fun findBySurname(surname: String): List<User>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg users: User)

    @Delete
    fun delete(user: User)
}