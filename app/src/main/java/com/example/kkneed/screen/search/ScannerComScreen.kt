package com.example.kkneed.screen.search

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kkneed.R
import com.example.kkneed.ui.ScanBottomSheet
import com.example.kkneed.ui.ScanTopAppBar
import com.example.kkneed.ui.theme.KKNeedTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ScannerComScreen(navController: NavController) {
    Scaffold(
        backgroundColor = Color.Transparent,
        topBar = { ScanTopAppBar(64.dp, navController) }
    ){
        ScanBottomSheet()
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(top = 50.dp))
        {
            Box(modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center){
                Image(
                    painter = painterResource(R.drawable.scan),
                    contentDescription = "",
                    modifier = Modifier
                        .size(379.dp,182.dp),
                    contentScale = ContentScale.Fit
                )
                IconButton(onClick = { /*TODO*/ },
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(bottom = 16.dp, end = 20.dp)) {
                    Icon(
                        painter = painterResource(id = R.drawable.flashon),
                        null,
                        modifier = Modifier.size(24.dp),
                        tint = Color.White
                    )
                }
            }

        }
    }}
@Preview
@Composable
fun PreviewScannerComScreen() {
    KKNeedTheme {
        val navController = rememberNavController()
        ScannerComScreen(navController)
    }
}