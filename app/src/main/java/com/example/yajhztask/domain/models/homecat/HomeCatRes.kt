package com.example.yajhztask.domain.models.homecat

import kotlinx.serialization.Serializable

@Serializable
data class HomeCatRes(
    val `data`: Data,
    val message: String,
    val response_code: Int,
    val success: Boolean
)