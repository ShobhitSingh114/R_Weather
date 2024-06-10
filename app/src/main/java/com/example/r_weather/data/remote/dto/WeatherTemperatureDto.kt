package com.example.r_weather.data.remote.dto

import com.example.r_weather.domain.model.WeatherTemperature

data class WeatherTemperatureDto(
    val base: String,
    val clouds: Clouds,
    val cod: Int,
    val coord: Coord,
    val dt: Int,
    val id: Int,
    val main: Main,
    val name: String,
    val rain: Rain,
    val sys: Sys,
    val timezone: Int,
    val visibility: Int,
    val weather: List<Weather>,
    val wind: Wind
)

fun WeatherTemperatureDto.toWeatherTemperature(): WeatherTemperature {
    return WeatherTemperature(
        temperature = main.temp,
        minTemperature = main.temp_min,
        maxTemperature = main.temp_max,
        humidity = main.humidity,
        windSpeed = wind.speed,
        weatherType = weather.map { it.main }.toString()
    )
}
