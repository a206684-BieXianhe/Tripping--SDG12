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
import com.example.a206684_biexianhe_izwan_lab1_1.R
import com.example.a206684_biexianhe_izwan_lab1_1.ui.components.FunctionHeader
import com.example.a206684_biexianhe_izwan_lab1_1.ui.viewmodel.FlightViewModel

@Composable
fun FlightScreen(
    navController: NavController,
    viewModel: FlightViewModel
) {

    Column(modifier = Modifier.fillMaxSize()) {

        // Header
        FunctionHeader(
            title = "Flights",
            imageRes = R.drawable.function1
        )

        Spacer(modifier = Modifier.height(16.dp))

        // TripType
        Text("Trip Type")

        Row {
            listOf("One-way", "Return", "Multi-city").forEach { type ->
                Button(onClick = { viewModel.flightTripType = type }) {
                    Text(type)
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // From
        OutlinedTextField(
            value = viewModel.flightFrom,
            onValueChange = { viewModel.flightFrom = it },
            label = { Text("From") },
            placeholder = { Text("Departure Station") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // To
        OutlinedTextField(
            value = viewModel.flightTo,
            onValueChange = { viewModel.flightTo = it },
            label = { Text("To") },
            placeholder = { Text("Arrival Station") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Passengers
        OutlinedTextField(
            value = viewModel.flightPassengers,
            onValueChange = { viewModel.flightPassengers = it },
            label = { Text("Passengers") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Search
        Button(
            onClick = {
                navController.navigate("flight_summary_screen")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Search")
        }
    }
}