package com.example.a206684_biexianhe_izwan_lab1_1.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.a206684_biexianhe_izwan_lab1_1.HomeScreen
import com.example.a206684_biexianhe_izwan_lab1_1.ui.screens.*
import com.example.a206684_biexianhe_izwan_lab1_1.ui.data.AppContainer
import com.example.a206684_biexianhe_izwan_lab1_1.ui.viewmodel.*

@Composable
fun AppNavigation(
    navController: NavHostController,
    userViewModel: UserViewModel,
    modifier: Modifier = Modifier
) {

    val context = LocalContext.current.applicationContext
    val container = remember { AppContainer(context) }

    val flightViewModel: FlightViewModel = viewModel(
        factory = FlightViewModelFactory(container.flightRepository)
    )

    val hotelViewModel: HotelViewModel = viewModel()
    val trainViewModel: TrainViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = "home_screen",
        modifier = modifier
    ) {
        composable("home_screen") {
            HomeScreen(
                navController = navController,
                userViewModel = userViewModel
            )
        }

        composable("flight_screen") {
            FlightScreen(navController, flightViewModel)
        }

        composable("flight_summary_screen") {
            FlightSummaryScreen(navController, flightViewModel)
        }

        composable("flight_history_screen") {
            FlightHistoryScreen(navController, flightViewModel)
        }

        composable("flight_edit_screen/{flightId}") { backStackEntry ->
            val flightId = backStackEntry.arguments?.getString("flightId")?.toIntOrNull() ?: 0
            FlightEditScreen(navController, flightViewModel, flightId)
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

        composable("login_screen") {
            LoginScreen(userViewModel = userViewModel)
        }


    }
}