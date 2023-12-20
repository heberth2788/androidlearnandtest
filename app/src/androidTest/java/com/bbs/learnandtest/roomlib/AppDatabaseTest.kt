package com.bbs.learnandtest.roomlib

import android.content.Context
import android.util.Log
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.*


@RunWith(value = AndroidJUnit4::class)
class AppDatabaseTest {

    private lateinit var userDao: UserDao
    private lateinit var db: AppDatabase

    @Before
    fun setUp() {
        Log.d("AppDatabaseTest","Before - setUp")
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context,
                                        AppDatabase::class.java).build()
        userDao = db.userDao()
    }

    @After
    fun tearDown() { // It means "demoler, hechar abajo" in Spanish.
        Log.d("AppDatabaseTest", "After - tearDown")
        db.close()
    }

    @Test
    fun userDaoTest() = runBlocking{
        Log.d("AppDatabaseTest", "userDaoTest")

        // Arrange
        val expUserNum = 2
        val expDniMan = "45453948"
        val expDniWoman = "44309130"

        // Act
        userDao.insertAll(User(
            dni = "45453948",
            code = 1988,
            name = "HD",
            desc = "The richest man",
            state = true,
            surname = "D",
        ), User(
            dni = "44309130",
            code = 1987,
            name = "LM",
            desc = "The richest woman",
            state = true,
            surname = "M",
        ))
        val users: List<User> = userDao.getAll()

        // Assert
        assertEquals(expUserNum, users.size)
        assertEquals(expDniMan, users[0].dni)
        assertEquals(expDniWoman, users[1].dni)
    }
}