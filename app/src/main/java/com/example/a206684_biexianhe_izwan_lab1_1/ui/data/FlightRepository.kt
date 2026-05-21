package com.example.a206684_biexianhe_izwan_lab1_1.ui.data

import kotlinx.coroutines.flow.Flow

interface FlightRepository {

    fun getAllFlightsStream(): Flow<List<FlightEntity>>


    fun getFlightStream(id: Int): Flow<FlightEntity?>


    suspend fun insertFlight(flight: FlightEntity)


    suspend fun deleteFlight(flight: FlightEntity)


    suspend fun updateFlight(flight: FlightEntity)
}