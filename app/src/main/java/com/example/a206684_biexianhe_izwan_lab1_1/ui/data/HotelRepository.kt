package com.example.a206684_biexianhe_izwan_lab1_1.ui.data

import com.example.a206684_biexianhe_izwan_lab1_1.ui.data.HotelEntity
import kotlinx.coroutines.flow.Flow

interface HotelRepository {
    fun getAllHotelsStream(): Flow<List<HotelEntity>>
    fun getHotelStream(id: Int): Flow<HotelEntity?>
    suspend fun insertHotel(hotel: HotelEntity)
    suspend fun updateHotel(hotel: HotelEntity)
    suspend fun deleteHotel(hotel: HotelEntity)
}