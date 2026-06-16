package com.weather.indonesia.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.weather.indonesia.data.database.entity.LocationEntity
import com.weather.indonesia.data.repository.LocationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LocationViewModel @Inject constructor(
    private val locationRepository: LocationRepository
) : ViewModel() {

    private val _provinces = MutableStateFlow<List<String>>(emptyList())
    val provinces: StateFlow<List<String>> = _provinces.asStateFlow()

    private val _cities = MutableStateFlow<List<String>>(emptyList())
    val cities: StateFlow<List<String>> = _cities.asStateFlow()

    private val _locations = MutableStateFlow<List<LocationEntity>>(emptyList())
    val locations: StateFlow<List<LocationEntity>> = _locations.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    init {
        loadProvinces()
    }

    private fun loadProvinces() {
        viewModelScope.launch {
            _isLoading.value = true
            locationRepository.getAllProvinces().collect { provinceList ->
                _provinces.value = provinceList
                _isLoading.value = false
            }
        }
    }

    fun loadCitiesByProvince(province: String) {
        viewModelScope.launch {
            _isLoading.value = true
            locationRepository.getCitiesByProvince(province).collect { cityList ->
                _cities.value = cityList
                _isLoading.value = false
            }
        }
    }

    fun loadLocationsByCity(city: String) {
        viewModelScope.launch {
            _isLoading.value = true
            locationRepository.getLocationsByCity(city).collect { locationList ->
                _locations.value = locationList
                _isLoading.value = false
            }
        }
    }

    fun loadLocationsByProvince(province: String) {
        viewModelScope.launch {
            _isLoading.value = true
            locationRepository.getLocationsByProvince(province).collect { locationList ->
                _locations.value = locationList
                _isLoading.value = false
            }
        }
    }
}