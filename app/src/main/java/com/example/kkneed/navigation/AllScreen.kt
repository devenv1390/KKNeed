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
    object Profile:AllScreen("profile_screen")
    object Main:AllScreen("main_screen")
    object History:AllScreen("history_screen")
    object Order:AllScreen("order_screen")
    object Record:AllScreen("record_screen")
    object Watch:AllScreen("watch_screen")
    object Fan:AllScreen("fan_screen")
    object SignUp:AllScreen("sign_up_screen")
    object SignIn:AllScreen("sign_in_screen")
    object SignInfo:AllScreen("sign_info_screen")
    object Label:AllScreen("label_screen")
    object Success:AllScreen("success_screen")
    object Chip:AllScreen("chip_screen")
    object PersonInfo:AllScreen("person_info_screen")
    object Scanner:AllScreen("scanner_screen")
    object Comment:AllScreen("comment_screen")
    object Detail:AllScreen("detail_screen")
    object Customize:AllScreen("customize_screen")
    object Compare:AllScreen("compare_screen")
    object Chose:AllScreen("chose_screen")
    object ScanHistory:AllScreen("scan_history_screen")
    object Edit:AllScreen("edit_screen")
    object EditProduct:AllScreen("edit_product_screen")
    object Collect:AllScreen("collect_screen")
    object RecordDetail:AllScreen("record_detail_screen")
    object Search:AllScreen("search_screen")
    object SearchResult:AllScreen("search_result_screen")
    object Community:AllScreen("community_screen")
    object EditNote:AllScreen("edit_note_screen")
    object NoteDetail:AllScreen("note_detail_screen")
    object SearchCommunity:AllScreen("search_community_screen")
    object Create:AllScreen("create_screen")
    //object Health:AllScreen("health_screen")
    object Service:AllScreen("service_screen")
    object ShopDetail:AllScreen("shop_detail_screen")
    object ScanResult:AllScreen("scan_result_screen")
    object ADList:AllScreen("adList_screen")
    object Confirm:AllScreen("confirm_screen")
    object Day:AllScreen("day_screen_screen")
    object ShoppingCart:AllScreen("shopping_cart_screen")
    object ADEdit:AllScreen("ad_edit_screen")
    object SCLoading:AllScreen("scan_loading_screen")
}