package com.example.yajhztask.domain.models.auth.login

import kotlinx.serialization.Serializable

@Serializable
data class LoginRes(
    val `data`: Data,
    val message: String,
    val response_code: Int,
    val success: Boolean
)