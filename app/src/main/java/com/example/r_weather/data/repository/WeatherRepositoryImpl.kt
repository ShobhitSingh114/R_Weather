package com.example.r_weather.data.repository

import com.example.r_weather.data.remote.WeatherApi
import com.example.r_weather.data.remote.dto.WeatherTemperatureDto
import com.example.r_weather.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val weatherApi: WeatherApi
) : WeatherRepository {
    override suspend fun getWeatherTemperature(lat: Double, lon: Double): WeatherTemperatureDto {
        return weatherApi.getWeatherTemperature(lat, lon)
    }
}