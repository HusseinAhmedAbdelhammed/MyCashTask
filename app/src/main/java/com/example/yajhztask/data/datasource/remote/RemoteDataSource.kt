package com.example.yajhztask.data.datasource.remote

import com.example.yajhztask.domain.models.auth.login.LoginRes
import com.example.yajhztask.domain.models.auth.reg.RegRes
import com.example.yajhztask.domain.models.basecat.BaseCatRespoonse
import com.example.yajhztask.domain.models.homecat.HomeCatRes
import com.example.yajhztask.domain.models.popularsellers.PopularSellers
import com.example.yajhztask.domain.models.trendingsellers.TrendingSellers
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {
    suspend fun getPopularSellers(lat:Double,ing:Double,filter:Int): Flow<PopularSellers>
    suspend fun getTrendingSellers(lat:Double,ing:Double,filter:Int): Flow<TrendingSellers>
    suspend fun getBaseCat(): Flow<BaseCatRespoonse>
    suspend fun getHomeCat(): Flow<HomeCatRes>
    suspend fun login(email:String,password:String,deviceToken:String): Flow<LoginRes>
    suspend fun register(name:String,email: String,password: String,phoneNumber:String,deviceToken:String):Flow<RegRes>
}