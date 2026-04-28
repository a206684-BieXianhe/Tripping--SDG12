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
import com.example.a206684_biexianhe_izwan_lab1_1.ui.viewmodel.TrainViewModel
import com.example.a206684_biexianhe_izwan_lab1_1.R

@Composable
fun TrainScreen(
    navController: NavController,
    viewModel: TrainViewModel
) {

    Column(modifier = Modifier.fillMaxSize()) {

        FunctionHeader(
            title = "Trains",
            imageRes = R.drawable.function1
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text("Transport Type")

        Row {
            listOf("Train", "Bus", "Pass").forEach { type ->
                Button(onClick = { viewModel.trainTransportType = type }) {
                    Text(type)
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = viewModel.trainFrom,
            onValueChange = { viewModel.trainFrom = it },
            label = { Text("From") },
            placeholder = { Text("Departure Station") }
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = viewModel.trainTo,
            onValueChange = { viewModel.trainTo = it },
            label = { Text("To") },
            placeholder = { Text("Arrival Station") }
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = viewModel.trainPassengers,
            onValueChange = { viewModel.trainPassengers = it },
            label = { Text("Passengers") }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                navController.navigate("train_summary_screen")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Search")
        }
    }
}