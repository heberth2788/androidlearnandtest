package com.bbs.learnandtest.retrofitlib

data class MyData(
    val name: String,
    val dni: String,
    val key: Int,
    val enabled: Boolean,
    val city: City,
)

data class City(
    val name: String,
    val codes: List<Int>,
)

