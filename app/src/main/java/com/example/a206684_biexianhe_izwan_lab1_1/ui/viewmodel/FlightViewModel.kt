package com.example.a206684_biexianhe_izwan_lab1_1.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class FlightViewModel : ViewModel() {

    var flightTripType by mutableStateOf("One-way")

    var flightFrom by mutableStateOf("")

    var flightTo by mutableStateOf("")

    var flightPassengers by mutableStateOf("")

}