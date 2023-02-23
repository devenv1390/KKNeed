package com.example.kkneed.screen.home

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kkneed.R
import com.example.kkneed.screen.shop.HealthScreen
import com.example.kkneed.ui.MostUseTopAppBar
import com.example.kkneed.ui.ShopDetailBottomBar
import com.example.kkneed.ui.theme.KKNeedTheme

@OptIn(ExperimentalMaterialApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DayScreen(navController: NavController) {
    Scaffold(
        backgroundColor = MaterialTheme.colorScheme.background,
        topBar = {
            MostUseTopAppBar(
                appBarHeight = 64.dp,
                navController = navController,
                title = "每日一食"
            )
        },
    ) {
        Box(modifier = Modifier.fillMaxSize()){
            Image(
                painter = painterResource(R.drawable.daypic),
                contentDescription = "",
                modifier = Modifier
                    .clip(RoundedCornerShape(0))
                    .fillMaxSize(),
                contentScale = ContentScale.Crop,
                alignment = Alignment.TopCenter,
            )
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom,
            ) {
                Image(
                    painter = painterResource(R.drawable.daybottom),
                    contentDescription = "",
                    modifier = Modifier
                        .clip(RoundedCornerShape(0))
                        .fillMaxWidth()
                        .height(118.dp),
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.TopCenter,
                )
//                Card(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .height(118.dp),
//                    onClick = {},
//                    backgroundColor = MaterialTheme.colorScheme.surfaceColorAtElevation(5.dp),
//                    elevation = 0.dp,
//                ){
//
//                }
            }
        }

    }
}

@Preview
@Composable
fun PreviewHealthScreen() {
    KKNeedTheme {
        val navController = rememberNavController()
        DayScreen(navController)
    }
}