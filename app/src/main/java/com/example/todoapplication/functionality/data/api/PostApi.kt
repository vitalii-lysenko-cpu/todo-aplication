package com.example.todoapplication.functionality.data.api

import com.example.todoapplication.functionality.data.api.model.ApiPost
import retrofit2.http.GET

interface PostApi {
    @GET("/todos")
     suspend fun getPostList(
    ): List<ApiPost>
}