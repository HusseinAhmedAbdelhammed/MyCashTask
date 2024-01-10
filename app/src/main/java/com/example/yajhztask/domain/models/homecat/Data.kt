package com.example.yajhztask.domain.models.homecat

import kotlinx.serialization.Serializable

@Serializable
data class Data(
    val cart_count: Int,
    val `data`: List<DataX>
)