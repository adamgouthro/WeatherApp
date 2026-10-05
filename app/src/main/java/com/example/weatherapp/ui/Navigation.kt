package com.example.weatherapp.ui

import android.R
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ViewWeek
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weatherapp.ui.screens.CurrentForecast
import com.example.weatherapp.ui.screens.Forecast
import com.example.weatherapp.ui.theme.LightBlue40
import com.example.weatherapp.ui.theme.LightYellow40
import com.example.weatherapp.ui.theme.fontNunito

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Navigation() {

    val navController = rememberNavController()
    var selectedIndex by remember { mutableIntStateOf(0) } // default set to 0



    Scaffold(
//        containerColor = Color.Transparent,
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = Color.White,
                    titleContentColor = Color.Black,
                ),

                title = {
                    Text("Halifax, Nova Scotia", fontFamily = fontNunito)
                }
            )
        },

        bottomBar = {
            NavigationBar(windowInsets = NavigationBarDefaults.windowInsets,
                containerColor = Color.White,
                contentColor = Color.White
            )

            {
                // NavigationBarItem()
                NavigationBarItem(
                    icon = { Icon(imageVector = Icons.Default.Home, contentDescription = "Search") },
                    label = { Text("Today", fontFamily = fontNunito) },
                    selected = selectedIndex == 0,
                    onClick = {
                        selectedIndex = 0
                        navController.navigate(route="today"){
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )

                NavigationBarItem(
                    icon = { Icon(imageVector = Icons.Default.ViewWeek, contentDescription = "Search") },
                    label = { Text("Week", fontFamily = fontNunito) },
                    selected = selectedIndex == 1,
                    onClick = {
                        selectedIndex = 1
                        navController.navigate(route="week"){
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true

                        }
                    }
                )

            }
        }
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = "today",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = "today") {
               CurrentForecast()
            }
            composable(route = "week") {
                Forecast()
            }

        }

        }
    }
