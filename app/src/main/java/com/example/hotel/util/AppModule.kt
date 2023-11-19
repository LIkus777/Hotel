package com.example.hotel.util

import com.example.hotel.ui.base.BaseMainViewModel
import com.example.hotel.ui.fragments.hotel.HotelViewModel
import com.example.hotel.ui.fragments.reservation.ReservationViewModel
import com.example.hotel.ui.fragments.room.RoomViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { BaseMainViewModel() }
    viewModel { HotelViewModel(get()) }
    viewModel { RoomViewModel(get()) }
    viewModel { ReservationViewModel(get()) }
}
