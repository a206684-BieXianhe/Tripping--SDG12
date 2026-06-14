package com.example.a206684_biexianhe_izwan_lab1_1.ui.data

import kotlinx.coroutines.flow.Flow
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class OfflineFlightRepository(
    private val flightDao: FlightDao
) : FlightRepository {

    private val firestore = Firebase.firestore

    override fun getAllFlightsStream(): Flow<List<FlightEntity>> = flightDao.getAllFlights()

    override fun getFlightStream(id: Int): Flow<FlightEntity?> = flightDao.getFlight(id)

    override suspend fun insertFlight(flight: FlightEntity) {
        flightDao.insertFlight(flight)
        val data = hashMapOf(
            "tripType" to flight.tripType,
            "fromLocation" to flight.fromLocation,
            "toLocation" to flight.toLocation,
            "passengers" to flight.passengers
        )
        firestore.collection("flights").add(data)
    }

    override suspend fun deleteFlight(flight: FlightEntity) = flightDao.deleteFlight(flight)

    override suspend fun updateFlight(flight: FlightEntity) = flightDao.updateFlight(flight)
}