package com.example.data.repositories

import com.example.data.source.ReservationDataSource

class ReservationRepository(
    private val reservationDataSource: ReservationDataSource
) {
    suspend fun getReservation() = reservationDataSource.getReservation()
}