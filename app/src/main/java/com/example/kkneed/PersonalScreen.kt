package com.example.kkneed

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PersonalScreen() {
    Scaffold(
        backgroundColor = MaterialTheme.colorScheme.background
    ) {
        Text("个人界面")
    }
}