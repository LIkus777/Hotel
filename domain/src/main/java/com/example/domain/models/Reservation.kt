package com.example.domain.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Reservation (
    val id: Long,

    @SerialName(value = "hotel_name")
    val hotelName: String,

    @SerialName(value = "hotel_adress")
    val hotelAdress: String,

    val horating: Long,

    @SerialName(value = "rating_name")
    val ratingName: String,

    val departure: String,

    @SerialName(value = "arrival_country")
    val arrivalCountry: String,

    @SerialName(value = "tour_date_start")
    val tourDateStart: String,

    @SerialName(value = "tour_date_stop")
    val tourDateStop: String,

    @SerialName(value = "number_of_nights")
    val numberOfNights: Long,

    val room: String,
    val nutrition: String,

    @SerialName(value = "tour_price")
    val tourPrice: Long,

    @SerialName(value = "fuel_charge")
    val fuelCharge: Long,

    @SerialName(value = "service_charge")
    val serviceCharge: Long
)