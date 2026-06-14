package com.example.a206684_biexianhe_izwan_lab1_1.ui.viewmodel

import com.example.a206684_biexianhe_izwan_lab1_1.ui.data.FlightEntity

data class FlightDetails(
    val id: Int = 0,
    val tripType: String = "One-way",
    val fromLocation: String = "",
    val toLocation: String = "",
    val passengers: String = ""
)

data class FlightUiState(
    val flightDetails: FlightDetails = FlightDetails(),
    val isInputValid: Boolean = false
)

fun FlightDetails.toFlightEntity(): FlightEntity = FlightEntity(
    id = id,
    tripType = tripType,
    fromLocation = fromLocation,
    toLocation = toLocation,
    passengers = passengers
)

fun FlightEntity.toFlightDetails(): FlightDetails = FlightDetails(
    id = id,
    tripType = tripType,
    fromLocation = fromLocation,
    toLocation = toLocation,
    passengers = passengers
)