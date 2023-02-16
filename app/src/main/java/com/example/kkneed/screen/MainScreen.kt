package com.example.kkneed.screen

import android.annotation.SuppressLint
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kkneed.navigation.*
import com.example.kkneed.screen.customize.CustomizeScreen
import com.example.kkneed.screen.profile.ProfileScreen
import com.example.kkneed.ui.theme.md_theme_dark_primary

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(navController: NavController) {
    val themeString = androidx.compose.material3.MaterialTheme.colorScheme
    val scaffoldState = rememberScaffoldState()
    val navMainController = rememberNavController()
    Scaffold(
        backgroundColor = themeString.secondaryContainer,
        snackbarHost = {
            scaffoldState.snackbarHostState
        },
//        bottomBar = {
//            MyBottomNavigation(navController = navMainController)
//        },
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.Center,
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(SCANNER_ROUTE)
                },
                backgroundColor = md_theme_dark_primary
            ) {
                Icon(Icons.Default.Build, null, tint = Color.White)
            }
        }
    ) {
        NavHost(
            navController = navMainController,
            startDestination = HOME_ROUTE
        ) {
            composable(HOME_ROUTE) {
                HomeScreen(navController)
            }
            composable(SHOP_ROUTE) {
                ShopScreen(navController)
            }
            composable(CUSTOMIZE_ROUTE) {
                CustomizeScreen(navController)
            }
            composable(PROFILE_ROUTE) {
                ProfileScreen(navController)
            }
        }
    }
}

