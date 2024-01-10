package com.example.yajhztask.domain.models.homecat

import kotlinx.serialization.Serializable

@Serializable
data class DataX(
    val active: Int,
    val id: Int,
    val image: String,
    val name: String,
    val name_ar: String,
    val name_en: String
)