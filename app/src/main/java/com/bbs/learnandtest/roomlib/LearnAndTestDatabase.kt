package com.bbs.learnandtest.roomlib

import android.content.Context
import androidx.room.Room

object LearnAndTestDatabase {

    private var db: AppDatabase? = null

    fun getDatabase(context: Context): AppDatabase? {
        if(db == null) {
            db = Room.databaseBuilder(context, AppDatabase::class.java, "learnandtestdb").build()
        }
        return db
    }
}