package com.example.hotel.api

import com.example.domain.models.Hotel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("/v3/63866c74-d593-432c-af8e-f279d1a8d2ff")
    suspend fun getHotel(): Response<Hotel>

}