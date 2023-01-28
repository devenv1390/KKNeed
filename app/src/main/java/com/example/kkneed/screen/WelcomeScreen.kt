package com.example.kkneed.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.kkneed.navigation.AllScreen

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun WelcomeScreen(navController: NavController) {
    Scaffold(
        backgroundColor = MaterialTheme.colorScheme.background
    ) {
        Box(modifier = Modifier.fillMaxWidth()){
            Button(onClick = {
                navController.navigate(AllScreen.Guide.route)
            }){
                Text("欢迎！")
            }
        }
        Text("欢迎界面")
    }
}