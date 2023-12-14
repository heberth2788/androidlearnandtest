package com.bbs.learnandtest.retrofitapi

import retrofit2.http.GET

interface ApiService {

    @GET("myTestFunction") // E.g: endpoint/path
    suspend fun getData(): MyData
}