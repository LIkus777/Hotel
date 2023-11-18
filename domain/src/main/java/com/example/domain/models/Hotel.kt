package com.example.domain.models

import com.example.domain.models.AboutTheHotel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Hotel (
    val id: Long,
    val name: String,
    val adress: String,

    @SerialName(value = "minimal_price")
    val minimalPrice: Long,

    @SerialName(value = "price_for_it")
    val priceForIt: String,

    val rating: Long,

    @SerialName(value = "rating_name")
    val ratingName: String,

    @SerialName(value = "image_urls")
    val imageUrls: List<String>,

    @SerialName(value = "about_the_hotel")
    val aboutTheHotel: AboutTheHotel
)
