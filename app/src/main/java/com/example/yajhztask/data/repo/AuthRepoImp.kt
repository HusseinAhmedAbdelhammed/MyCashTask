package com.example.yajhztask.data.repo

import com.example.yajhztask.data.datasource.remote.RemoteDataSource
import com.example.yajhztask.domain.models.auth.login.LoginRes
import com.example.yajhztask.domain.models.auth.reg.RegRes
import com.example.yajhztask.domain.repo.AuthRepo
import kotlinx.coroutines.flow.Flow

class AuthRepoImp(private val dataSource: RemoteDataSource):AuthRepo {
    override suspend fun login(
        email: String,
        password: String,
        deviceToken: String
    ): Flow<LoginRes> = dataSource.login(email,password,deviceToken)

    override suspend fun register(
        name: String,
        email: String,
        password: String,
        phoneNumber: String,
        deviceToken: String
    ): Flow<RegRes> = dataSource.register(name,email,password,phoneNumber,deviceToken)
}