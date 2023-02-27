package com.example.kkneed.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.kkneed.navigation.CUSTOMIZE_ROUTE
import com.example.kkneed.navigation.HOME_ROUTE
import com.example.kkneed.navigation.PROFILE_ROUTE
import com.example.kkneed.navigation.SHOP_ROUTE

sealed class BottomItemScreen(val route: String,val title: String, val icon: ImageVector){//底部导航栏
    object Home: BottomItemScreen(HOME_ROUTE,"主页", Icons.Default.Home)
    object Shop: BottomItemScreen(SHOP_ROUTE,"商城",Icons.Default.ShoppingCart)
    object Customize: BottomItemScreen(CUSTOMIZE_ROUTE,"定制",Icons.Default.DateRange)
    object Profile: BottomItemScreen(PROFILE_ROUTE,"个人",Icons.Default.Person)
}

