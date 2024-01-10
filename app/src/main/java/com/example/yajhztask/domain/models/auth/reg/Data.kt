package com.example.yajhztask.domain.models.auth.reg

import kotlinx.serialization.Serializable

@Serializable
data class Data(
    val addresses: List<String?>,
    val balance: String,
    val email: String,
    val id: Int,
    val image: String,
    val name: String,
    val phone: String,
    val status: Int,
    val token: String,
    val type: Int
)