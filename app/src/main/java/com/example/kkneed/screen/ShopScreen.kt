package com.example.kkneed.screen

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ShopScreen(navController: NavController) {
    Scaffold(
        backgroundColor = MaterialTheme.colorScheme.background
    ) {
        Text("商城界面")
    }
}