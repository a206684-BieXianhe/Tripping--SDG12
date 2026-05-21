package com.example.a206684_biexianhe_izwan_lab1_1.ui.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface FlightDao {

    @Query("SELECT * FROM flights ORDER BY id DESC")
    fun getAllFlights(): Flow<List<FlightEntity>>

    @Query("SELECT * FROM flights WHERE id = :id")
    fun getFlight(id: Int): Flow<FlightEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFlight(flight: FlightEntity)

    @Delete
    suspend fun deleteFlight(flight: FlightEntity)

    @Update
    suspend fun updateFlight(flight: FlightEntity)
}