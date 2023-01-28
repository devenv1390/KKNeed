package com.example.kkneed.navigation


const val WELCOME_ROUTE = "welcome"
const val HOME_ROUTE = "home"
const val SHOP_ROUTE = "shop"
const val DATA_ROUTE = "data"
const val PERSONAL_ROUTE = "personal"
const val ROOT_ROUTE = "root"
sealed class AllScreen(val route: String){
    object Welcome:AllScreen("welcome_screen")
    object Guide:AllScreen("guide_screen")
    object Home:AllScreen("home_screen")
    object Shop:AllScreen("shop_screen")
    object Data:AllScreen("data_screen")
    object Personal:AllScreen("personal_screen")

    object Main:AllScreen("main_screen")
}