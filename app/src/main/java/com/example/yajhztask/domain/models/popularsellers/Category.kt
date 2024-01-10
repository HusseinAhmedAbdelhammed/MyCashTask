package com.example.yajhztask.domain.models.popularsellers

import kotlinx.serialization.Serializable

@Serializable
data class Category(
    val active: Int,
    val id: Int,
    val image: String,
    val name: String
)