package com.weather.indonesia.data.repository

import com.weather.indonesia.data.model.WeatherData
import com.weather.indonesia.data.remote.WeatherApiService
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val weatherApiService: WeatherApiService
) {
    suspend fun getWeatherData(latitude: Double, longitude: Double): WeatherData {
        return weatherApiService.getWeatherData(latitude, longitude)
    }
}