package com.example.weatherapp.models

import androidx.annotation.DrawableRes

data class WeeklyForecast(
    val currentTemperature: Int, // the current temp to be displayed
    val currentHigh: Int, // the high for the day
    val currentLow: Int, // the low for the day
    val feelLike: Int, // feels like temperature
    val location: String, // Temperatures location
    val day: String, // day of the week
    val chanceOfRain: Int, // chance of rain happening for today
    val amountOfRain: Int, // amount of rain they/re getting
    @DrawableRes val resourceId: Int // ID for drawable image

)