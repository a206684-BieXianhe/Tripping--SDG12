package com.example.a206684_biexianhe_izwan_lab1_1.ui.data

data class WeatherResponse(

    val main: Main,

    val weather: List<Weather>

)

data class Main(

    val temp: Double

)

data class Weather(

    val main: String

)