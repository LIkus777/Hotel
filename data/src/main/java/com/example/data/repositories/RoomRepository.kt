package com.example.data.repositories

import com.example.data.source.RoomDataSource
import com.example.domain.models.ResponseResult
import com.example.domain.models.Rooms

class RoomRepository(
    private val roomDataSource: RoomDataSource
) {
    suspend fun getRooms(): ResponseResult<Rooms> = roomDataSource.getRoom()
}