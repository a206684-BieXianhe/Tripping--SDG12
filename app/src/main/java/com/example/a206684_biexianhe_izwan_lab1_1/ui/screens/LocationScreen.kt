package com.example.a206684_biexianhe_izwan_lab1_1.ui.screens

import com.google.android.gms.location.Priority
import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import androidx.annotation.RequiresPermission
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
import com.google.android.gms.location.LocationServices

@Composable
fun LocationScreen(navController: NavController,) {

    val context = LocalContext.current

    var latitude by remember { mutableStateOf("Not found") }
    var longitude by remember { mutableStateOf("Not found") }
    var loading by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        FunctionHeader(
            title = "Location (GPS Sensor)",
            imageRes = R.drawable.function1
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "Latitude: $latitude")
        Text(text = "Longitude: $longitude")

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                loading = true

                getLocation(context) { lat, lng ->
                    latitude = lat
                    longitude = lng
                    loading = false
                }
            }
        ) {
            Text(if (loading) "Getting Location..." else "Get Current Location")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                navController.navigate("weather_screen/$latitude/$longitude")
            }
        ) {
            Text("Go to Weather Screen")
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = {
                navController.navigate("login_screen") {
                    popUpTo("login_screen") { inclusive = true }
                }
            }
        ) {
            Text("Back to Login")
        }
    }
}

@SuppressLint("MissingPermission")
fun getLocation(
    context: Context,
    onResult: (String, String) -> Unit
) {
    val client = LocationServices.getFusedLocationProviderClient(context)
    client.lastLocation.addOnSuccessListener { location ->
        if (location != null) {
            onResult(location.latitude.toString(), location.longitude.toString())
        } else {
            client.getCurrentLocation(Priority.PRIORITY_BALANCED_POWER_ACCURACY, null)
                .addOnSuccessListener {
                    if (it != null) {
                        onResult(it.latitude.toString(), it.longitude.toString())
                    } else {
                        onResult("3.1390", "101.6869")
                    }
                }
                .addOnFailureListener {
                    onResult("3.1390", "101.6869")
                }
        }
    }.addOnFailureListener {
        onResult("3.1390", "101.6869")
    }
}