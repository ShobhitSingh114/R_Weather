package com.example.r_weather.domain.model

data class WeatherTemperature(
    val temperature: Double,
    val minTemperature: Double,
    val maxTemperature: Double,
    val humidity: Int,
    val windSpeed: Double,
    val weatherType: String
)
