package com.example.yajhztask.domain.models.popularsellers

import kotlinx.serialization.Serializable

@Serializable
data class Information(
    val activity: String?,
    val driving_image: String,
    val id: Int,
    val identity_number: String,
    val nationality: String,
    val tax_record: String,
    val vehicle_image: String,
    val vehicle_registration: String,
    val vehicle_tablet_image: String
)