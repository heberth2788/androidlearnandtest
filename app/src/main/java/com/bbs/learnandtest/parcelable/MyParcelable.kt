package com.bbs.learnandtest.parcelable

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * A `Parcelable` class is used to pass data between activities.
 * E.g: using intents.
 */
@Parcelize
data class MyParcelable(
    val name: String,
    val age: Int,
    val dni: String,
) : Parcelable