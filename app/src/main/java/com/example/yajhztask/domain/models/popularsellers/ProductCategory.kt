package com.example.yajhztask.domain.models.popularsellers

import kotlinx.serialization.Serializable

@Serializable
data class ProductCategory(
    val active: Int,
    val id: Int,
    val name: String,
    val name_ar: String,
    val name_en: String
)