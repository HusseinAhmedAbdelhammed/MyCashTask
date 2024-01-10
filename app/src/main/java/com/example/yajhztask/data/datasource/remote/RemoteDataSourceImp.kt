package com.example.yajhztask.data.datasource.remote

import com.example.yajhztask.data.api.ApiService
import com.example.yajhztask.domain.models.auth.login.LoginRes
import com.example.yajhztask.domain.models.auth.reg.RegRes
import com.example.yajhztask.domain.models.basecat.BaseCatRespoonse
import com.example.yajhztask.domain.models.homecat.HomeCatRes
import com.example.yajhztask.domain.models.popularsellers.PopularSellers
import com.example.yajhztask.domain.models.trendingsellers.TrendingSellers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RemoteDataSourceImp(private val apiClient:ApiService):RemoteDataSource {
    override suspend fun getPopularSellers(
        lat: Double,
        ing: Double,
        filter: Int
    ): Flow<PopularSellers> = flow{
        emit(apiClient.getPopularSellers(lat,ing,filter))
    }

    override suspend fun getTrendingSellers(
        lat: Double,
        ing: Double,
        filter: Int
    ): Flow<TrendingSellers> = flow{
        emit(apiClient.getTrendingSellers(lat,ing,filter))
    }

    override suspend fun getBaseCat(): Flow<BaseCatRespoonse> = flow{
        emit(apiClient.getBaseCat())
    }

    override suspend fun getHomeCat(): Flow<HomeCatRes> = flow {
        emit(apiClient.getHomeCat())
    }

    override suspend fun login(
        email: String,
        password: String,
        deviceToken: String
    ): Flow<LoginRes> = flow {
        emit(apiClient.login(email,password,deviceToken))
    }

    override suspend fun register(
        name: String,
        email: String,
        password: String,
        phoneNumber: String,
        deviceToken: String
    ): Flow<RegRes> = flow {
        emit(apiClient.register(name,email,password,phoneNumber,deviceToken))
    }
}