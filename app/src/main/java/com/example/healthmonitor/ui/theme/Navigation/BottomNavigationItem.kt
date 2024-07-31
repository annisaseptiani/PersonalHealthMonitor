package com.example.healthmonitor.ui.theme.Navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CheckCircleOutline
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.InsertChart
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavigationItem(val route: String,
    val title : String, val icon : ImageVector) {
    object MainScreen : BottomNavigationItem(
        route = "main_screen",
        title = "Main",
        icon = Icons.Outlined.Home
    )
    object HealthReportScreen : BottomNavigationItem(
        route = "report_screen",
        title = "Health Report",
        icon = Icons.Outlined.InsertChart
    )
    object GoalsScreen : BottomNavigationItem(
        route = "goals_screen",
        title = "Goals",
        icon = Icons.Outlined.CheckCircleOutline
    )
    object PersonalInfoScreen : BottomNavigationItem(
        route = "personal_screen",
        title = "Personal Info",
        icon = Icons.Outlined.Person
    )
}