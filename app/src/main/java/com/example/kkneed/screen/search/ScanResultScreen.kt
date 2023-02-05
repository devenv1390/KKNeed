package com.example.kkneed.screen.search

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ScanResultScreen(navController: NavController,code:String,codeType:String) {
    Scaffold(
        topBar = { TopAppBar { Text("读取结果") } }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(code)
                Text(codeType)
                Spacer(modifier = Modifier.height(10.dp).fillMaxWidth())
                Button(
                    onClick = {
                        navController.popBackStack()
                    }
                ){
                    Text("重新读取")
                }
            }
        }
    }
}