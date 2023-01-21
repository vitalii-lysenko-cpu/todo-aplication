package com.example.todoapplication.functionality.entities


data class Post(
    val completed: Boolean,
    val postId: PostId,
    val title: String,
    val userId: UserId
)