package com.weather.indonesia.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

data class BottomNavItem(
    val label: String,
    val icon: ImageVector,
    val route: String
)

@Composable
fun BottomNavBar(
    currentRoute: String,
    onNavigate: (String) -> Unit
) {
    val items = listOf(
        BottomNavItem("Home", Icons.Filled.Home, "home"),
        BottomNavItem("Settings", Icons.Filled.Settings, "settings")
    )

    NavigationBar {
        items.forEach { item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = item.label) },
                label = { Text(item.label) },
                selected = currentRoute == item.route,
                onClick = { onNavigate(item.route) }
            )
        }
    }
}