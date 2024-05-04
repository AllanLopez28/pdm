package com.example.allan.BottonNavBar

import Screen.ProfileScreen
import Screen.ToDo
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable



@Composable
fun NavBarGraph(
    navController : NavHostController, innerPadding : PaddingValues
){
    NavHost(
        navController = navController, startDestination = ScreenRoute.Home.route
    ){
        composable(ScreenRoute.Home.route){
            ToDo()
        }
        composable(ScreenRoute.Prueba.route){
            ProfileScreen(innerPadding)
        }

    }
}

fun composable(route: String, function: () -> Unit) {

}
