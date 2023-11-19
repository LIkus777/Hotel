package com.example.domain.models

import com.example.domain.models.AboutTheHotel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Hotel (
    val id: Long,
    val name: String,
    val adress: String,
    val minimal_price: Long,
    val price_for_it: String,
    val rating: Long,
    val rating_name: String,
    val image_urls: List<String>,
    val about_the_hotel: AboutTheHotel
)
