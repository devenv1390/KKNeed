package com.example.kkneed.screen.shop

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kkneed.navigation.AllScreen
import com.example.kkneed.ui.ADListCard
import com.example.kkneed.ui.GradientButton
import com.example.kkneed.ui.MostUseTopAppBar
import com.example.kkneed.ui.theme.KKNeedTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ADListScreen(navController: NavController) {
    Scaffold(
        backgroundColor = MaterialTheme.colorScheme.background,
        topBar = {
            MostUseTopAppBar(
                appBarHeight = 64.dp,
                navController = navController,
                title = "地址列表"
            )
        },
        bottomBar = { Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 28.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            GradientButton(modifier = Modifier
                .height(40.dp)
                .fillMaxWidth(0.8f),
                textId = "添加收货地址", onClick = {
                    navController.navigate(AllScreen.ADEdit.route)
                }
            )
        } }
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp, end = 16.dp, bottom = 80.dp)
        ) {
            Spacer(modifier = Modifier.height(8.dp))
            ADListCard()
            Spacer(modifier = Modifier.height(8.dp))
            ADListCard()
            Spacer(modifier = Modifier.height(8.dp))
            ADListCard()
            Spacer(modifier = Modifier.height(8.dp))
            ADListCard()
            Spacer(modifier = Modifier.height(88.dp))
        }
    }
}

@Preview
@Composable
fun PrevieADListScreen() {
    KKNeedTheme {
        val navController = rememberNavController()
        ADListScreen(navController)
    }
}