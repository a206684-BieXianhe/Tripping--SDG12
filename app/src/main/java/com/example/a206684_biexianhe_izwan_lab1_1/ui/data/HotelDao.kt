package com.example.a206684_biexianhe_izwan_lab1_1.ui.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface HotelDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHotel(hotel: HotelEntity)

    @Update
    suspend fun updateHotel(hotel: HotelEntity)

    @Delete
    suspend fun deleteHotel(hotel: HotelEntity)

    @Query("SELECT * FROM hotel_table ORDER BY id ASC")
    fun getAllHotelsStream(): Flow<List<HotelEntity>>

    @Query("SELECT * FROM hotel_table WHERE id = :id")
    fun getHotelStream(id: Int): Flow<HotelEntity?>
}