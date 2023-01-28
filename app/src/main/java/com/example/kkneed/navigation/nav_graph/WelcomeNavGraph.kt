package com.example.kkneed.navigation.nav_graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.kkneed.navigation.AllScreen
import com.example.kkneed.navigation.WELCOME_ROUTE
import com.example.kkneed.screen.GuideScreen
import com.example.kkneed.screen.WelcomeScreen

fun NavGraphBuilder.WelcomeNavGraph(navController: NavController) {
    navigation(
        startDestination = AllScreen.Welcome.route,
        route = WELCOME_ROUTE,
    ) {
        composable(AllScreen.Welcome.route) {
            WelcomeScreen(navController)
        }
        composable(AllScreen.Guide.route) {
            GuideScreen(navController)
        }
    }
}