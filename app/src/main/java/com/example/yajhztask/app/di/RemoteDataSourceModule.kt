package com.example.yajhztask.app.di

import com.example.yajhztask.data.api.ApiService
import com.example.yajhztask.data.datasource.remote.RemoteDataSource
import com.example.yajhztask.data.datasource.remote.RemoteDataSourceImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteDataSourceModule {
    @Provides
    @Singleton
    fun provideRemoteDataSource(apiService: ApiService):RemoteDataSource{
        return RemoteDataSourceImp(apiService)
    }
}