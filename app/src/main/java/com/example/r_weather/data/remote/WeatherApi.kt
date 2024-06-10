package com.example.r_weather.data.remote

import com.example.r_weather.commons.Constants
import com.example.r_weather.data.remote.dto.WeatherTemperatureDto
import com.example.r_weather.domain.model.WeatherTemperature
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    // https://api.openweathermap.org/
    // data/2.5/weather?lat=28.7041&lon=77.1025&appid=738f34ac41a948e6544b0c821b01d44d

    @GET("data/2.5/weather")
    suspend fun getWeatherTemperature(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("appid") apiKey: String = Constants.API_KEY
    ): WeatherTemperatureDto

}