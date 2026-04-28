package com.example.a206684_biexianhe_izwan_lab1_1.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.a206684_biexianhe_izwan_lab1_1.HomeScreen
import com.example.a206684_biexianhe_izwan_lab1_1.ui.screens.FlightScreen
import com.example.a206684_biexianhe_izwan_lab1_1.ui.screens.FlightSummaryScreen
import com.example.a206684_biexianhe_izwan_lab1_1.ui.screens.HotelScreen
import com.example.a206684_biexianhe_izwan_lab1_1.ui.screens.HotelSummaryScreen
import com.example.a206684_biexianhe_izwan_lab1_1.ui.screens.TrainScreen
import com.example.a206684_biexianhe_izwan_lab1_1.ui.screens.TrainSummaryScreen
import com.example.a206684_biexianhe_izwan_lab1_1.ui.viewmodel.FlightViewModel
import com.example.a206684_biexianhe_izwan_lab1_1.ui.viewmodel.HotelViewModel
import com.example.a206684_biexianhe_izwan_lab1_1.ui.viewmodel.TrainViewModel


@Composable
fun AppNavigation(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {

    val flightViewModel: FlightViewModel = viewModel()
    val hotelViewModel: HotelViewModel = viewModel()
    val trainViewModel: TrainViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = "home_screen",
        modifier = modifier
    ) {

        composable("home_screen") {
            HomeScreen(navController)
        }

        composable("flight_screen") {
            FlightScreen(navController, flightViewModel)
        }

        composable("flight_summary_screen") {
            FlightSummaryScreen(navController, flightViewModel)
        }

        composable("hotel_screen") {
            HotelScreen(navController, hotelViewModel)
        }

        composable("hotel_summary_screen") {
            HotelSummaryScreen(navController, hotelViewModel)
        }

        composable("train_screen") {
            TrainScreen(navController, trainViewModel)
        }

        composable("train_summary_screen") {
            TrainSummaryScreen(navController, trainViewModel)
        }

    }
}