package com.ayats.weatherapp.data.remote

import com.squareup.moshi.Json

data class WeatherDto(
    @field:Json(name = "hourly")
    val weatherDto: WeatherDataDto
)
