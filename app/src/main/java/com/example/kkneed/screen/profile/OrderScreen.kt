package com.example.kkneed.screen.profile

import android.annotation.SuppressLint
import android.app.ActionBar.Tab
import android.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kkneed.navigation.BottomItemScreen.Data.title
import com.example.kkneed.ui.SecondProfileTopAppBar
import com.example.kkneed.ui.TabBar
import com.example.kkneed.ui.theme.KKNeedTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun OrderScreen(navController: NavController) {
    Scaffold(
        topBar = {
            SecondProfileTopAppBar(116.dp,navController)
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