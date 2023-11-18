package com.example.data.source

import com.example.domain.models.Reservation
import com.example.domain.models.ResponseResult

interface ReservationDataSource {
    suspend fun getReservation(): ResponseResult<Reservation>
}