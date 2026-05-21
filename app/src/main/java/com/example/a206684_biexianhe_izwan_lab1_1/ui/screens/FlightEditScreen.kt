package com.example.a206684_biexianhe_izwan_lab1_1.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.a206684_biexianhe_izwan_lab1_1.R
import com.example.a206684_biexianhe_izwan_lab1_1.ui.components.FunctionHeader
import com.example.a206684_biexianhe_izwan_lab1_1.ui.viewmodel.FlightViewModel
import kotlinx.coroutines.launch

@Composable
fun FlightEditScreen(
    navController: NavController,
    viewModel: FlightViewModel,
    flightId: Int
) {
    val uiState = viewModel.flightUiState.collectAsState().value
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(flightId) {
        viewModel.loadFlight(flightId)
    }

    Column(modifier = Modifier.fillMaxSize()) {
        FunctionHeader(
            title = "Edit Flight",
            imageRes = R.drawable.function1
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Trip Type
        Text("Trip Type")
        Row {
            listOf("One-way", "Return", "Multi-city").forEach { type ->
                Button(onClick = {
                    viewModel.updateFlightDetails(
                        uiState.flightDetails.copy(tripType = type)
                    )
                }) {
                    Text(type)
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = uiState.flightDetails.fromLocation,
            onValueChange = {
                viewModel.updateFlightDetails(uiState.flightDetails.copy(fromLocation = it))
            },
            label = { Text("From") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = uiState.flightDetails.toLocation,
            onValueChange = {
                viewModel.updateFlightDetails(uiState.flightDetails.copy(toLocation = it))
            },
            label = { Text("To") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = uiState.flightDetails.passengers,
            onValueChange = {
                viewModel.updateFlightDetails(uiState.flightDetails.copy(passengers = it))
            },
            label = { Text("Passengers") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = {
                coroutineScope.launch {
                    viewModel.updateFlight()
                    navController.navigate("flight_history_screen")
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