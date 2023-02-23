package com.example.kkneed.screen.search

import android.annotation.SuppressLint
import androidx.compose.animation.core.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.kkneed.ui.MyHistoryTopAppBar
import com.example.kkneed.ui.ShopTopAppBar
import com.example.kkneed.ui.theme.KKNeedTheme


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun EditProductScreen(navController: NavController) {
    Scaffold(
        topBar = { MyHistoryTopAppBar(56.dp,navController) }
    ) {

    }
}
@Composable
fun Demo() {

}
@Composable
@Preview
fun HeartPreview() {
    KKNeedTheme {
        Demo()
    }
}