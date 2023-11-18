package com.example.hotel.util

import com.example.hotel.framework.HotelDataSourceImpl
import org.koin.dsl.module

val frameworkModule = module {
    factory { HotelDataSourceImpl(get()) }
}