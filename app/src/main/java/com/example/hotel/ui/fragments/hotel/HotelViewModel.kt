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

    init {
        getHotel()
    }

    private fun getHotel() {
        viewModelScope.launch(Dispatchers.IO) {
            _hotelLiveData.postValue(getHotel.invoke())
        }
    }
}
