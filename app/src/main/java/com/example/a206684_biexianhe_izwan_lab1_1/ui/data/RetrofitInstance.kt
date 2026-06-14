package com.example.a206684_biexianhe_izwan_lab1_1.ui.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private const val BASE_URL =
        "https://api.openweathermap.org/"

    val api: WeatherApi by lazy {

        Retrofit.Builder()

            .baseUrl(BASE_URL)

            .addConverterFactory(
                GsonConverterFactory.create()
            )

            .build()

            .create(
                WeatherApi::class.java
            )

    }

}