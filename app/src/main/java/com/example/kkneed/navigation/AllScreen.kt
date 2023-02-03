package com.example.kkneed.navigation


const val WELCOME_ROUTE = "welcome"
const val HOME_ROUTE = "home"
const val SHOP_ROUTE = "shop"
const val DATA_ROUTE = "data"
const val PROFILE_ROUTE = "profile"
const val ROOT_ROUTE = "root"
const val LOGIN_ROUTE = "login"
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
    object Record:AllScreen("record_screen")
    object Watch:AllScreen("watch_screen")
    object Fan:AllScreen("fan_screen")
    object SignUp:AllScreen("signup_screen")
    object SignIn:AllScreen("signin_screen")
    object SignInfo:AllScreen("signinfo_screen")
    object Label:AllScreen("label_screen")
    object Success:AllScreen("label_screen")
}