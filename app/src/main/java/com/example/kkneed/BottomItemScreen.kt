package com.example.kkneed

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomItemScreen(val route: String,val title: String, val icon: ImageVector){
    object Home: BottomItemScreen("home","主页", Icons.Default.Home)
    object Shop:BottomItemScreen("shop","商城",Icons.Default.ShoppingCart)
    object Data:BottomItemScreen("data","定制",Icons.Default.DateRange)
    object Personal:BottomItemScreen("personal","个人",Icons.Default.Person)
}
