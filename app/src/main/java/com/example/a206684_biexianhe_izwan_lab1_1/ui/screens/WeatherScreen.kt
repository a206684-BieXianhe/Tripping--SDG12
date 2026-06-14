package com.example.a206684_biexianhe_izwan_lab1_1.ui.screens

import android.content.Context
import android.content.Intent
import kotlinx.coroutines.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.a206684_biexianhe_izwan_lab1_1.R
import com.example.a206684_biexianhe_izwan_lab1_1.ui.components.FunctionHeader
import com.example.a206684_biexianhe_izwan_lab1_1.ui.data.RetrofitInstance

@Composable
fun WeatherScreen(
    navController: NavController,
    lat: String = "",
    lng: String = ""
) {

    var temperature by remember { mutableStateOf("--") }
    var condition by remember { mutableStateOf("--") }
    var loading by remember { mutableStateOf(false) }
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        FunctionHeader(
            title = "Weather Screen",
            imageRes = R.drawable.function1
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text("Latitude: $lat")
        Text("Longitude: $lng")

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                loading = true

                getWeather(lat, lng) { temp, cond ->
                    temperature = temp
                    condition = cond
                    loading = false
                }
            }
        ) {
            Text(if (loading) "Loading..." else "Get Weather")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Temperature: $temperature")
        Text("Condition: $condition")

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {

                val text =
                    "Weather Report\n" +
                            "Temp: $temperature°C\n" +
                            "Condition: $condition"

                shareWeather(context, text)

            }
        ) {
            Text("Share Weather")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                navController.navigate("location_screen")
            }
        ) {
            Text("Back to Location")
        }
    }
}

fun getWeather(
    lat: String,
    lng: String,
    onResult: (String, String) -> Unit
) {
    CoroutineScope(
        Dispatchers.IO
    ).launch {

        try {
            val result =
                RetrofitInstance
                    .api
                    .getWeather(
                        lat =
                            if (
                                lat.isBlank()
                            )
                                "3.1390"
                            else
                                lat,
                        lon =
                            if (
                                lng.isBlank()
                            )
                                "101.6869"
                            else
                                lng,
                        apiKey =
                            "d335bb745a7314a7d9eefbff329a1a5a"
                    )

            withContext(
                Dispatchers.Main
            ) {

                onResult(
                    result
                        .main
                        .temp
                        .toString(),
                    result
                        .weather
                        .first()
                        .main
                )
            }
        }

        catch (
            e: Exception
        ) {
            withContext(
                Dispatchers.Main
            ) {

                onResult(
                    "Error",
                    "Failed"
                )
            }
        }
    }
}

fun shareWeather(
    context: Context,
    text: String
) {

    val intent =
        Intent(
            Intent.ACTION_SEND
        ).apply {

            type =
                "text/plain"

            putExtra(
                Intent.EXTRA_TEXT,
                text
            )

        }

    context.startActivity(
        Intent.createChooser(
            intent,
            "Share Weather"
        )
    )

}