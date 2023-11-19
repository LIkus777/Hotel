package com.example.domain.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Room (
    val id: Long,
    val name: String,
    val price: Long,
    val price_per: String,
    val peculiarities: List<String>,
    val image_urls: List<String>
)
