package com.example.data.source

import com.example.domain.models.ResponseResult
import com.example.domain.models.Room

interface RoomDataSource {
    suspend fun getRoom(): ResponseResult<List<Room>>
}