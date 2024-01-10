package com.example.yajhztask.domain.repo

import com.example.yajhztask.domain.models.basecat.BaseCatRespoonse
import com.example.yajhztask.domain.models.homecat.HomeCatRes
import com.example.yajhztask.domain.models.popularsellers.PopularSellers
import com.example.yajhztask.domain.models.trendingsellers.TrendingSellers
import kotlinx.coroutines.flow.Flow

interface Repo {
    suspend fun getPopularSellers(lat:Double,ing:Double,filter:Int): Flow<PopularSellers>
    suspend fun getTrendingSellers(lat:Double,ing:Double,filter:Int):Flow<TrendingSellers>
    suspend fun getBaseCat():Flow<BaseCatRespoonse>
    suspend fun getHomeCat():Flow<HomeCatRes>
}