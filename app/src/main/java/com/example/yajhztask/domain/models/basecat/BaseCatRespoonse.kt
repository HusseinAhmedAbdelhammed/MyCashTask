package com.example.yajhztask.domain.models.basecat

import kotlinx.serialization.Serializable

@Serializable
data class BaseCatRespoonse(
    val `data`: List<Data>,
    val message: String,
    val response_code: Int,
    val success: Boolean
)