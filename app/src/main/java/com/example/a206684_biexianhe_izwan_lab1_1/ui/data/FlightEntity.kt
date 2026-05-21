package com.example.a206684_biexianhe_izwan_lab1_1.ui.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "flights")
data class FlightEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val tripType: String,
    val fromLocation: String,
    val toLocation: String,
    val passengers: String
)