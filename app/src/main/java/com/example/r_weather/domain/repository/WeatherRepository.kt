package com.example.r_weather.domain.repository

import com.example.r_weather.data.remote.dto.WeatherTemperatureDto

interface WeatherRepository {
    suspend fun getWeatherTemperature(
        lat: Double,
        lon: Double
    ): WeatherTemperatureDto
}