package com.example.a206684_biexianhe_izwan_lab1_1.ui.viewmodel

import com.example.a206684_biexianhe_izwan_lab1_1.ui.data.FlightEntity

data class FlightDetails(
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
    tripType = tripType,
    fromLocation = fromLocation,
    toLocation = toLocation,
    passengers = passengers
)

fun FlightEntity.toFlightDetails(): FlightDetails = FlightDetails(
    tripType = tripType,
    fromLocation = fromLocation,
    toLocation = toLocation,
    passengers = passengers
)