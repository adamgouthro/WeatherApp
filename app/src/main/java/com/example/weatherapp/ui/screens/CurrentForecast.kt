package com.example.weatherapp.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.R
import com.example.weatherapp.models.Weather
import com.example.weatherapp.ui.theme.LightBlue40
import com.example.weatherapp.ui.theme.Purple
import com.example.weatherapp.ui.theme.Purple40
import java.nio.file.WatchEvent

@Composable
fun CurrentForecast()
{

    //data class Weather(
    //    val currentTemperature: Int, // the current temp to be displayed
    //    val currentHigh: Int, // the high for the day
    //    val currentLow: Int, // the low for the day
    //    val feelLike: Int, // feels like temperature
    //    val location: String, // Temperatures location
    //    val chanceOfRain: Int, // chance of rain happening for today
    //    val amountOfRain: Int, // amount of rain they/re getting
    //    @DrawableRes val resourceId: Int // ID for drawable image
    //    )

    // making an object out of my data class Weather
    val currentWeather = Weather(
        currentTemperature = 32,
        resourceId = R.drawable.sun,
        currentHigh = 34,
        currentLow = 28,
        feelLike = 34,
        location = "Halifax, Nova Scotia",
        chanceOfRain = 10,
        amountOfRain = 1,
        chanceOfSnow = 0,
        amountOfSnow = 0,
        wind = 20,
        windDirection = "E",
        uvIndex = "Moderate",
        humidity = 60,
    )

    Column(modifier = Modifier
        .background(color = Color.White)
        .padding(10.dp) // padding around the entire screen
        .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        )
    {

        Row(
            modifier = Modifier.padding(50.dp)
        )
            {
                Image(
                    painter = painterResource(id = currentWeather.resourceId),
                    contentDescription = "Weather"
                )
            }

        // to make transparent for later .copy(alpha = 0.7f) example

            Column(modifier = Modifier.fillMaxWidth()
                .clip(RoundedCornerShape((10.dp)))
                .background(color = LightBlue40)
                .padding(vertical = 30.dp)
                ,
                horizontalAlignment = Alignment.CenterHorizontally,
            )

            {

            Row()
            {
                Text(
                    "${currentWeather.currentTemperature}°C",
                    fontSize = 60.sp,
                    color = Color.White
                )
            }

            Row(modifier = Modifier)
            {
                Text("Feels Like ${currentWeather.feelLike}°C",
                    fontSize = 20.sp,
                    color = Color.White)
            }

        }

        // Row then columns for the high and low temps

        Row(horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier.fillMaxWidth()
            ) {

            Column(modifier = Modifier
                .padding(vertical = 10.dp)
                .padding(end = 5.dp)
                .clip(RoundedCornerShape((10.dp)))
                .background(color = LightBlue40)
                .padding(vertical = 10.dp)
                .weight(1f)
                ,
                horizontalAlignment = Alignment.CenterHorizontally,

            )
            {
                Text("High of ${currentWeather.currentHigh}°C",
                    fontSize = 20.sp,
                    color = Color.White)
            }

            Column(modifier = Modifier
                .padding(vertical = 10.dp)
                .padding(start = 5.dp)
                .clip(RoundedCornerShape((10.dp)))
                .background(color = LightBlue40)
                .padding(vertical = 10.dp)
                .weight(1f)
                ,
                horizontalAlignment = Alignment.CenterHorizontally,
            )
            {
                Text("Low of ${currentWeather.currentLow}°C",
                    fontSize = 20.sp,
                    color = Color.White)
            }
        }

        Row(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .clip(RoundedCornerShape((10.dp)))
            .background(color = LightBlue40)
            .padding(vertical = 10.dp)
            ,
            horizontalArrangement = Arrangement.Absolute.SpaceAround
            )
        {
            Column() {
                Text("Wind: ",
                    fontSize = 20.sp,
                    color = Color.White)

                Text("Humidity: ",
                    fontSize = 20.sp,
                    color = Color.White)

                Text("UV: ",
                    fontSize = 20.sp,
                    color = Color.White)

                Text("Rain: ",
                    fontSize = 20.sp,
                    color = Color.White)

                Text("Snow: ",
                    fontSize = 20.sp,
                    color = Color.White)
            }

            Column() {
                Text("${currentWeather.wind}km/h ${currentWeather.windDirection}",
                    fontSize = 20.sp,
                    color = Color.White)

                Text("${currentWeather.humidity}%",
                    fontSize = 20.sp,
                    color = Color.White)

                Text(currentWeather.uvIndex,
                    fontSize = 20.sp,
                    color = Color.White)

                // if there's a chance of rain it'll display both chance and amount. otherwise just 0%
                if (currentWeather.chanceOfRain != 0) {
                    Text("${currentWeather.chanceOfRain}% - ${currentWeather.amountOfRain}mm",
                        fontSize = 20.sp,
                        color = Color.White)
                } else {
                    Text("0%",
                        fontSize = 20.sp,
                        color = Color.White)
                }

                if (currentWeather.chanceOfSnow != 0) {
                    Text("${currentWeather.chanceOfSnow}% - ${currentWeather.amountOfSnow}cm",
                        fontSize = 20.sp,
                        color = Color.White)
                } else {
                    Text("0%",
                        fontSize = 20.sp,
                        color = Color.White)
                }

            }
        }

    }

}
