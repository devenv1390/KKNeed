package com.example.kkneed.navigation.nav_graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.kkneed.navigation.AllScreen
import com.example.kkneed.navigation.LOGIN_ROUTE
import com.example.kkneed.navigation.PROFILE_ROUTE
import com.example.kkneed.screen.ShopScreen
import com.example.kkneed.screen.login.InfoScreen
import com.example.kkneed.screen.login.LabelScreen
import com.example.kkneed.screen.login.SignInScreen
import com.example.kkneed.screen.login.SignUpScreen

fun NavGraphBuilder.LoginNavGraph(navController: NavController) {
    navigation(
        startDestination = AllScreen.SignUp.route,
        route = LOGIN_ROUTE,
    ){
        composable(AllScreen.SignUp.route){
            SignUpScreen(navController)
        }
        composable(AllScreen.SignIn.route){
            SignInScreen(navController)
        }
        composable(AllScreen.SignIn.route){
            InfoScreen(navController)
        }
        composable(AllScreen.Label.route){
            LabelScreen(navController)
        }
    }
}