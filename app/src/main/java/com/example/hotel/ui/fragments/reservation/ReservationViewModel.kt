package com.example.hotel.ui.fragments.reservation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.Reservation
import com.example.domain.models.ResponseResult
import com.example.usecases.GetReservation
import kotlinx.coroutines.launch

class ReservationViewModel(
    private val getReservation: GetReservation
) : ViewModel() {

    private val _reservationLiveData = MutableLiveData<ResponseResult<Reservation>>()
    val reservationLiveData: LiveData<ResponseResult<Reservation>> = _reservationLiveData

    init {
        getReservation()
    }

    private fun getReservation() {
        viewModelScope.launch {
            _reservationLiveData.postValue(getReservation.invoke())
        }
    }
}
