package com.weather.indonesia.data.preferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class PreferencesManager(private val context: Context) {

    companion object {
        val TEMPERATURE_UNIT = stringPreferencesKey("temperature_unit")
        val THEME_MODE = stringPreferencesKey("theme_mode")
        val LANGUAGE = stringPreferencesKey("language")
        val NOTIFICATIONS_ENABLED = booleanPreferencesKey("notifications_enabled")
    }

    val temperatureUnit: Flow<String> = context.dataStore.data.map { preferences ->
        preferences[TEMPERATURE_UNIT] ?: "celsius"
    }

    val themeMode: Flow<String> = context.dataStore.data.map { preferences ->
        preferences[THEME_MODE] ?: "system"
    }

    val language: Flow<String> = context.dataStore.data.map { preferences ->
        preferences[LANGUAGE] ?: "id"
    }

    val notificationsEnabled: Flow<Boolean> = context.dataStore.data.map { preferences ->
        preferences[NOTIFICATIONS_ENABLED] ?: true
    }

    suspend fun setTemperatureUnit(unit: String) {
        context.dataStore.edit { preferences ->
            preferences[TEMPERATURE_UNIT] = unit
        }
    }

    suspend fun setThemeMode(mode: String) {
        context.dataStore.edit { preferences ->
            preferences[THEME_MODE] = mode
        }
    }

    suspend fun setLanguage(lang: String) {
        context.dataStore.edit { preferences ->
            preferences[LANGUAGE] = lang
        }
    }

    suspend fun setNotificationsEnabled(enabled: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[NOTIFICATIONS_ENABLED] = enabled
        }
    }
}