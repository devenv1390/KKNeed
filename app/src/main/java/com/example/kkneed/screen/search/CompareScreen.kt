package com.example.kkneed.screen.search

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kkneed.R
import com.example.kkneed.screen.shop.SearchScreen
import com.example.kkneed.ui.*
import com.example.kkneed.ui.theme.KKNeedTheme

@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CompareScreen(navController: NavController) {
    Scaffold(
        topBar = {
            MostUseTopAppBar(appBarHeight = 64.dp, navController =navController, "产品对比") })
    {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp,end=16.dp),
        horizontalArrangement = Arrangement.SpaceBetween){
            CompareCard("百事可乐")
            CompareCard("农夫山泉东方树叶红茶500ml")
        }

    }

    }
@Preview
@Composable
fun PreviewCompareScreen() {
    KKNeedTheme {
        val navController = rememberNavController()
        CompareScreen(navController)
    }
}

