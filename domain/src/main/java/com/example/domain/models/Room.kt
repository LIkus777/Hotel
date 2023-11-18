package com.example.domain.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Room (
    val id: Long,
    val name: String,
    val price: Long,

    @SerialName(value = "price_per")
    val pricePer: String,

    val peculiarities: List<String>,

    @SerialName(value = "image_urls")
    val imageUrls: List<String>
)
