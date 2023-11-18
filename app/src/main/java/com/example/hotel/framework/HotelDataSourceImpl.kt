package com.example.hotel.framework

import com.example.data.source.HotelDataSource
import com.example.domain.models.Hotel
import com.example.domain.models.ResponseResult
import com.example.hotel.api.ApiService
import com.example.hotel.api.safeApiCall

class HotelDataSourceImpl(
    private val apiService: ApiService
): HotelDataSource {
    override suspend fun getHotel(): ResponseResult<Hotel> = safeApiCall { apiService.getHotel() }
}