package com.example.a206684_biexianhe_izwan_lab1_1.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.a206684_biexianhe_izwan_lab1_1.ui.components.FunctionHeader
import com.example.a206684_biexianhe_izwan_lab1_1.ui.viewmodel.HotelViewModel
import com.example.a206684_biexianhe_izwan_lab1_1.R

@Composable
fun HotelScreen(
    navController: NavController,
    viewModel: HotelViewModel
) {

    Column(modifier = Modifier.fillMaxSize()) {

        FunctionHeader(
            title = "Hotels",
            imageRes = R.drawable.function1
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text("Room Type")

        Row {
            listOf("Standard", "Deluxe", "Suite").forEach { type ->
                Button(onClick = { viewModel.hotelRoomType = type }) {
                    Text(type)
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = viewModel.hotelNights,
            onValueChange = { viewModel.hotelNights = it },
            label = { Text("Nights") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = viewModel.hotelRooms,
            onValueChange = { viewModel.hotelRooms = it },
            label = { Text("Rooms") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                navController.navigate("hotel_summary_screen")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Search")
        }
    }
}