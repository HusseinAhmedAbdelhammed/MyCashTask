package com.example.yajhztask.domain.models.auth.reg

import kotlinx.serialization.Serializable

@Serializable
data class RegRequest(
    val name:String,
    val email:String,
    val password:String,
    val phone:String,
    val device_token:String
)
