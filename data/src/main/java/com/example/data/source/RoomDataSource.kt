package com.example.data.source

import com.example.domain.models.ResponseResult
import com.example.domain.models.Rooms

interface RoomDataSource {
    suspend fun getRoom(): ResponseResult<Rooms>
}