package com.bbs.learnandtest.roomlib

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * Abstract class to represent the database and its configuration
 * This serves as the app's main access point to the persisted data.
 * */
@Database(entities = [User::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao
}