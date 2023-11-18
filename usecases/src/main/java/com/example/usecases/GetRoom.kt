package com.example.usecases

import com.example.data.repositories.RoomRepository
import com.example.domain.models.ResponseResult
import com.example.domain.models.Room

class GetRoom(private val roomRepository: RoomRepository) {
    suspend operator fun invoke(): ResponseResult<List<Room>> = roomRepository.getRooms()
}