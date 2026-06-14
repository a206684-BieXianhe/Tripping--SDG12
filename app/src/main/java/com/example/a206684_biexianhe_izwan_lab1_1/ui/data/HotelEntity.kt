package com.example.a206684_biexianhe_izwan_lab1_1.ui.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "hotel_table")
data class HotelEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val roomType: String,
    val nights: String,
    val rooms: String
)