package com.example.a206684_biexianhe_izwan_lab1_1.ui.data

import kotlinx.coroutines.flow.Flow

class OfflineFlightRepository(
    private val flightDao: FlightDao
) : FlightRepository {

    override fun getAllFlightsStream(): Flow<List<FlightEntity>> = flightDao.getAllFlights()

    override fun getFlightStream(id: Int): Flow<FlightEntity?> = flightDao.getFlight(id)

    override suspend fun insertFlight(flight: FlightEntity) = flightDao.insertFlight(flight)

    override suspend fun deleteFlight(flight: FlightEntity) = flightDao.deleteFlight(flight)

    override suspend fun updateFlight(flight: FlightEntity) = flightDao.updateFlight(flight)
}