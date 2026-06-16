package com.weather.indonesia.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class WeatherData(
    @SerializedName("latitude")
    val latitude: Double,
    @SerializedName("longitude")
    val longitude: Double,
    @SerializedName("timezone")
    val timezone: String,
    @SerializedName("current")
    val current: CurrentWeather?
) : Parcelable

@Parcelize
data class CurrentWeather(
    @SerializedName("temperature")
    val temperature: Double,
    @SerializedName("weather_code")
    val weatherCode: Int,
    @SerializedName("wind_speed")
    val windSpeed: Double,
    @SerializedName("humidity")
    val humidity: Int,
    @SerializedName("precipitation")
    val precipitation: Double
) : Parcelable

data class LocationData(
    val id: String,
    val provinsi: String,
    val kabupaten: String,
    val kecamatan: String,
    val desa: String,
    val latitude: Double,
    val longitude: Double
)