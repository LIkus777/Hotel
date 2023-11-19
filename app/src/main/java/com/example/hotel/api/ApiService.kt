package com.example.hotel.api

import com.example.domain.models.Hotel
import com.example.domain.models.Reservation
import com.example.domain.models.Room
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {

    @GET("/v3/d144777c-a67f-4e35-867a-cacc3b827473")
    suspend fun getHotel(): Response<Hotel>

    @GET("/v3/8b532701-709e-4194-a41c-1a903af00195")
    suspend fun getRoom(): Response<List<Room>>

    @GET("/v3/63866c74-d593-432c-af8e-f279d1a8d2ff")
    suspend fun getReservation(): Response<Reservation>

    @GET
    suspend fun getImage(@Url url: String): Response<String>
}