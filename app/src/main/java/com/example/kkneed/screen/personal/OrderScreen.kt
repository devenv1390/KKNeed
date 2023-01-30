package com.example.kkneed.screen.personal

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kkneed.ui.SecondProfileTopAppBar
import com.example.kkneed.ui.theme.KKNeedTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun OrderScreen(navController: NavController) {
    Scaffold(
        topBar = {
            SecondProfileTopAppBar(116.dp,navController)
        }
    ) {

    }
}

@Preview
@Composable
fun OrderPreview() {
    KKNeedTheme {
        val navController = rememberNavController()
        OrderScreen(navController)
    }
}