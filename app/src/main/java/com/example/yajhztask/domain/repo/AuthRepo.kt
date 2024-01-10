package com.example.yajhztask.domain.repo

import com.example.yajhztask.domain.models.auth.login.LoginRes
import com.example.yajhztask.domain.models.auth.reg.RegRes
import kotlinx.coroutines.flow.Flow

interface AuthRepo {
    suspend fun login(email:String,password:String,deviceToken:String): Flow<LoginRes>
    suspend fun register(name:String,email: String,password: String,phoneNumber:String,deviceToken:String):Flow<RegRes>
}