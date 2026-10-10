package com.example.weatherapp.ui


import androidx.compose.foundation.Image
import com.example.weatherapp.R
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weatherapp.ui.screens.CurrentForecast
import com.example.weatherapp.ui.screens.Forecast
import com.example.weatherapp.ui.theme.LightBlue40
import com.example.weatherapp.ui.theme.fontNunito


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Navigation() {

    val navController = rememberNavController()
    var selectedIndex by remember { mutableIntStateOf(0) } // default set to 0



    Scaffold(
        containerColor = Color.White,
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
                    icon = {
                        Image(
                            painter = painterResource(id = R.drawable.hometransparent),
                            contentDescription = "Home",
                            modifier = Modifier.size(50.dp)
                        )
                    },
                    label = { Text("Today", fontFamily = fontNunito, fontSize = 15.sp, fontWeight = FontWeight.Bold) },
                    selected = selectedIndex == 0,
                    // Source - https://stackoverflow.com/questions/74487632/how-to-remove-selected-oval-item-color-in-bottombar-jetpack-compose
                    colors = androidx.compose.material3.NavigationBarItemDefaults
                        .colors(
                            selectedIconColor = LightBlue40,
                            indicatorColor = LightBlue40.copy(0.25f)
                        ),
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
                    icon = {
                        Image(
                            painter = painterResource(id = R.drawable.weektransparenttwo),
                            contentDescription = "Week",
                            modifier = Modifier.size(50.dp)
                        )
                    },
                    label = { Text("Week", fontFamily = fontNunito, fontSize = 15.sp, fontWeight = FontWeight.Bold) },
                    selected = selectedIndex == 1,
                    // Source - https://stackoverflow.com/questions/74487632/how-to-remove-selected-oval-item-color-in-bottombar-jetpack-compose
                    colors = androidx.compose.material3.NavigationBarItemDefaults
                        .colors(
                            selectedIconColor = LightBlue40,
                            indicatorColor = LightBlue40.copy(0.25f)
                        ),
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
