package com.example.r_weather.data.remote.dto

data class Weather(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)