package com.weather.indonesia.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.weather.indonesia.ui.viewmodel.LocationViewModel

@Composable
fun LocationSearchScreen(
    navController: NavController,
    viewModel: LocationViewModel = hiltViewModel(),
    onLocationSelected: (Double, Double) -> Unit = { _, _ -> }
) {
    val provinces by viewModel.provinces.collectAsState()
    val cities by viewModel.cities.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    var selectedProvince by remember { mutableStateOf<String?>(null) }
    var searchQuery by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Back Button
        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Text("Kembali")
        }

        // Search Bar
        TextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            label = { Text("Cari Lokasi") },
            leadingIcon = { Icon(Icons.Filled.Search, contentDescription = "Search") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            singleLine = true
        )

        // Province Dropdown
        if (!isLoading) {
            var expandedProvince by remember { mutableStateOf(false) }

            Button(
                onClick = { expandedProvince = !expandedProvince },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            ) {
                Text(selectedProvince ?: "Pilih Provinsi")
            }

            if (expandedProvince) {
                DropdownMenu(
                    expanded = expandedProvince,
                    onDismissRequest = { expandedProvince = false },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    provinces.forEach { province ->
                        DropdownMenuItem(
                            text = { Text(province) },
                            onClick = {
                                selectedProvince = province
                                viewModel.loadCitiesByProvince(province)
                                expandedProvince = false
                            }
                        )
                    }
                }
            }
        }

        // Cities List
        if (isLoading) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else {
            LazyColumn {
                items(cities) { city ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp)
                    ) {
                        Button(
                            onClick = { viewModel.loadLocationsByCity(city) },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                        ) {
                            Text(city)
                        }
                    }
                }
            }
        }
    }
}