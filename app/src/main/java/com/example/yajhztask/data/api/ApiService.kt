package com.example.yajhztask.data.api

import com.example.yajhztask.domain.models.auth.login.LoginRes
import com.example.yajhztask.domain.models.auth.reg.RegRes
import com.example.yajhztask.domain.models.basecat.BaseCatRespoonse
import com.example.yajhztask.domain.models.homecat.HomeCatRes
import com.example.yajhztask.domain.models.popularsellers.PopularSellers
import com.example.yajhztask.domain.models.trendingsellers.TrendingSellers

interface ApiService {
    suspend fun getPopularSellers(lat:Double,ing:Double,filter:Int): PopularSellers
    suspend fun getTrendingSellers(lat:Double,ing:Double,filter:Int): TrendingSellers
    suspend fun getBaseCat(): BaseCatRespoonse
    suspend fun getHomeCat(): HomeCatRes
    suspend fun login(email:String,password:String,deviceToken:String): LoginRes
    suspend fun register(name:String,email: String,password: String,phoneNumber:String,deviceToken:String): RegRes
}