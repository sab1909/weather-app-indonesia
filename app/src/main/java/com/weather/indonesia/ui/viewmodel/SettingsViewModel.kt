package com.weather.indonesia.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.weather.indonesia.data.model.WeatherData
import com.weather.indonesia.data.preferences.PreferencesManager
import com.weather.indonesia.data.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val preferencesManager: PreferencesManager
) : ViewModel() {

    val temperatureUnit: StateFlow<String> = preferencesManager.temperatureUnit
        .asStateFlow("celsius")
    val themeMode: StateFlow<String> = preferencesManager.themeMode
        .asStateFlow("system")
    val language: StateFlow<String> = preferencesManager.language
        .asStateFlow("id")
    val notificationsEnabled: StateFlow<Boolean> = preferencesManager.notificationsEnabled
        .asStateFlow(true)

    fun setTemperatureUnit(unit: String) {
        viewModelScope.launch {
            preferencesManager.setTemperatureUnit(unit)
        }
    }

    fun setThemeMode(mode: String) {
        viewModelScope.launch {
            preferencesManager.setThemeMode(mode)
        }
    }

    fun setLanguage(lang: String) {
        viewModelScope.launch {
            preferencesManager.setLanguage(lang)
        }
    }

    fun setNotificationsEnabled(enabled: Boolean) {
        viewModelScope.launch {
            preferencesManager.setNotificationsEnabled(enabled)
        }
    }
}