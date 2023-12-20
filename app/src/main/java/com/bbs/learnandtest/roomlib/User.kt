package com.bbs.learnandtest.roomlib

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

/**
 * User entity of the Room database, that represent a table on SQLite
 * */
@Entity
data class User(
    @PrimaryKey
    val dni: String,
    @ColumnInfo(name = "first_name")
    val name: String?,
    val surname: String?,
    val state: Boolean?,
    val code: Int?,
    //@Ignore
    val desc: String?,
)