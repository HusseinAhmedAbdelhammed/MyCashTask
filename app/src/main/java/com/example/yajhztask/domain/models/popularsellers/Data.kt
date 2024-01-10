package com.example.yajhztask.domain.models.popularsellers

import kotlinx.serialization.Serializable

@Serializable
data class Data(
    val address: String,
    val appointments: String,
    val categories: List<Category>,
    val description: String,
    val distance: String,
    val email: String,
    val id: Int,
    val image: String,
    val information: Information,
    val is_favorite: Boolean,
    val lat: String,
    val lng: String,
    val logo: String,
    val name: String,
    val phone: String,
    val popular: Int,
    val product_categories: List<ProductCategory>,
    val rate: String,
    val status: Int,
    val token: String,
    val trending: Int,
    val type: Int
)