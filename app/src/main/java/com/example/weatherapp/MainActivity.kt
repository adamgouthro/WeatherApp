package com.example.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.weatherapp.models.Weather
import com.example.weatherapp.models.WeeklyForecast
import com.example.weatherapp.ui.Navigation
import com.example.weatherapp.ui.screens.CurrentForecast
import com.example.weatherapp.ui.screens.CurrentForecast
import com.example.weatherapp.ui.screens.Forecast
//import androidx.compose.ui.graphics.Color
import com.example.weatherapp.ui.theme.WeatherAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeatherAppTheme {
//                Box(modifier = Modifier.fillMaxWidth().fillMaxHeight().paint(painterResource(id = R.drawable.bgsunny), contentScale = ContentScale.FillBounds))
                Navigation()
                }
            }
        }
    }


