package com.example.weatherapp.ui.screens


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.R
import com.example.weatherapp.models.WeeklyForecast
import com.example.weatherapp.ui.theme.LightBlue40

@Composable
fun Forecast()
{
    val forecastList = listOf(
        WeeklyForecast(
            currentTemperature = 34,
            currentHigh = 36,
            currentLow = 32,
            feelLike = 34,
            location = "Halifax, Nova Scotia",
            day = "Sunday",
            chanceOfRain = 0,
            amountOfRain = 0,
            resourceId = R.drawable.sun
        ),
        WeeklyForecast(
            currentTemperature = 26,
            currentHigh = 28,
            currentLow = 22,
            feelLike = 27,
            location = "Halifax, Nova Scotia",
            day = "Monday",
            chanceOfRain = 0,
            amountOfRain = 0,
            resourceId = R.drawable.sunnyovercast
        ),
        WeeklyForecast(
            currentTemperature = 25,
            currentHigh = 26,
            currentLow = 24,
            feelLike = 25,
            location = "Halifax, Nova Scotia",
            day = "Tuesday",
            chanceOfRain = 0,
            amountOfRain = 0,
            resourceId = R.drawable.overcast
        ),
        WeeklyForecast(
            currentTemperature = 24,
            currentHigh = 27,
            currentLow = 22,
            feelLike = 25,
            location = "Halifax, Nova Scotia",
            day = "Wednesday",
            chanceOfRain = 100,
            amountOfRain = 10,
            resourceId = R.drawable.rainy
        ),
        WeeklyForecast(
            currentTemperature = 22,
            currentHigh = 25,
            currentLow = 20,
            feelLike = 22,
            location = "Halifax, Nova Scotia",
            day = "Thursday",
            chanceOfRain = 100,
            amountOfRain = 15,
            resourceId = R.drawable.rainy
        ),
        WeeklyForecast(
            currentTemperature = 30,
            currentHigh = 32,
            currentLow = 30,
            feelLike = 20,
            location = "Halifax, Nova Scotia",
            day = "Friday",
            chanceOfRain = 0,
            amountOfRain = 0,
            resourceId = R.drawable.sun
        ),
        WeeklyForecast(
            currentTemperature = 36,
            currentHigh = 38,
            currentLow = 33,
            feelLike = 36,
            location = "Halifax, Nova Scotia",
            day = "Saturday",
            chanceOfRain = 0,
            amountOfRain = 0,
            resourceId = R.drawable.sun
        )
    )

    // PUT LOCATION IN NAVBAR TOP

    LazyColumn(
        modifier = Modifier
            .background(color = LightBlue40)
            .padding(20.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(forecastList) { WeeklyForecast ->

            Row(horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp)
                    .border
                        (
                        border = BorderStroke(width = 5.dp, color = Color.Black),
                        shape = RectangleShape
                    )
                    .padding(vertical = 20.dp)) {

                Text(WeeklyForecast.day)


                Column(modifier = Modifier) {
                    Image(
                    painter = painterResource(id = WeeklyForecast.resourceId),
                    contentDescription = "Weather",
                        modifier = Modifier
                            .size(100.dp)
                            .padding(15.dp)
                    )
                }

                Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally) {

                    Text("${WeeklyForecast.currentTemperature}°C", fontWeight = FontWeight.Bold,
                        fontSize = 25.sp)

                }

                // maybe separate rows into columns too
                Column() {
                    Row() {
                        Text("High: ${WeeklyForecast.currentHigh}°C")
                    }
                    Row() {
                        Text("Low: ${WeeklyForecast.currentLow}°C")
                    }
                    Row() {
                        Image(
                            painter = painterResource(id = R.drawable.rainy),
                            contentDescription = "Weather",
                            modifier = Modifier.size(20.dp)
                        )
                        Text("${WeeklyForecast.chanceOfRain}%")
                    }
                    Row() {
                        Image(
                            painter = painterResource(id = R.drawable.rainy),
                            contentDescription = "Weather",
                            modifier = Modifier.size(20.dp)
                        )
                        Text("${WeeklyForecast.amountOfRain}mm")
                    }
                }

            }

        }
    }


}