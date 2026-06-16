package com.weather.indonesia.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cloud
import androidx.compose.material.icons.filled.Opacity
import androidx.compose.material.icons.filled.Air
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.weather.indonesia.data.model.CurrentWeather

@Composable
fun WeatherCard(weather: CurrentWeather) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Cuaca Saat Ini",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            
            // Temperature
            WeatherRow(
                icon = Icons.Filled.Cloud,
                label = "Suhu",
                value = "${weather.temperature}°C"
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            // Humidity
            WeatherRow(
                icon = Icons.Filled.Opacity,
                label = "Kelembaban",
                value = "${weather.humidity}%"
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            // Wind Speed
            WeatherRow(
                icon = Icons.Filled.Air,
                label = "Kecepatan Angin",
                value = "${weather.windSpeed} km/h"
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            // Precipitation
            WeatherRow(
                icon = Icons.Filled.Cloud,
                label = "Curah Hujan",
                value = "${weather.precipitation} mm"
            )
        }
    }
}

@Composable
fun WeatherRow(
    icon: androidx.compose.material.icons.materialIcon,
    label: String,
    value: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = label,
            modifier = Modifier.size(24.dp),
            tint = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.primary
        )
    }
}