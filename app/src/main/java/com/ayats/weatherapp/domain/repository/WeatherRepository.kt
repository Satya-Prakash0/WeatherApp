package com.ayats.weatherapp.domain.repository

import com.ayats.weatherapp.domain.util.Resource
import com.ayats.weatherapp.domain.weather.WeatherInfo

interface WeatherRepository {

    suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo>

}