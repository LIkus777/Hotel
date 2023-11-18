package com.example.usecases

import com.example.data.repositories.ReservationRepository

class GetReservation(private val reservationRepository: ReservationRepository) {
    suspend operator fun invoke() = reservationRepository.getReservation()
}