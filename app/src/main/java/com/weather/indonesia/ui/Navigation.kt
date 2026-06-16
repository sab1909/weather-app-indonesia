package com.weather.indonesia.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.weather.indonesia.ui.screens.HomeScreen
import com.weather.indonesia.ui.screens.DetailScreen
import com.weather.indonesia.ui.screens.SettingsScreen

@Composable
fun WeatherAppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(navController)
        }
        composable("detail/{locationId}") { backStackEntry ->
            val locationId = backStackEntry.arguments?.getString("locationId") ?: ""
            DetailScreen(locationId, navController)
        }
        composable("settings") {
            SettingsScreen(navController)
        }
    }
}