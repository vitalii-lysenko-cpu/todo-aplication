package com.example.todoapplication.functionality.data.src

import com.example.todoapplication.functionality.abstraction.PostRepository
import com.example.todoapplication.functionality.data.api.ApiDataSource
import com.example.todoapplication.functionality.entities.Post
import javax.inject.Inject

internal class PostRepositoryImpl @Inject constructor(
    private val apiDataSource: ApiDataSource
): PostRepository {
    override suspend fun getPostList(): List<Post> =
        apiDataSource.getPostList()
}