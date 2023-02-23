package com.example.kkneed.screen.shop

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kkneed.ui.MostUseTopAppBar
import com.example.kkneed.ui.ShopCartBottomBar
import com.example.kkneed.ui.ShopCartCard
import com.example.kkneed.ui.theme.KKNeedTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ShoppingCartScreen(navController: NavController) {
    Scaffold(
        backgroundColor = MaterialTheme.colorScheme.background
    ) {
        Scaffold(
            backgroundColor = MaterialTheme.colorScheme.background,
            topBar = {
                MostUseTopAppBar(
                    appBarHeight = 64.dp,
                    navController = navController,
                    title = "购物车"
                )
            },
            bottomBar = { ShopCartBottomBar(navController) }
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                ShopCartCard()
                ShopCartCard()
                ShopCartCard()
            }
        }
    }
}

@Preview
@Composable
fun PreviewShoppingCartScreen() {
    KKNeedTheme {
        val navController = rememberNavController()
        ShoppingCartScreen(navController)
    }
}