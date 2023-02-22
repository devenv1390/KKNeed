package com.example.kkneed.navigation.nav_graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.kkneed.screen.ShopScreen
import com.example.kkneed.navigation.AllScreen
import com.example.kkneed.navigation.SHOP_ROUTE
import com.example.kkneed.screen.shop.SearchScreen

fun NavGraphBuilder.ShopNavGraph(navController: NavController){
    navigation(
        startDestination = AllScreen.Shop.route,
        route = SHOP_ROUTE,
    ){
        composable(AllScreen.Shop.route){
            ShopScreen(navController)
        }
        composable(AllScreen.Search.route){
            SearchScreen(navController)
        }
    }
}