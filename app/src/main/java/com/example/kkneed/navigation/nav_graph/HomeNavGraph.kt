package com.example.kkneed.navigation.nav_graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.kkneed.screen.HomeScreen
import com.example.kkneed.navigation.AllScreen
import com.example.kkneed.navigation.HOME_ROUTE
import com.example.kkneed.screen.home.*


fun NavGraphBuilder.HomeNavGraph(navController: NavController){
    navigation(
        startDestination = AllScreen.Home.route,
        route = HOME_ROUTE,
    ){
        composable(AllScreen.Home.route){
            HomeScreen(navController)
        }
        composable(AllScreen.Community.route){
            CommunityScreen(navController)
        }
        composable(AllScreen.EditNote.route){
            EditNoteScreen(navController)
        }
        composable(AllScreen.SearchCommunity.route){
            SearchCommunityScreen(navController)
        }
        composable(AllScreen.NoteDetail.route){
            NoteDetailScreen(navController)
        }
        composable(AllScreen.Day.route){
            DayScreen(navController)
        }
    }
}