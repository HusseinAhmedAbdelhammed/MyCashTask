package com.example.yajhztask.app.di

import com.example.yajhztask.domain.repo.AuthRepo
import com.example.yajhztask.domain.repo.Repo
import com.example.yajhztask.domain.usecases.GetBaseCat
import com.example.yajhztask.domain.usecases.GetHomeCat
import com.example.yajhztask.domain.usecases.GetPopularSellers
import com.example.yajhztask.domain.usecases.GetTrendingSellers
import com.example.yajhztask.domain.usecases.Login
import com.example.yajhztask.domain.usecases.Register
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {
    @Provides
    fun provideGetBaseCat(repo: Repo):GetBaseCat{
        return GetBaseCat(repo)
    }
    @Provides
    fun provideGetHomeCat(repo:Repo):GetHomeCat{
        return GetHomeCat(repo)
    }
    @Provides
    fun provideGetPopularSellers(repo: Repo):GetPopularSellers{
        return GetPopularSellers(repo)
    }
    @Provides
    fun provideGetTrendingSellers(repo: Repo):GetTrendingSellers{
        return GetTrendingSellers(repo)
    }
    @Provides
    fun provideLogin(repo: AuthRepo): Login {
        return Login(repo)
    }
    @Provides
    fun provideRegister(repo: AuthRepo):Register{
        return Register(repo)
    }
}