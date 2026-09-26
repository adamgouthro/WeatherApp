package com.example.weatherapp.models

import androidx.annotation.DrawableRes

data class HourlyWeather(
    val currentTemperature: Int, // the current temp to be displayed
    val feelLike: Int, // feels like temperature
    val location: String, // Temperatures location
    val hour: Int, // the hour for the weather
    val chanceOfRain: Int, // chance of rain happening for today
    val amountOfRain: Int, // amount of rain they/re getting
    @DrawableRes val resourceId: Int // ID for drawable image
)