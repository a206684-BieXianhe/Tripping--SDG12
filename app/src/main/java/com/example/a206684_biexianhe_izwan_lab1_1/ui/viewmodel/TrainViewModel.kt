package com.example.a206684_biexianhe_izwan_lab1_1.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class TrainViewModel : ViewModel() {

    var trainTransportType by mutableStateOf("")

    var trainFrom by mutableStateOf("")

    var trainTo by mutableStateOf("")

    var trainPassengers by mutableStateOf("")

}