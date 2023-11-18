package com.example.data.repositories

import com.example.data.source.HotelDataSource
import com.example.domain.models.Hotel
import com.example.domain.models.ResponseResult

class HotelRepository(
    private val hotelDataSource: HotelDataSource,

) {
    suspend fun getHotel(): ResponseResult<Hotel> = hotelDataSource.getHotel()
}