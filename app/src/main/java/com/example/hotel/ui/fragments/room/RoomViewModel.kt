package com.example.hotel.ui.fragments.room

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.ResponseResult
import com.example.domain.models.Rooms
import com.example.usecases.GetRoom
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RoomViewModel(
    private val getRoom: GetRoom
) : ViewModel() {

    private val _roomLiveData = MutableLiveData<ResponseResult<Rooms>>()
    val roomLiveData: LiveData<ResponseResult<Rooms>> = _roomLiveData

    init {
        getRoom()
    }
    private fun getRoom() {
        viewModelScope.launch(Dispatchers.IO) {
            _roomLiveData.postValue(getRoom.invoke())
        }
    }
}
