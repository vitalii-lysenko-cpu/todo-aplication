package com.example.todoapplication.functionality.domain

import com.example.todoapplication.functionality.abstraction.PostRepository
import javax.inject.Inject

class GetPostListUseCase @Inject constructor(
    private val postRepository: PostRepository,
) {
    suspend operator fun invoke () =
        postRepository.getPostList()
}
