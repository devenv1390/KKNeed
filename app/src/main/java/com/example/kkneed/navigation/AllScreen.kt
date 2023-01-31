package com.example.kkneed.navigation


const val WELCOME_ROUTE = "welcome"
const val HOME_ROUTE = "home"
const val SHOP_ROUTE = "shop"
const val DATA_ROUTE = "data"
const val PROFILE_ROUTE = "profile"
const val ROOT_ROUTE = "root"
sealed class AllScreen(val route: String){
    object Welcome:AllScreen("welcome_screen")
    object Guide:AllScreen("guide_screen")
    object Home:AllScreen("home_screen")
    object Shop:AllScreen("shop_screen")
    object Data:AllScreen("data_screen")
    object Profile:AllScreen("profile_screen")
    object Main:AllScreen("main_screen")
    object History:AllScreen("history_screen")
    object Order:AllScreen("order_screen")
}