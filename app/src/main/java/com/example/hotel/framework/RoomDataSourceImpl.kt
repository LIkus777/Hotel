package com.example.hotel.framework

import com.example.data.source.RoomDataSource
import com.example.domain.models.ResponseResult
import com.example.domain.models.Rooms
import com.example.hotel.api.ApiService
import com.example.hotel.api.safeApiCall

class RoomDataSourceImpl(
    private val apiService: ApiService
) : RoomDataSource {
    override suspend fun getRoom(): ResponseResult<Rooms> = safeApiCall { apiService.getRoom() }
}
