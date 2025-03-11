package com.ayats.weatherapp.data.repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.ayats.weatherapp.data.mapper.toWeatherInfo
import com.ayats.weatherapp.data.remote.RemoteApi
import com.ayats.weatherapp.domain.repository.WeatherRepository
import com.ayats.weatherapp.domain.util.Resource
import com.ayats.weatherapp.domain.weather.WeatherInfo
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: RemoteApi
):WeatherRepository {

     @RequiresApi(Build.VERSION_CODES.O)
     override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        return try{
            Resource.Success(
                data = api.getWeatherData(lat, long).toWeatherInfo()
            )
        } catch (e:Exception) {
            e.printStackTrace()
            Resource.Error(message = e.message ?: "An unknown error occurred")
        }
    }

}