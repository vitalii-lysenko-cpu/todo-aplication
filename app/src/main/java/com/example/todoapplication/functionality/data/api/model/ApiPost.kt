package com.example.todoapplication.functionality.data.api.model

import com.example.todoapplication.functionality.entities.Post
import com.example.todoapplication.functionality.entities.PostId
import com.example.todoapplication.functionality.entities.UserId
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class  ApiPost(
    @Json(name = "completed") val completed: Boolean,
    @Json(name = "id") val postId: Long,
    @Json(name = "title")val title: String,
    @Json(name = "userId")val userId: Long,
)

internal fun ApiPost.toEntity(): Post =
    Post(
        completed = completed,
        postId = PostId(value = postId),
        title = title,
        userId = UserId(value = userId)
    )