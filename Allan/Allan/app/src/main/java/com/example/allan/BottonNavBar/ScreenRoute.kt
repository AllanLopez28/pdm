package com.example.allan.BottonNavBar

sealed class ScreenRoute(var route: String) {
    object Home : ScreenRoute("home")
    object Prueba : ScreenRoute("prueba")
}