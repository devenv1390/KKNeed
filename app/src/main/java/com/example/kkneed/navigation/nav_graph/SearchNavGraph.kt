package com.example.kkneed.navigation.nav_graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.kkneed.navigation.AllScreen
import com.example.kkneed.navigation.SCANNER_ROUTE
import com.example.kkneed.screen.BCScannerScreen

fun NavGraphBuilder.SearchNavGraph(navController: NavController) {
    navigation(
        startDestination = AllScreen.Scanner.route,
        route = SCANNER_ROUTE,
    ) {
        composable(AllScreen.Scanner.route) {
            BCScannerScreen()
        }
    }
}