package com.example.usecases

import com.example.data.repositories.HotelRepository
import com.example.domain.models.Hotel
import com.example.domain.models.ResponseResult

class GetHotel(private val hotelRepository: HotelRepository) {
    suspend operator fun invoke(): ResponseResult<Hotel> = hotelRepository.getHotel()
    suspend operator fun invoke(url: String): ResponseResult<String> = hotelRepository.getImage(url)
}