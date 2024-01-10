package com.example.yajhztask.domain.models.auth.reg

import kotlinx.serialization.Serializable

@Serializable
data class RegRes(
    val `data`: Data,
    val message: String,
    val response_code: Int,
    val success: Boolean
)