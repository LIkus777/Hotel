package com.example.hotel.util

import com.example.data.repositories.HotelRepository
import com.example.data.repositories.ReservationRepository
import com.example.data.repositories.RoomRepository
import org.koin.dsl.module

val dataModule = module {
    factory { HotelRepository(get()) }
    factory { RoomRepository(get()) }
    factory { ReservationRepository(get()) }
}
