package com.example.todoapplication.functionality.data.src.di

import com.example.todoapplication.functionality.abstraction.PostRepository
import com.example.todoapplication.functionality.data.src.PostRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface PostDataModule {

    @Binds
    fun bindPostRepository(impl: PostRepositoryImpl): PostRepository
}
