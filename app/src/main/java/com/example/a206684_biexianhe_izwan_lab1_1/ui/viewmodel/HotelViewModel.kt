package com.example.a206684_biexianhe_izwan_lab1_1.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.a206684_biexianhe_izwan_lab1_1.ui.data.HotelEntity
import com.example.a206684_biexianhe_izwan_lab1_1.ui.data.HotelRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class HotelViewModel(
    private val hotelRepository: HotelRepository
) : ViewModel() {

    private val _hotelUiState = MutableStateFlow(HotelUiState())
    val hotelUiState: StateFlow<HotelUiState> = _hotelUiState.asStateFlow()

    val allHotelList = hotelRepository.getAllHotelsStream()

    fun updateHotelDetails(newData: HotelDetails) {
        _hotelUiState.update {
            it.copy(
                hotelDetails = newData,
                isInputValid = checkInputValid(newData)
            )
        }
    }

    private fun checkInputValid(details: HotelDetails): Boolean {
        return details.nights.isNotBlank()
                && details.rooms.isNotBlank()
    }

    suspend fun saveHotelData() {
        val currentState = hotelUiState.value
        if (currentState.isInputValid) {
            val hotelEntity = currentState.hotelDetails.toHotelEntity()
            hotelRepository.insertHotel(hotelEntity)
        }
    }

    fun clearHotelForm() {
        _hotelUiState.value = HotelUiState()
    }

    fun deleteHotel(hotel: HotelEntity) {
        viewModelScope.launch {
            hotelRepository.deleteHotel(hotel)
        }
    }

    fun loadHotel(id: Int) {
        viewModelScope.launch {
            hotelRepository.getHotelStream(id).collect { hotel ->
                hotel?.let {
                    _hotelUiState.update { state ->
                        state.copy(hotelDetails = it.toHotelDetails())
                    }
                }
            }
        }
    }

    fun updateHotel() {
        viewModelScope.launch {
            val currentState = hotelUiState.value
            if (currentState.isInputValid) {
                hotelRepository.updateHotel(
                    currentState.hotelDetails.toHotelEntity()
                )
            }
        }
    }
}

class HotelViewModelFactory(
    private val repo: HotelRepository
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HotelViewModel::class.java)) {
            return HotelViewModel(repo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}