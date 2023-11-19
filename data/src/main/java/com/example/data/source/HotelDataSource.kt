package com.example.data.source

import com.example.domain.models.Hotel
import com.example.domain.models.ResponseResult

interface HotelDataSource {
    suspend fun getHotel(): ResponseResult<Hotel>
}