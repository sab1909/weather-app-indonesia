package com.weather.indonesia.data.database

import androidx.room.Dao
import androidx.room.Query
import com.weather.indonesia.data.database.entity.LocationEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface LocationDao {
    @Query("SELECT * FROM locations")
    fun getAllLocations(): Flow<List<LocationEntity>>

    @Query("SELECT * FROM locations WHERE provinsi = :province")
    fun getLocationsByProvince(province: String): Flow<List<LocationEntity>>

    @Query("SELECT * FROM locations WHERE kabupaten = :city")
    fun getLocationsByCity(city: String): Flow<List<LocationEntity>>

    @Query("SELECT DISTINCT provinsi FROM locations ORDER BY provinsi")
    fun getAllProvinces(): Flow<List<String>>

    @Query("SELECT DISTINCT kabupaten FROM locations WHERE provinsi = :province ORDER BY kabupaten")
    fun getCitiesByProvince(province: String): Flow<List<String>>

    @Query("SELECT * FROM locations WHERE id = :locationId")
    fun getLocationById(locationId: String): Flow<LocationEntity?>
}