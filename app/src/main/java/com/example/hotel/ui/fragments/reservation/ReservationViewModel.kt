package com.example.hotel.ui.fragments.reservation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.usecases.GetReservation
import kotlinx.coroutines.launch

class ReservationViewModel(
    private val getReservation: GetReservation
) : ViewModel() {

    fun getReservation() {
        viewModelScope.launch {
            getReservation.invoke()
        }
    }
}
