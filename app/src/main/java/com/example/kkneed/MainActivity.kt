package com.example.kkneed

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kkneed.ui.theme.*
import com.google.accompanist.pager.ExperimentalPagerApi

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KKNeedTheme {
//                GuideScreen()
                Sample()
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Sample() {
    val themeString = androidx.compose.material3.MaterialTheme.colorScheme
    val scaffoldState = rememberScaffoldState()
    val navController = rememberNavController()
    Scaffold(
        backgroundColor = themeString.secondaryContainer,
        snackbarHost = {
            scaffoldState.snackbarHostState
        },
        bottomBar = {
            BottomBarView(navController = navController)
        },
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.Center,
        floatingActionButton = {
            FloatingActionButton(
                onClick = { },
                backgroundColor = md_theme_dark_primary
            ) {
                Icon(Icons.Default.Build, null, tint = Color.White)
            }
        }
    ) {
        NavHost(
            navController = navController,
            startDestination = BottomItemScreen.Home.route
        ){
            composable(BottomItemScreen.Home.route){
                HomeScreen()
            }
            composable(BottomItemScreen.Shop.route){
                ShopScreen()
            }
            composable(BottomItemScreen.Data.route){
                DataScreen()
            }
            composable(BottomItemScreen.Personal.route){
                PersonalScreen()
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    KKNeedTheme {
        Sample()
    }
}