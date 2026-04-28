package com.example.a206684_biexianhe_izwan_lab1_1.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class HotelViewModel : ViewModel() {

    var hotelRoomType by mutableStateOf("")

    var hotelNights by mutableStateOf("")

    var hotelRooms by mutableStateOf("")

}