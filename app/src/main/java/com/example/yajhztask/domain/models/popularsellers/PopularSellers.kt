package com.example.yajhztask.domain.models.popularsellers

import kotlinx.serialization.Serializable

@Serializable
data class PopularSellers(
    val `data`: List<Data>,
    val message: String,
    val response_code: Int,
    val success: Boolean
)