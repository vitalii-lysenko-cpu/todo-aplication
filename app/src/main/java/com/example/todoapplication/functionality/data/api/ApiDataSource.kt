package com.example.todoapplication.functionality.data.api

import com.example.todoapplication.functionality.entities.Post

interface ApiDataSource {
    suspend fun getPostList(): List<Post>
}