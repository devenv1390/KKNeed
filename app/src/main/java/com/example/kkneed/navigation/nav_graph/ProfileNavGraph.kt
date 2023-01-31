package com.example.kkneed.navigation.nav_graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.kkneed.navigation.AllScreen
import com.example.kkneed.navigation.PROFILE_ROUTE
import com.example.kkneed.screen.profile.HistoryScreen
import com.example.kkneed.screen.profile.ProfileScreen

fun NavGraphBuilder.ProfileNavGraph(navController: NavController) {
    navigation(
        startDestination = AllScreen.Profile.route,
        route = PROFILE_ROUTE,
    ) {
        composable(AllScreen.Profile.route) {
            ProfileScreen(navController)
        }
        composable(AllScreen.History.route){
            HistoryScreen(navController)
        }
    }
}