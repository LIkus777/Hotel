package com.example.hotel.ui.fragments.hotel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.Hotel
import com.example.domain.models.ResponseResult
import com.example.usecases.GetHotel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HotelViewModel(
    private val getHotel: GetHotel
) : ViewModel() {

    private val _hotelLiveData = MutableLiveData<ResponseResult<Hotel>>()
    val hotelLiveData: LiveData<ResponseResult<Hotel>> = _hotelLiveData

    private val _hotelImages = MutableLiveData<ResponseResult<String>>()
    val hotelImages: LiveData<ResponseResult<String>> = _hotelImages

    init {
        getHotel()
    }

    fun getHotel() {
        viewModelScope.launch(Dispatchers.IO) {
            _hotelLiveData.postValue(getHotel.invoke())
        }
    }

    fun getImage(url: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _hotelImages.postValue(getHotel.invoke(url))
        }
    }

}