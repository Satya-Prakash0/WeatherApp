package com.ayats.weatherapp.presentation.Components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ayats.weatherapp.R
import com.ayats.weatherapp.presentation.ui.WeatherState
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun WeatherCard(
    state: WeatherState,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    state.weatherInfo?.currentWeatherData?.let { data ->
        OutlinedCard(
            shape = RoundedCornerShape(8.dp),
            modifier = modifier
                .background(color = backgroundColor)
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Today ${
                        data.time.format(
                            DateTimeFormatter.ofPattern("HH:mm")
                        )
                    }",
                    modifier = Modifier.align(Alignment.End),
                    color = Color.White
                )

                Spacer(modifier.height(16.dp))

                Image(
                    painter = painterResource(id = data.weatherType.iconRes),
                    contentDescription = "",
                    modifier = Modifier.width(200.dp)
                )

                Spacer(modifier.height(16.dp))

                Text(
                    text = data.temperatureCelsius.toString() + "°C",
                    fontSize = 50.sp,
                    color = Color.White
                )

                Spacer(modifier.height(16.dp))

                Text(
                    text = data.weatherType.weatherDesc,
                    fontSize = 20.sp,
                    color = Color.White
                )
                Spacer(modifier.height(32.dp))

                Row(
                    modifier = modifier.fillMaxWidth().padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    WeatherDataDisplay(
                        value = data.pressure.toInt(),
                        unit = "hpa",
                        img = R.drawable.ic_pressure,
                    )
                    WeatherDataDisplay(
                        value = data.humidity.toInt(),
                        unit = "%",
                        img = R.drawable.ic_drop,
                    )
                    WeatherDataDisplay(
                        value = data.windSpeed.toInt(),
                        unit = "km/h",
                        img = R.drawable.ic_wind,
                    )
                }
            }
        }
    }

}

@Composable
fun WeatherDataDisplay(
    value: Int,
    unit: String,
    img: Int
) {
    Image(
        painter = painterResource(id= img),
        contentDescription = "",
        colorFilter = ColorFilter.tint(color = Color.White),
        modifier = Modifier.width(30.dp)
    )
    Spacer(modifier = Modifier.width(4.dp))

    Text(
        text = "$value$unit",
        color = Color.White
    )

}