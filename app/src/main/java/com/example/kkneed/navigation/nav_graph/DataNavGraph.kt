package com.example.kkneed.navigation.nav_graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.kkneed.screen.DataScreen
import com.example.kkneed.navigation.AllScreen
import com.example.kkneed.navigation.DATA_ROUTE

fun NavGraphBuilder.DataNavGraph(navController: NavController){
    navigation(
        startDestination = AllScreen.Data.route,
        route = DATA_ROUTE,
    ){
        composable(AllScreen.Data.route){
            DataScreen(navController)
        }
    }
}