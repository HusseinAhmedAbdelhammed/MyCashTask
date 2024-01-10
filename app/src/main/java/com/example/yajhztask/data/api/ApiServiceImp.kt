package com.example.yajhztask.data.api

import com.example.yajhztask.domain.models.auth.login.LoginRequest
import com.example.yajhztask.domain.models.auth.login.LoginRes
import com.example.yajhztask.domain.models.auth.reg.RegRequest
import com.example.yajhztask.domain.models.auth.reg.RegRes
import com.example.yajhztask.domain.models.basecat.BaseCatRespoonse
import com.example.yajhztask.domain.models.homecat.HomeCatRes
import com.example.yajhztask.domain.models.popularsellers.PopularSellers
import com.example.yajhztask.domain.models.trendingsellers.TrendingSellers
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.forms.formData
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.util.InternalAPI

class ApiServiceImp(private val client:HttpClient):ApiService {
    override suspend fun getPopularSellers(lat: Double, ing: Double, filter: Int): PopularSellers {
        return client.get{
            url(ApiConsts.POPULAR_SELLERS)
            parameter("lat",lat)
            parameter("lng",ing)
            parameter("filter",filter)
            header("Accept","application/json")
            header("Authorization",ApiConsts.AUTH)
            header("lang","ar")
        }.body()
    }

    override suspend fun getTrendingSellers(lat: Double, ing: Double, filter: Int): TrendingSellers {
        return client.get{
            url(ApiConsts.TRENDING_SELLERS)
            parameter("lat",lat)
            parameter("lng",ing)
            parameter("filter",filter)
            header("Accept","application/json")
            header("Authorization",ApiConsts.AUTH)
            header("lang","ar")
        }.body()
    }

    override suspend fun getBaseCat(): BaseCatRespoonse {
        return client.get{
            url(ApiConsts.BASE_CATEGORIES)
            header("Accept","application/json")
            header("Authorization",ApiConsts.AUTH_CAT)
            header("lang","ar")
        }.body()
    }

    override suspend fun getHomeCat(): HomeCatRes {
        return client.get{
            url(ApiConsts.HOME_BASE_CATEGORIES)
            header("Accept","application/json")
            header("Authorization",ApiConsts.AUTH_CAT)
            header("lang","ar")
        }.body()
    }

    @OptIn(InternalAPI::class)
    override suspend fun login(email: String, password: String, deviceToken: String): LoginRes {
        return client.post{
            url(ApiConsts.LOGIN)

            setBody(LoginRequest(email,password,deviceToken))
            contentType(ContentType.Application.Json)

            parameter("password",password)
            parameter("device_token",deviceToken)
            header("Accept","application/json")
            header("lang","ar")
        }.body()
    }

    @OptIn(InternalAPI::class)
    override suspend fun register(
        name: String,
        email: String,
        password: String,
        phoneNumber: String,
        deviceToken: String
    ): RegRes {
        return client.post{
            url(ApiConsts.REGISTER)
            header("lang","ar")
            contentType(ContentType.Application.Json)
           setBody(RegRequest(name,email,password,phoneNumber,deviceToken))

        }.body()
    }
}