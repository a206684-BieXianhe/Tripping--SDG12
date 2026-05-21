package com.example.a206684_biexianhe_izwan_lab1_1.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.a206684_biexianhe_izwan_lab1_1.ui.data.FlightEntity
import com.example.a206684_biexianhe_izwan_lab1_1.ui.data.FlightRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class FlightViewModel(
    private val flightRepository: FlightRepository
) : ViewModel() {


    private val _flightUiState = MutableStateFlow(FlightUiState())
    val flightUiState: StateFlow<FlightUiState> = _flightUiState.asStateFlow()


    val allFlightList = flightRepository.getAllFlightsStream()


    fun updateFlightDetails(newData: FlightDetails) {
        _flightUiState.update {
            it.copy(
                flightDetails = newData,
                isInputValid = checkInputValid(newData)
            )
        }
    }


    private fun checkInputValid(details: FlightDetails): Boolean {
        return details.fromLocation.isNotBlank()
                && details.toLocation.isNotBlank()
                && details.passengers.isNotBlank()
    }


    suspend fun saveFlightData() {
        val currentState = flightUiState.value
        if (currentState.isInputValid) {
            val flightEntity = currentState.flightDetails.toFlightEntity()
            flightRepository.insertFlight(flightEntity)
        }
    }


    fun clearFlightForm() {
        _flightUiState.value = FlightUiState()
    }

    fun deleteFlight(flight: FlightEntity) {
        viewModelScope.launch {
            flightRepository.deleteFlight(flight)
        }
    }

    fun loadFlight(id: Int) {
        viewModelScope.launch {
            flightRepository.getFlightStream(id).collect { flight ->
                flight?.let {
                    _flightUiState.update { state ->
                        state.copy(flightDetails = it.toFlightDetails())
                    }
                }
            }
        }
    }

    fun updateFlight() {
        viewModelScope.launch {
            val currentState = flightUiState.value
            if (currentState.isInputValid) {
                flightRepository.updateFlight(
                    currentState.flightDetails.toFlightEntity()
                )
            }
        }
    }
}


class FlightViewModelFactory(
    private val repo: FlightRepository
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FlightViewModel::class.java)) {
            return FlightViewModel(repo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}