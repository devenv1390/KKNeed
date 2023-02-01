package com.example.kkneed.navigation.nav_graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.kkneed.navigation.AllScreen
import com.example.kkneed.navigation.PROFILE_ROUTE
import com.example.kkneed.screen.profile.*

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
        composable(AllScreen.Order.route){
            OrderScreen(navController)
        }
        composable(AllScreen.Record.route){
            RecordScreen(navController)
        }
        composable(AllScreen.Watch.route){
            WatchScreen(navController)
        }
        composable(AllScreen.Fan.route){
            FanScreen(navController)
        }
    }
}