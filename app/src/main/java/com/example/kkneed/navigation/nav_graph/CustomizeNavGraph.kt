package com.example.kkneed.navigation.nav_graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.kkneed.navigation.AllScreen
import com.example.kkneed.navigation.CUSTOMIZE_ROUTE
import com.example.kkneed.screen.customize.CustomizeScreen
import com.example.kkneed.screen.profile.ProfileScreen

fun NavGraphBuilder.CustomizeNavGraph(navController: NavController) {
    navigation(
        startDestination = AllScreen.Customize.route,
        route = CUSTOMIZE_ROUTE,
    ){
        composable(AllScreen.Customize.route) {
            CustomizeScreen(navController)
        }
    }
}