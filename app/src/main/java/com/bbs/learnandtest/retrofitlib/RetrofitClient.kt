package com.bbs.learnandtest.retrofitlib

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Singleton software design pattern for the Retrofit Client
 */
object RetrofitClient {
    // URl of the web service
    private const val URL = "http://192.168.1.54:5001/guadalupe-reporta/us-west1/"

    // Object to get informartion from the web service
    val retrofit: Retrofit = Retrofit.Builder()
                                        .baseUrl(URL)
                                        .addConverterFactory(GsonConverterFactory.create())
                                        .build()
}