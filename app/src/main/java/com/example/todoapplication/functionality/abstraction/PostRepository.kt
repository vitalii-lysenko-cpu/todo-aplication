package com.example.todoapplication.functionality.abstraction

import com.example.todoapplication.functionality.entities.Post

interface PostRepository {
    suspend fun getPostList(): List<Post>
}