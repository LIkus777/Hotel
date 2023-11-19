package com.example.hotel.util

import com.example.usecases.GetHotel
import com.example.usecases.GetReservation
import com.example.usecases.GetRoom
import org.koin.dsl.module

val useCasesModule = module {
    factory { GetHotel(get()) }
    factory { GetRoom(get()) }
    factory { GetReservation(get()) }
}