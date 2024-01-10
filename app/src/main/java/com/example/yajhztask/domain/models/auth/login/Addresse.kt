package com.example.yajhztask.domain.models.auth.login

import kotlinx.serialization.Serializable

@Serializable
data class Addresse(
    val address: String?,
    val apartment: String,
    val building: String,
    val floor: String?,
    val id: Int,
    val lat: String,
    val lng: String,
    val name: String?,
    val street: String
)