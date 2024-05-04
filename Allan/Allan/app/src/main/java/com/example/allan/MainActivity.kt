package com.example.allan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontVariation.width
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.allan.ui.theme.AllanTheme
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.allan.BottonNavBar.NavBarComponent
import com.example.allan.BottonNavBar.NavBarGraph
import com.example.allan.BottonNavBar.NavBarItemList
import com.example.allan.ui.theme.Purple80


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AllanTheme {
                val navController = rememberNavController()
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute: String? = navBackStackEntry?.destination?.route
                val navItems = NavBarItemList()

                Scaffold (
                    topBar = {

                    },bottomBar = {
                        NavBarComponent(
                            items = navItems, currentRoute = currentRoute) {
                                currentNavigationItem -> navController.navigate(currentNavigationItem.route){
                            navController.graph.startDestinationRoute?.let{
                                    startDestinationRoute -> popUpTo(startDestinationRoute){
                                saveState = true
                            }
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                        }
                    }
                ){
                        innerPadding -> NavBarGraph(
                    navController = navController, innerPadding = innerPadding)
                }

            }
        }
    }
}
