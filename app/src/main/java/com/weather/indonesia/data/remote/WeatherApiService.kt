package com.weather.indonesia.data.remote

import com.weather.indonesia.data.model.WeatherData
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {
    @GET("forecast")
    suspend fun getWeatherData(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("current") current: String = "temperature,weather_code,wind_speed,humidity,precipitation",
        @Query("timezone") timezone: String = "Asia/Jakarta"
    ): WeatherData
}

interface BMKGApiService {
    @GET("weather")
    suspend fun getBMKGWeatherData(
        @Query("province") province: String
    ): String
}