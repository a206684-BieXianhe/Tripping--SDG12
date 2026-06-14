package com.example.a206684_biexianhe_izwan_lab1_1.ui.viewmodel

import com.example.a206684_biexianhe_izwan_lab1_1.ui.data.HotelEntity
data class HotelDetails(
    val id: Int = 0,
    val roomType: String = "Standard",
    val nights: String = "",
    val rooms: String = ""
)

data class HotelUiState(
    val hotelDetails: HotelDetails = HotelDetails(),
    val isInputValid: Boolean = false
)

fun HotelDetails.toHotelEntity(): HotelEntity = HotelEntity(
    id = id,
    roomType = roomType,
    nights = nights,
    rooms = rooms
)

fun HotelEntity.toHotelDetails(): HotelDetails = HotelDetails(
    id = id,
    roomType = roomType,
    nights = nights,
    rooms = rooms
)