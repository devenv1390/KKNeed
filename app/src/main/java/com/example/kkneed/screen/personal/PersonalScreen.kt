package com.example.kkneed.screen.personal

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.kkneed.ui.MyTopAppBar
import com.example.kkneed.ui.theme.KKNeedTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PersonalScreen(navController: NavController) {
    Scaffold(
        backgroundColor = MaterialTheme.colorScheme.background,
        topBar = {
            MyTopAppBar {}
        }
    ) {

    }
}


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Preview
@Composable
fun Temp() {
    KKNeedTheme {
        Scaffold(
            backgroundColor = MaterialTheme.colorScheme.background,
            topBar = {
                MyTopAppBar {}
            }
        ) {

        }
    }

}