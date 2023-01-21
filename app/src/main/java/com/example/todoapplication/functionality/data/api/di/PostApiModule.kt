package com.example.todoapplication.functionality.data.api.di

import com.example.todoapplication.functionality.data.api.ApiDataSource
import com.example.todoapplication.functionality.data.api.ApiDataSourceImpl
import com.example.todoapplication.functionality.data.api.PostApi
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val BASE_URL = "https://jsonplaceholder.typicode.com"

@Module
@InstallIn(SingletonComponent::class)
internal interface PostApiModule {

    @Binds
    fun bindApiDistrictDataSource(impl: ApiDataSourceImpl): ApiDataSource

    companion object {
        private lateinit var postApi: PostApi

        @Reusable
        @Provides
        fun provideDistrictApi(): PostApi {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.HEADERS

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build()

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(
                    MoshiConverterFactory
                        .create()
                        .asLenient()
                )
                .build()
            postApi = retrofit.create(PostApi::class.java)
            return postApi
        }
    }
}