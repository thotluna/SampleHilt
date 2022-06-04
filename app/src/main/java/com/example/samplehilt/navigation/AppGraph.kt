package com.example.samplehilt.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.samplehilt.first_example.FirstExample
import com.example.samplehilt.home.HomeScreen
import com.example.samplehilt.second_example.presentation.SecondExample
import com.example.samplehilt.third_example.presentation.ThirdCap

@Composable
fun AppGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = DestinationScreen.HomeScreen.route,
        modifier = Modifier
            .then(modifier)
    ) {
        composable(DestinationScreen.HomeScreen.route) {
            HomeScreen(
                onClick = {
                    navController.navigate(it)
                }
            )
        }
        composable(DestinationScreen.FirstExample.route) { FirstExample() }
        composable(DestinationScreen.SecondExample.route) { SecondExample() }
        composable(DestinationScreen.ThirdExample.route) { ThirdCap() }

    }
}

sealed class DestinationScreen(val route: String){
    object HomeScreen : DestinationScreen("home_screen")
    object FirstExample: DestinationScreen(route = "first_example")
    object SecondExample: DestinationScreen(route = "second_example")
    object ThirdExample: DestinationScreen(route = "third_example")
}