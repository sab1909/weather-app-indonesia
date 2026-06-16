package com.weather.indonesia.util

import com.weather.indonesia.util.Constants.WeatherCodes

fun getWeatherDescription(code: Int): String {
    return when (code) {
        WeatherCodes.CLEAR_SKY -> "Cerah"
        WeatherCodes.MAINLY_CLEAR -> "Sebagian Besar Cerah"
        WeatherCodes.PARTLY_CLOUDY -> "Berawan Sebagian"
        WeatherCodes.OVERCAST -> "Mendung"
        WeatherCodes.FOGGY -> "Berkabut"
        WeatherCodes.DEPOSITING_RIME_FOG -> "Kabut Embun"
        WeatherCodes.LIGHT_DRIZZLE -> "Gerimis Ringan"
        WeatherCodes.MODERATE_DRIZZLE -> "Gerimis Sedang"
        WeatherCodes.DENSE_DRIZZLE -> "Gerimis Lebat"
        WeatherCodes.LIGHT_RAIN -> "Hujan Ringan"
        WeatherCodes.MODERATE_RAIN -> "Hujan Sedang"
        WeatherCodes.HEAVY_RAIN -> "Hujan Lebat"
        WeatherCodes.LIGHT_SNOW -> "Salju Ringan"
        WeatherCodes.MODERATE_SNOW -> "Salju Sedang"
        WeatherCodes.HEAVY_SNOW -> "Salju Lebat"
        WeatherCodes.RAIN_SHOWERS -> "Hujan Rintik"
        WeatherCodes.SNOW_SHOWERS -> "Hujan Salju"
        WeatherCodes.THUNDERSTORM -> "Badai Petir"
        else -> "Tidak Diketahui"
    }
}

fun getWeatherIcon(code: Int): String {
    return when (code) {
        WeatherCodes.CLEAR_SKY -> "☀️"
        WeatherCodes.MAINLY_CLEAR -> "🌤️"
        WeatherCodes.PARTLY_CLOUDY -> "⛅"
        WeatherCodes.OVERCAST -> "☁️"
        WeatherCodes.FOGGY -> "🌫️"
        WeatherCodes.DEPOSITING_RIME_FOG -> "🌫️"
        WeatherCodes.LIGHT_DRIZZLE -> "🌦️"
        WeatherCodes.MODERATE_DRIZZLE -> "🌧️"
        WeatherCodes.DENSE_DRIZZLE -> "🌧️"
        WeatherCodes.LIGHT_RAIN -> "🌧️"
        WeatherCodes.MODERATE_RAIN -> "🌧️"
        WeatherCodes.HEAVY_RAIN -> "⛈️"
        WeatherCodes.LIGHT_SNOW -> "❄️"
        WeatherCodes.MODERATE_SNOW -> "❄️"
        WeatherCodes.HEAVY_SNOW -> "❄️"
        WeatherCodes.RAIN_SHOWERS -> "🌦️"
        WeatherCodes.SNOW_SHOWERS -> "🌨️"
        WeatherCodes.THUNDERSTORM -> "⛈️"
        else -> "🌡️"
    }
}

fun convertTemperature(celsius: Double, toFahrenheit: Boolean): Double {
    return if (toFahrenheit) {
        (celsius * 9/5) + 32
    } else {
        celsius
    }
}