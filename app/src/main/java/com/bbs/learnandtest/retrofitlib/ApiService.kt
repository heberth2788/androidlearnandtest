package com.bbs.learnandtest.retrofitlib

import retrofit2.http.GET

/**
 * Define the protocol to use to get information from the web service
 * */
interface ApiService {

    @GET("myTestFunction") // E.g: endpoint/path
    suspend fun getData(): MyData
}