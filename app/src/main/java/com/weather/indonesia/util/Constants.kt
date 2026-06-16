package com.weather.indonesia.util

object Constants {
    // API
    const val OPEN_METEO_BASE_URL = "https://api.open-meteo.com/v1/"
    const val BMKG_BASE_URL = "https://api.bmkg.go.id/"
    
    // Default Locations
    const val DEFAULT_LATITUDE = -6.2088
    const val DEFAULT_LONGITUDE = 106.8456
    const val DEFAULT_TIMEZONE = "Asia/Jakarta"
    
    // Database
    const val DATABASE_NAME = "location_database"
    
    // Preferences
    const val PREFERENCES_NAME = "weather_app_preferences"
    const val PREF_TEMPERATURE_UNIT = "temperature_unit"
    const val PREF_THEME = "theme"
    const val PREF_LANGUAGE = "language"
    const val PREF_NOTIFICATIONS_ENABLED = "notifications_enabled"
    
    // Weather Codes (WMO)
    object WeatherCodes {
        const val CLEAR_SKY = 0
        const val MAINLY_CLEAR = 1
        const val PARTLY_CLOUDY = 2
        const val OVERCAST = 3
        const val FOGGY = 45
        const val DEPOSITING_RIME_FOG = 48
        const val LIGHT_DRIZZLE = 51
        const val MODERATE_DRIZZLE = 53
        const val DENSE_DRIZZLE = 55
        const val LIGHT_RAIN = 61
        const val MODERATE_RAIN = 63
        const val HEAVY_RAIN = 65
        const val LIGHT_SNOW = 71
        const val MODERATE_SNOW = 73
        const val HEAVY_SNOW = 75
        const val RAIN_SHOWERS = 80
        const val SNOW_SHOWERS = 85
        const val THUNDERSTORM = 95
    }
}