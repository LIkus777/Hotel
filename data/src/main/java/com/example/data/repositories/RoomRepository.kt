package com.example.data.repositories

import com.example.data.source.RoomDataSource
import com.example.domain.models.ResponseResult
import com.example.domain.models.Room

class RoomRepository(
    private val roomDataSource: RoomDataSource
) {
    suspend fun getRooms(): ResponseResult<List<Room>> = roomDataSource.getRoom()
}