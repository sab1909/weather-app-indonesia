package com.weather.indonesia.data.repository

import com.weather.indonesia.data.database.LocationDao
import com.weather.indonesia.data.database.entity.LocationEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocationRepository @Inject constructor(
    private val locationDao: LocationDao
) {
    fun getAllLocations(): Flow<List<LocationEntity>> = locationDao.getAllLocations()

    fun getLocationsByProvince(province: String): Flow<List<LocationEntity>> =
        locationDao.getLocationsByProvince(province)

    fun getLocationsByCity(city: String): Flow<List<LocationEntity>> =
        locationDao.getLocationsByCity(city)

    fun getAllProvinces(): Flow<List<String>> = locationDao.getAllProvinces()

    fun getCitiesByProvince(province: String): Flow<List<String>> =
        locationDao.getCitiesByProvince(province)

    fun getLocationById(locationId: String): Flow<LocationEntity?> =
        locationDao.getLocationById(locationId)
}