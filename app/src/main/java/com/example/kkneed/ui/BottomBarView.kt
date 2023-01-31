package com.example.kkneed.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.kkneed.navigation.BottomItemScreen

@Composable
fun MyBottomNavigation(navController: NavController) {//第二种设计方案，采用BottomAppBar与BottomNavigationItem结合的方式，解决了选项卡按下后没有外观变化的缺点，但动画和按键的布局范围比较难控制
//    var selectedItem by remember { mutableStateOf(0) }
    val themeString = MaterialTheme.colorScheme
    val navItems = listOf(
        BottomItemScreen.Home,
        BottomItemScreen.Shop,
        BottomItemScreen.Data,
        BottomItemScreen.Profile
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    BottomAppBar(
        cutoutShape = RoundedCornerShape(50),
        contentPadding = PaddingValues(5.dp, 5.dp),
        backgroundColor = themeString.background,
        modifier = Modifier.navigationBarsPadding()
    ) {
//        items.forEachIndexed{index, item ->
//            BottomNavigationItem(
//                selected = selectedItem == index,
//                onClick = {selectedItem = index},
//                icon = { Icon(item.icon,null)},
//                alwaysShowLabel = false,
//                label = { Text(item.name)},
//            )
//        }//不能采用遍历的方式创建导航选项卡，因为选项卡需要单独设置间隔值
        BottomNavigationItem(
            selected = currentRoute == navItems[0].route,
            onClick = {
                navController.navigate(navItems[0].route) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            },
            icon = { Icon(navItems[0].icon, null) },
            selectedContentColor = MaterialTheme.colorScheme.primary,
            unselectedContentColor = MaterialTheme.colorScheme.secondaryContainer,
            alwaysShowLabel = false,
            label = { Text(navItems[0].title) },
            modifier = Modifier.padding(10.dp, 0.dp, 10.dp, 0.dp),
        )
        BottomNavigationItem(
            selected = currentRoute == navItems[1].route,
            onClick = {
                navController.navigate(navItems[1].route) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            },
            icon = { Icon(navItems[1].icon, null) },
            selectedContentColor = MaterialTheme.colorScheme.primary,
            unselectedContentColor = MaterialTheme.colorScheme.secondaryContainer,
            alwaysShowLabel = false,
            label = { Text(navItems[1].title) },
            modifier = Modifier.padding(0.dp, 0.dp, 40.dp, 0.dp)
        )
        BottomNavigationItem(
            selected = currentRoute == navItems[2].route,
            onClick = {
                navController.navigate(navItems[2].route) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            },
            icon = { Icon(navItems[2].icon, null) },
            selectedContentColor = MaterialTheme.colorScheme.primary,
            unselectedContentColor = MaterialTheme.colorScheme.secondaryContainer,
            alwaysShowLabel = false,
            label = { Text(navItems[2].title) },
            modifier = Modifier.padding(40.dp, 0.dp, 0.dp, 0.dp)
        )
        BottomNavigationItem(
            selected = currentRoute == navItems[3].route,
            onClick = {
                navController.navigate(navItems[3].route) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            },
            icon = { Icon(navItems[3].icon, null) },
            selectedContentColor = MaterialTheme.colorScheme.primary,
            unselectedContentColor = MaterialTheme.colorScheme.secondaryContainer,
            alwaysShowLabel = false,
            label = { Text(navItems[3].title) },
            modifier = Modifier.padding(10.dp, 0.dp, 10.dp, 0.dp)
        )
    }
}
