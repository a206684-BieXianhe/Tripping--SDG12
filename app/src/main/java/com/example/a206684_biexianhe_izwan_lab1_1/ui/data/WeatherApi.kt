package com.example.a206684_biexianhe_izwan_lab1_1.ui.data

import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("data/2.5/weather")

    suspend fun getWeather(

        @Query("lat")
        lat: String,

        @Query("lon")
        lon: String,

        @Query("appid")
        apiKey: String,

        @Query("units")
        units: String = "metric"

    ): WeatherResponse

}