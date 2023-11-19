package com.example.hotel.framework

import com.example.data.source.ReservationDataSource
import com.example.domain.models.Reservation
import com.example.domain.models.ResponseResult
import com.example.hotel.api.ApiService
import com.example.hotel.api.safeApiCall

class ReservationDataSourceImpl(
    private val apiService: ApiService
) : ReservationDataSource {
    override suspend fun getReservation(): ResponseResult<Reservation> = safeApiCall { apiService.getReservation() }
}
