package com.example.kkneed.navigation.nav_graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.kkneed.screen.personal.PersonalScreen
import com.example.kkneed.navigation.AllScreen
import com.example.kkneed.navigation.PERSONAL_ROUTE

fun NavGraphBuilder.PersonalNavGraph(navController: NavController){
    navigation(
        startDestination = AllScreen.Personal.route,
        route = PERSONAL_ROUTE,
    ){
        composable(AllScreen.Personal.route){
            PersonalScreen(navController)
        }
    }
}