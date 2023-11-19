package com.example.hotel.util

import com.example.data.source.HotelDataSource
import com.example.data.source.ReservationDataSource
import com.example.data.source.RoomDataSource
import com.example.hotel.framework.HotelDataSourceImpl
import com.example.hotel.framework.ReservationDataSourceImpl
import com.example.hotel.framework.RoomDataSourceImpl
import org.koin.dsl.module

val frameworkModule = module {
    factory <HotelDataSource> { HotelDataSourceImpl(get()) }
    factory <RoomDataSource> { RoomDataSourceImpl(get()) }
    factory <ReservationDataSource> { ReservationDataSourceImpl(get()) }
}