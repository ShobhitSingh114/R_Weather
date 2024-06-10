package com.example.r_weather.domain.use_case

import com.example.r_weather.commons.Resource
import com.example.r_weather.data.remote.dto.Weather
import com.example.r_weather.data.remote.dto.toWeatherTemperature
import com.example.r_weather.domain.model.WeatherTemperature
import com.example.r_weather.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetWeatherTemperature @Inject constructor(
    private val weatherRepository: WeatherRepository
) {
    operator fun invoke(lat: Double, lon: Double): Flow<Resource<WeatherTemperature>> = flow {
        try {
            emit(Resource.Loading())
            val weatherTemperature = weatherRepository.getWeatherTemperature(lat, lon).toWeatherTemperature()
            emit(Resource.Success(data = weatherTemperature))
        }
        catch (e: HttpException) {
            emit(
                Resource.Error(
                    message = e.localizedMessage ?: "An Unexpected Error Occurred"
                )
            )
        }
        catch (e: IOException) {
            emit(Resource.Error(message = "Couldn't reach server. Check your Internet Connection"))
        }
    }
}