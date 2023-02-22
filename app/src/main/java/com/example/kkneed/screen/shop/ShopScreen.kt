package com.example.kkneed.screen

import android.annotation.SuppressLint
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kkneed.R
import com.example.kkneed.navigation.SCANNER_ROUTE
import com.example.kkneed.ui.MyBottomNavigation
import com.example.kkneed.ui.ShopScreenMainCard
import com.example.kkneed.ui.ShopTopAppBar
import com.example.kkneed.ui.components.ShopIconGroupCompose
import com.example.kkneed.ui.theme.KKNeedTheme
import com.example.kkneed.ui.theme.md_theme_dark_primary

@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "ResourceType")
@Composable
fun ShopScreen(navController: NavController) {
    val listState = rememberLazyListState()
    Scaffold(
        backgroundColor = MaterialTheme.colorScheme.background,
        topBar = {
            ShopTopAppBar(appBarHeight = 64.dp, navController = navController)
        },
        bottomBar = {
            MyBottomNavigation(navController = navController,1)
        },
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.Center,
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(SCANNER_ROUTE)
                },
                backgroundColor = md_theme_dark_primary
            ) {
                androidx.compose.material.Icon(
                    painter = painterResource(id = R.drawable.barcode_scanner),
                    null,
                    tint = Color.White,
                    modifier = Modifier.height(24.dp)
                )
            }
        }
    ) {
        Box(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .fillMaxSize()
                .padding(top=8.dp),
            contentAlignment = Alignment.TopCenter
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(R.drawable.shopcard),
                    contentDescription = "",
                    modifier = Modifier
                        .clip(RoundedCornerShape(12.dp))
                        .height(200.dp),
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.TopCenter,
                )
                Spacer(modifier = Modifier.height(16.dp))
                ShopIconGroupCompose(listState)
            }
        }
    }
}

@Preview
@Composable
fun PreviewShopScreen() {
    KKNeedTheme {
        val navController = rememberNavController()
        ShopScreen(navController)
    }
}
