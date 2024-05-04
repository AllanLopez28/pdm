package com.example.allan.BottonNavBar

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import com.example.allan.R

@Composable
fun NavBarItemList(): List<NavBarItem> {
    return listOf(
        NavBarItem(
            "Inicio",
            ScreenRoute.Home.route,
            ImageVector.vectorResource(id = R.drawable.ic_home_filled),
            ImageVector.vectorResource(id = R.drawable.ic_home_outlined)
        ),
        NavBarItem(
            "Profile",
            ScreenRoute.Prueba.route,
            ImageVector.vectorResource(id = R.drawable.ic_home_filled),
            ImageVector.vectorResource(id = R.drawable.ic_home_outlined)
        )
    )
}