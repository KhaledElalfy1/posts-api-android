package com.example.appwithretrofit.services

import com.example.appwithretrofit.models.PostsModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("posts")
    suspend fun getData(): List<PostsModel>
}