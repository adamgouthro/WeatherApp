package com.example.weatherapp.ui.screens



import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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
        items(forecastList) { forecastCard ->

            Row( // this row is one card
                modifier = Modifier
                    .fillMaxWidth()
//                    .height(175.dp)
                    .padding(vertical = 10.dp)
                    .clip(RoundedCornerShape((10.dp)))
                    .background(color = LightBlue40)
                    .padding(vertical = 10.dp),
                verticalAlignment = Alignment.CenterVertically
                )

            {

                Column(horizontalAlignment = Alignment.Start, modifier = Modifier.weight(0.5f))
                {

                    Image(
                        painter = painterResource(id = forecastCard.resourceId),
                        contentDescription = "Weather",
                        modifier = Modifier
                            .size(75.dp)
                            .padding(10.dp)
                    )

                }


                Column(horizontalAlignment = Alignment.Start, modifier = Modifier.weight(1f)) {

                        Text(
                            forecastCard.day,
                            color = Color.White,
                            fontSize = 20.sp
                        )

                        Text(
                            "${forecastCard.currentTemperature}°C", fontWeight = FontWeight.Bold,
                            fontSize = 30.sp, color = Color.White
                        )

                    }


                Column(

                    horizontalAlignment = Alignment.Start, modifier = Modifier.weight(1.25f),
                    verticalArrangement = Arrangement.Center) {

                    Row {
                        Text("High: ${forecastCard.currentHigh}°C"
                            , color = Color.White,
                            fontSize = 15.sp)
                    }

                    Row {


                        Text("Low: ${forecastCard.currentLow}°C"
                            , color = Color.White, fontSize = 15.sp
                        )
                    }

                    Row {
                        if (forecastCard.chanceOfRain != 0) {
                            Image(
                                painter = painterResource(id = R.drawable.rainy),
                                contentDescription = "Weather",
                                modifier = Modifier
                                    .padding(end = 5.dp)
                                    .size(20.dp)
                            )
                            Text("${forecastCard.chanceOfRain}% - ${forecastCard.amountOfRain}mm",
                                color = Color.White,fontSize = 15.sp)
                        }
                    }

                    Row {
                        if (forecastCard.chanceOfSnow != 0) {
                            Image(
                                painter = painterResource(id = R.drawable.snowflake),
                                contentDescription = "Weather",
                                modifier = Modifier
                                    .padding(end = 5.dp)
                                    .size(20.dp)
                            )
                            Text("${forecastCard.chanceOfSnow}% - ${forecastCard.amountOfSnow}cm",
                                color = Color.White, fontSize = 15.sp)
                        }
                    }

                    Row {

                        Image(
                            painter = painterResource(id = R.drawable.windycolor),
                            contentDescription = "Weather",
                            modifier = Modifier
                                .padding(end = 5.dp)
                                .size(20.dp)
                        )

                        Text("Wind: ${forecastCard.wind}km/h ${forecastCard.windDirection}"
                            , color = Color.White)
                    }

                }




                }

            }

        }
    }

