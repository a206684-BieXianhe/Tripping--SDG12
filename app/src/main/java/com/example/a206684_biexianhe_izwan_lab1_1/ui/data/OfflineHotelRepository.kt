package com.example.a206684_biexianhe_izwan_lab1_1.ui.data

import com.example.a206684_biexianhe_izwan_lab1_1.ui.data.HotelDao
import com.example.a206684_biexianhe_izwan_lab1_1.ui.data.HotelEntity
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.Flow

class OfflineHotelRepository(
    private val hotelDao: HotelDao
) : HotelRepository {

    private val firestore = Firebase.firestore

    override fun getAllHotelsStream(): Flow<List<HotelEntity>> =
        hotelDao.getAllHotelsStream()

    override fun getHotelStream(id: Int): Flow<HotelEntity?> =
        hotelDao.getHotelStream(id)

    override suspend fun insertHotel(hotel: HotelEntity) {
        hotelDao.insertHotel(hotel)
        val data = hashMapOf(
            "roomType" to hotel.roomType,
            "nights" to hotel.nights,
            "rooms" to hotel.rooms
        )
        firestore.collection("hotels").add(data)
    }

    override suspend fun updateHotel(hotel: HotelEntity) =
        hotelDao.updateHotel(hotel)

    override suspend fun deleteHotel(hotel: HotelEntity) =
        hotelDao.deleteHotel(hotel)
}