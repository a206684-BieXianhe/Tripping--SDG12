package com.example.a206684_biexianhe_izwan_lab1_1.ui.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [FlightEntity::class],
    version = 1,
    exportSchema = false
)
abstract class TrippingDatabase : RoomDatabase() {

    abstract fun flightDao(): FlightDao

    companion object {
        @Volatile
        private var Instance: TrippingDatabase? = null

        fun getDatabase(context: Context): TrippingDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    TrippingDatabase::class.java,
                    "tripping_app_database"
                )
                    .fallbackToDestructiveMigration(true)
                    .build()
                    .also { Instance = it }
            }
        }
    }
}
