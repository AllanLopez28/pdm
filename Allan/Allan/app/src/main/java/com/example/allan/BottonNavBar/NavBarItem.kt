package com.example.allan.BottonNavBar

import androidx.compose.ui.graphics.vector.ImageVector

data class NavBarItem (
    val title : String, val route : String, val selectedIcon : ImageVector, val unSelectedIcon : ImageVector, )
