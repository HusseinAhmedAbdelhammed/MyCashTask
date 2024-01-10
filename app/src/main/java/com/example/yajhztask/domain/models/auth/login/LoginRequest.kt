package com.example.yajhztask.domain.models.auth.login

import kotlinx.serialization.Serializable

@Serializable
data class LoginRequest(
    val email:String,
    val password:String,
    val device_token:String
)
