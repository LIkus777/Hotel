package com.example.domain.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Reservation (
    val id: Long,
    val hotel_name: String,
    val hotel_adress: String,
    val horating: Long,
    val rating_name: String,
    val departure: String,
    val arrival_country: String,
    val tour_date_start: String,
    val tour_date_stop: String,
    val number_of_nights: Long,
    val room: String,
    val nutrition: String,
    val tour_price: Long,
    val fuel_charge: Long,
    val service_charge: Long
)