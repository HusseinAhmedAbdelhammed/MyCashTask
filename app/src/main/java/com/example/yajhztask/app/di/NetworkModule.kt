package com.example.yajhztask.app.di

import com.example.yajhztask.data.api.ApiService
import com.example.yajhztask.data.api.ApiServiceImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android


import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
@Provides
@Singleton
fun provideHttpClient(): HttpClient {
    return HttpClient(Android){

        install(ContentNegotiation){
            json()
        }
    }
}
    @Provides
    @Singleton
    fun provideApiService(httpClient: HttpClient):ApiService{
        return ApiServiceImp(httpClient)
    }
}