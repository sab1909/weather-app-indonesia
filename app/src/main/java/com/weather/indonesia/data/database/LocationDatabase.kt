package com.weather.indonesia.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.weather.indonesia.data.database.entity.LocationEntity

@Database(
    entities = [LocationEntity::class],
    version = 1,
    exportSchema = true
)
abstract class LocationDatabase : RoomDatabase() {
    abstract fun locationDao(): LocationDao

    companion object {
        @Volatile
        private var instance: LocationDatabase? = null

        fun getInstance(context: Context): LocationDatabase {
            return instance ?: synchronized(this) {
                val newInstance = Room.databaseBuilder(
                    context.applicationContext,
                    LocationDatabase::class.java,
                    "location_database"
                )
                    .createFromAsset("databases/locations.db")
                    .build()
                instance = newInstance
                newInstance
            }
        }
    }
}