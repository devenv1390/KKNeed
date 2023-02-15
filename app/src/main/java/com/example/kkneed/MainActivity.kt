package com.example.kkneed

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kkneed.navigation.AllScreen
import com.example.kkneed.navigation.ROOT_ROUTE
import com.example.kkneed.navigation.WELCOME_ROUTE
import com.example.kkneed.navigation.nav_graph.*
import com.example.kkneed.screen.MainScreen
import com.example.kkneed.ui.theme.*
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window?.run{
            WindowCompat.setDecorFitsSystemWindows(this, false)
        }
        setContent {
            KKNeedTheme {
                val systemUiController = rememberSystemUiController()

                SideEffect {
                    systemUiController.setSystemBarsColor(Black700, false)
                }
                rememberSystemUiController().setStatusBarColor(Color.Transparent, darkIcons = androidx.compose.material.MaterialTheme.colors.isLight)
                Surface(color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = WELCOME_ROUTE,
                        route = ROOT_ROUTE
                    ){
                        composable(AllScreen.Main.route){
                            MainScreen(navController)
                        }
                        WelcomeNavGraph(navController)
                        HomeNavGraph(navController)
                        ShopNavGraph(navController)
                        DataNavGraph(navController)
                        ProfileNavGraph(navController)
                        SearchNavGraph(navController)
                    }
                }
            }
        }
    }
}