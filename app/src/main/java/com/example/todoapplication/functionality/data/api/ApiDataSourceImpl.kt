package com.example.todoapplication.functionality.data.api

import com.example.todoapplication.functionality.data.api.model.toEntity
import com.example.todoapplication.functionality.entities.Post
import javax.inject.Inject

class ApiDataSourceImpl @Inject constructor(
    private val postApi: PostApi,
) : ApiDataSource {

    override suspend fun getPostList(): List<Post> =
        postApi.getPostList().map { it.toEntity() }

}
