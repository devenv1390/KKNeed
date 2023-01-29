package com.example.kkneed.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.kkneed.navigation.AllScreen
import com.example.kkneed.ui.MyTopAppBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun WelcomeScreen(navController: NavController) {
    Scaffold(
        backgroundColor = MaterialTheme.colorScheme.background,
        topBar = { MyTopAppBar { Text("欢迎界面") }}
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ){
            Spacer(modifier = Modifier.padding(0.dp, 10.dp))
            Button(onClick = {
                navController.navigate(AllScreen.Guide.route)
            }){
                Text("欢迎！")
            }
        }
    }
}