package com.example.a206684_biexianhe_izwan_lab1_1.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.a206684_biexianhe_izwan_lab1_1.R
import com.example.a206684_biexianhe_izwan_lab1_1.ui.components.FunctionHeader
import com.example.a206684_biexianhe_izwan_lab1_1.ui.viewmodel.HotelViewModel
import kotlinx.coroutines.launch

@Composable
fun HotelEditScreen(
    navController: NavController,
    viewModel: HotelViewModel,
    hotelId: Int
) {
    val uiState = viewModel.hotelUiState.collectAsState().value
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(hotelId) {
        viewModel.loadHotel(hotelId)
    }

    Column(modifier = Modifier.fillMaxSize()) {
        FunctionHeader(
            title = "Edit Hotel",
            imageRes = R.drawable.function1
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Room Type
        Text("Room Type")
        Row {
            listOf("Standard", "Deluxe", "Suite").forEach { type ->
                Button(onClick = {
                    viewModel.updateHotelDetails(
                        uiState.hotelDetails.copy(roomType = type)
                    )
                }) {
                    Text(type)
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = uiState.hotelDetails.nights,
            onValueChange = {
                viewModel.updateHotelDetails(uiState.hotelDetails.copy(nights = it))
            },
            label = { Text("Nights") },
            placeholder = { Text("Number of Nights") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = uiState.hotelDetails.rooms,
            onValueChange = {
                viewModel.updateHotelDetails(uiState.hotelDetails.copy(rooms = it))
            },
            label = { Text("Rooms") },
            placeholder = { Text("Number of Rooms") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = {
                coroutineScope.launch {
                    viewModel.updateHotel()
                    navController.navigate("hotel_history_screen")
                }
            },
            enabled = uiState.isInputValid,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Text("Save Changes")
        }
    }
}