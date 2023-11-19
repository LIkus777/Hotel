package com.example.hotel.framework

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.example.data.source.HotelDataSource
import com.example.domain.models.Hotel
import com.example.domain.models.ResponseResult
import com.example.hotel.api.ApiService
import com.example.hotel.api.safeApiCall
import java.net.URL

class HotelDataSourceImpl(
    private val apiService: ApiService,
) : HotelDataSource {
    override suspend fun getHotel(): ResponseResult<Hotel> = safeApiCall { apiService.getHotel() }
    override suspend fun getImage(url: String): ResponseResult<String> = safeApiCall { apiService.getImage(url) }
}