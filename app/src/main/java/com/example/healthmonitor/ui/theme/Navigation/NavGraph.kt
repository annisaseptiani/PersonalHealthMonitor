package com.example.healthmonitor.ui.theme.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavigationGraph(modifier: Modifier, navController : NavHostController,
                    onBottomBarVisibilityChanged : (Boolean) -> Unit) {
    NavHost(navController = navController, startDestination = Route.Main.route,
        modifier = modifier) {
        composable(Route.Main.route) {
            onBottomBarVisibilityChanged(true)

        }
        composable(BottomNavigationItem.HealthReportScreen.route) {
            onBottomBarVisibilityChanged(true)

        }
        composable(BottomNavigationItem.GoalsScreen.route) {
            onBottomBarVisibilityChanged(true)

        }
        composable(BottomNavigationItem.PersonalInfoScreen.route) {
            onBottomBarVisibilityChanged(true)

        }
        composable(Route.Login.route) {
            onBottomBarVisibilityChanged(false)

        }
    }

}