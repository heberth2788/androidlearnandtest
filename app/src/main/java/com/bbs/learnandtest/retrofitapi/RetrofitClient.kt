package com.bbs.learnandtest.retrofitapi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Singleton software design pattern
object RetrofitClient {
    private const val URL = "http://192.168.1.54:5001/guadalupe-reporta/us-west1/"

    val retrofit: Retrofit = Retrofit.Builder()
                                        .baseUrl(URL)
                                        .addConverterFactory(GsonConverterFactory.create())
                                        .build()
}