package com.example.healthmonitor.ui.theme.Navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.healthmonitor.ui.theme.Pink40
import com.example.healthmonitor.ui.theme.Pink80

@Composable
fun BottomNavigation(navController: NavController, state : Boolean,
                     modifier: Modifier = Modifier) {
    val screens = listOf(
        BottomNavigationItem.MainScreen,
        BottomNavigationItem.HealthReportScreen,
        BottomNavigationItem.GoalsScreen,
        BottomNavigationItem.PersonalInfoScreen
    )
    NavigationBar(
        modifier = modifier,
        
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        
        screens.forEach{screens ->
            NavigationBarItem(label = { Text(text = screens.title!!)},
                selected = currentRoute == screens.route,
                icon = { Icon(imageVector = screens.icon, contentDescription = "bottom icon") },
                onClick = { 
                    navController.navigate(screens.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    unselectedTextColor = Color.White,
                    selectedTextColor = Pink40,
                    selectedIconColor = Pink80,
                    unselectedIconColor = Color.White
                )
                )
            
        }
    }
}