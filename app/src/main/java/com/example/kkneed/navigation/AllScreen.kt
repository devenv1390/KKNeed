package com.example.kkneed.navigation


const val WELCOME_ROUTE = "welcome"
const val HOME_ROUTE = "home"
const val SHOP_ROUTE = "shop"
const val PROFILE_ROUTE = "profile"
const val SCANNER_ROUTE = "scanner"
const val CUSTOMIZE_ROUTE = "customize"
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
    object Record:AllScreen("record_screen")
    object Watch:AllScreen("watch_screen")
    object Fan:AllScreen("fan_screen")
    object SignUp:AllScreen("signup_screen")
    object SignIn:AllScreen("signin_screen")
    object SignInfo:AllScreen("signinfo_screen")
    object Label:AllScreen("label_screen")
    object Success:AllScreen("success_screen")
    object Chip:AllScreen("chip_screen")
    object PersonInfo:AllScreen("personinfo_screen")
    object Scanner:AllScreen("scanner_screen")
    object Comment:AllScreen("comment_screen")
    object Detail:AllScreen("detail_screen")
    object Customize:AllScreen("customize_screen")
    object Compare:AllScreen("compare_screen")
    object Chose:AllScreen("chose_screen")
    object ScanHistory:AllScreen("scanhistory_screen")
    object Edit:AllScreen("edit_screen")
    object EditProduct:AllScreen("editproduct_screen")
    object Collect:AllScreen("collect_screen")
    object RecordDetail:AllScreen("recorddetail_screen")
    object Search:AllScreen("search_screen")
    object Create:AllScreen("create_screen")
    object ScanResult:AllScreen(ScannerDirection.route)
}