package com.example.yajhztask.app.di

import com.example.yajhztask.data.datasource.remote.RemoteDataSource
import com.example.yajhztask.data.repo.AuthRepoImp
import com.example.yajhztask.data.repo.RepoImp
import com.example.yajhztask.domain.repo.AuthRepo
import com.example.yajhztask.domain.repo.Repo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {
    @Provides
    @Singleton
    fun provideMainRepo(remoteDataSource: RemoteDataSource):Repo{
        return RepoImp(remoteDataSource)
    }
    @Provides
    @Singleton
    fun provideAuthRepo(remoteDataSource: RemoteDataSource):AuthRepo{
        return AuthRepoImp(remoteDataSource)
    }
}