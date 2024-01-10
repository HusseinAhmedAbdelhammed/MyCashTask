package com.example.yajhztask.domain.models.trendingsellers

import kotlinx.serialization.Serializable

@Serializable
data class TrendingSellers(
    val `data`: List<Data>,
    val message: String,
    val response_code: Int,
    val success: Boolean
)