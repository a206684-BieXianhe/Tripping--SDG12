package com.example.a206684_biexianhe_izwan_lab1_1.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.a206684_biexianhe_izwan_lab1_1.R
import com.example.a206684_biexianhe_izwan_lab1_1.ui.components.FunctionHeader
import com.example.a206684_biexianhe_izwan_lab1_1.ui.viewmodel.FlightViewModel
import androidx.compose.runtime.collectAsState

@Composable
fun FlightSummaryScreen(
    navController: NavController,
    viewModel: FlightViewModel
) {

    val uiState = viewModel.flightUiState.collectAsState().value

    Column(modifier = Modifier.fillMaxSize()) {

        FunctionHeader(
            title = "Flights",
            imageRes = R.drawable.function1
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Flight Summary",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(16.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        // 卡片显示内容
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {


                Text("Trip Type: ${uiState.flightDetails.tripType}")
                Spacer(modifier = Modifier.height(8.dp))

                Text("From: ${uiState.flightDetails.fromLocation}")
                Spacer(modifier = Modifier.height(8.dp))

                Text("To: ${uiState.flightDetails.toLocation}")
                Spacer(modifier = Modifier.height(8.dp))

                Text("Passengers: ${uiState.flightDetails.passengers}")

                Spacer(modifier = Modifier.height(20.dp))


                Button(
                    onClick = {
                        navController.navigate("flight_screen")
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Back")
                }

                Spacer(modifier = Modifier.height(8.dp))


                Button(
                    onClick = {
                        navController.navigate("flight_history_screen")
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Flight History")
                }
            }
        }
    }
}