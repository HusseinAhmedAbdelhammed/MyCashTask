package com.example.yajhztask.data.repo

import com.example.yajhztask.data.datasource.remote.RemoteDataSource
import com.example.yajhztask.domain.models.basecat.BaseCatRespoonse
import com.example.yajhztask.domain.models.homecat.HomeCatRes
import com.example.yajhztask.domain.models.popularsellers.PopularSellers
import com.example.yajhztask.domain.models.trendingsellers.TrendingSellers
import com.example.yajhztask.domain.repo.Repo
import kotlinx.coroutines.flow.Flow

class RepoImp(private val dataSource: RemoteDataSource):Repo {
    override suspend fun getPopularSellers(
        lat: Double,
        ing: Double,
        filter: Int
    ): Flow<PopularSellers> = dataSource.getPopularSellers(lat,ing,filter)

    override suspend fun getTrendingSellers(
        lat: Double,
        ing: Double,
        filter: Int
    ): Flow<TrendingSellers> = dataSource.getTrendingSellers(lat,ing,filter)

    override suspend fun getBaseCat(): Flow<BaseCatRespoonse> = dataSource.getBaseCat()

    override suspend fun getHomeCat(): Flow<HomeCatRes> = dataSource.getHomeCat()
}