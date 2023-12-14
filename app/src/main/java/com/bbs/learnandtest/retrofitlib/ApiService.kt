package com.bbs.learnandtest.retrofitlib

import retrofit2.http.GET

interface ApiService {

    @GET("myTestFunction") // E.g: endpoint/path
    suspend fun getData(): MyData
}