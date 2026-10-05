package com.example.weatherapp.ui.screens


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.transformable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
            amountOfSnow = 0,
            chanceOfSnow = 0,
            wind = 5,
            windDirection = "W",
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
            amountOfSnow = 0,
            chanceOfSnow = 0,
            wind = 5,
            windDirection = "W",
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
            amountOfSnow = 0,
            chanceOfSnow = 0,
            wind = 5,
            windDirection = "W",
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
            amountOfSnow = 0,
            chanceOfSnow = 0,
            wind = 5,
            windDirection = "W",
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
            amountOfSnow = 1,
            chanceOfSnow = 10,
            wind = 5,
            windDirection = "W",
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
            amountOfSnow = 0,
            chanceOfSnow = 0,
            wind = 5,
            windDirection = "W",
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
            amountOfSnow = 0,
            chanceOfSnow = 0,
            wind = 5,
            windDirection = "W",
            resourceId = R.drawable.sun
        )
    )

    // PUT LOCATION IN NAVBAR TOP

    LazyColumn(
        modifier = Modifier
            .background(color = Color.White)
            .padding(20.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(forecastList) { ForecastCard ->

            Row(horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp)
                    .clip(RoundedCornerShape((10.dp)))
                    .background(color = LightBlue40)
                    .padding(vertical = 10.dp)) {



                Column(modifier = Modifier.padding(1.dp).weight(1.5f),
                    horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                    Text(ForecastCard.day,
                        color = Color.White)


                    Row(verticalAlignment = Alignment.CenterVertically) {

                        Image(
                            painter = painterResource(id = ForecastCard.resourceId),
                            contentDescription = "Weather",
                            modifier = Modifier
                                .size(100.dp)
                                .padding(10.dp)
                        )


                        Text("${ForecastCard.currentTemperature}°C", fontWeight = FontWeight.Bold,
                            fontSize = 30.sp, color = Color.White)

                    }

                }

//                Column(modifier = Modifier.fillMaxHeight().weight(1f), verticalArrangement = Arrangement.Center,
//                    horizontalAlignment = Alignment.CenterHorizontally) {
//
//                    Text("${ForecastCard.currentTemperature}°C", fontWeight = FontWeight.Bold,
//                        fontSize = 25.sp, color = Color.White)
//
//                }

                // maybe separate rows into columns too
                Column(modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.Start) {
                    Row() {
                        Text("High: ${ForecastCard.currentHigh}°C"
                            , color = Color.White,
                            fontSize = 15.sp)
                    }
                    Row() {
                        Text("Low: ${ForecastCard.currentLow}°C"
                            , color = Color.White, fontSize = 15.sp
                          )
                    }
                    Row() {
                        Image(
                            painter = painterResource(id = R.drawable.rainy),
                            contentDescription = "Weather",
                            modifier = Modifier.padding(end = 5.dp)
                                .size(20.dp)
                        )

                        if (ForecastCard.chanceOfRain != 0) {
                            Text("${ForecastCard.chanceOfRain}% - ${ForecastCard.amountOfRain}mm",
                                color = Color.White,fontSize = 15.sp)
                        } else {
                            Text("0%",
                                color = Color.White, fontSize = 15.sp)
                        }

                    }
                    Row() {
                        if (ForecastCard.chanceOfSnow != 0) {
                            Image(
                                painter = painterResource(id = R.drawable.snowy),
                                contentDescription = "Weather",
                                modifier = Modifier.padding(end = 5.dp).size(20.dp)
                            )
                            Text("${ForecastCard.chanceOfSnow}% - ${ForecastCard.amountOfSnow}cm",
                                color = Color.White, fontSize = 15.sp)
                        } else {

                        }
                    }
                    Row() {
                        Text("Wind: ${ForecastCard.wind}km/h ${ForecastCard.windDirection}"
                            , color = Color.White)
                    }


                }

            }

        }
    }


}