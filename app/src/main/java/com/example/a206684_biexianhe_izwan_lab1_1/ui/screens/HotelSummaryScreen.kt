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
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.a206684_biexianhe_izwan_lab1_1.ui.components.FunctionHeader
import com.example.a206684_biexianhe_izwan_lab1_1.ui.viewmodel.HotelViewModel
import com.example.a206684_biexianhe_izwan_lab1_1.R

@Composable
fun HotelSummaryScreen(
    navController: NavController,
    viewModel: HotelViewModel
) {
    val uiState = viewModel.hotelUiState.collectAsState().value

    Column(modifier = Modifier.fillMaxSize()) {

        FunctionHeader(
            title = "Hotels",
            imageRes = R.drawable.function1
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Hotel Summary",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(16.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {

                Text("Room Type: ${uiState.hotelDetails.roomType}")
                Spacer(modifier = Modifier.height(8.dp))

                Text("Nights: ${uiState.hotelDetails.nights}")
                Spacer(modifier = Modifier.height(8.dp))

                Text("Rooms: ${uiState.hotelDetails.rooms}")

                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    onClick = {
                        navController.navigate("hotel_screen")
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Back")
                }

                Spacer(modifier = Modifier.height(8.dp))

                Button(
                    onClick = {
                        navController.navigate("hotel_history_screen")
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Hotel History")
                }
            }
        }
    }
}