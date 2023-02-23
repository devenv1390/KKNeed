package com.example.kkneed.navigation.nav_graph

import android.app.appsearch.SearchResult
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.kkneed.screen.ShopScreen
import com.example.kkneed.navigation.AllScreen
import com.example.kkneed.navigation.SHOP_ROUTE
import com.example.kkneed.screen.shop.*

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
        composable(AllScreen.SearchResult.route){
            SearchResultScreen(navController)
        }
        composable(AllScreen.ADEdit.route){
            ADEditScreen(navController)
        }
        composable(AllScreen.Confirm.route){
            ConfirmScreen(navController)
        }
        composable(AllScreen.ADList.route){
            ADListScreen(navController)
        }
        composable(AllScreen.Health.route){
            HealthScreen(navController)
        }
        composable(AllScreen.Service.route){
            ServiceScreen(navController)
        }
        composable(AllScreen.ShopDetail.route){
            ShopDetailScreen(navController)
        }
        composable(AllScreen.ShoppingCart.route){
            ShoppingCartScreen(navController)
        }
    }
}