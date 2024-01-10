package com.example.yajhztask.domain.models.basecat

import kotlinx.serialization.Serializable

@Serializable
data class Data(
    val active: Int,
    val id: Int,
    val image: String,
    val name: String,
    val name_ar: String,
    val name_en: String
)