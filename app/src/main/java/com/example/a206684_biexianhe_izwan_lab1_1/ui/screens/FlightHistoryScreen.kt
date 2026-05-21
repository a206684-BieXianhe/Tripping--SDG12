package com.example.a206684_biexianhe_izwan_lab1_1.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.a206684_biexianhe_izwan_lab1_1.R
import com.example.a206684_biexianhe_izwan_lab1_1.ui.components.FunctionHeader
import com.example.a206684_biexianhe_izwan_lab1_1.ui.data.FlightEntity
import com.example.a206684_biexianhe_izwan_lab1_1.ui.viewmodel.FlightViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.compose.runtime.rememberCoroutineScope

@Composable
fun FlightHistoryScreen(
    navController: NavController,
    viewModel: FlightViewModel
) {
    val allFlights = viewModel.allFlightList.collectAsState(initial = emptyList())
    val coroutineScope = rememberCoroutineScope()

    Column(modifier = Modifier.fillMaxSize()) {
        FunctionHeader(
            title = "Flight History",
            imageRes = R.drawable.function1
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Saved Flights",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn(modifier = Modifier.weight(1f)) {
            items(allFlights.value) { flight ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("ID: ${flight.id}")
                        Text("Trip Type: ${flight.tripType}")
                        Text("From: ${flight.fromLocation}")
                        Text("To: ${flight.toLocation}")
                        Text("Passengers: ${flight.passengers}")

                        Spacer(modifier = Modifier.height(8.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End
                        ) {
                            OutlinedButton(
                                onClick = {
                                    coroutineScope.launch {
                                        viewModel.deleteFlight(flight)
                                    }
                                }
                            ) {
                                Text("Delete")
                            }

                            Spacer(modifier = Modifier.width(8.dp))

                            Button(
                                onClick = {
                                    navController.navigate("flight_edit_screen/${flight.id}")
                                }
                            ) {
                                Text("Edit")
                            }
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = { navController.navigate("flight_summary_screen") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Text("Back")
        }
    }
}