package com.example.healthmonitor.ui.theme.Navigation

sealed class Route(val route : String) {
    object Main : Route("main_screen")
    object Login : Route("login_screen")
}