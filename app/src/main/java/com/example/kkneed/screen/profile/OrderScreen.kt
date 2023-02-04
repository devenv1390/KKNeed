package com.example.kkneed.screen.profile

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kkneed.ui.OrderProfileTopAppBar
import com.example.kkneed.ui.TabBar
import com.example.kkneed.ui.theme.KKNeedTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun OrderScreen(navController: NavController) {
    Scaffold(
        topBar = {
            OrderProfileTopAppBar(64.dp,navController)
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.TopCenter
        ){
            Column(
                horizontalAlignment = Alignment.Start
            ) {
                TabBar()

            }
        }

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