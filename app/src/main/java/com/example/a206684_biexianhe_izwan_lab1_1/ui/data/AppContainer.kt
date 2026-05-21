package com.example.a206684_biexianhe_izwan_lab1_1.ui.data

import android.content.Context


class AppContainer(context: Context) {

    private val trippingDb = TrippingDatabase.getDatabase(context)


    val flightRepository: FlightRepository by lazy {
        OfflineFlightRepository(trippingDb.flightDao())
    }

}