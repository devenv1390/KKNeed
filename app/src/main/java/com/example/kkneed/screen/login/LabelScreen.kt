package com.example.kkneed.screen.login

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kkneed.ui.theme.KKNeedTheme

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun LabelScreen(navController: NavController) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(color = MaterialTheme.colorScheme.onPrimary)
    ) {


        Spacer(modifier = Modifier.height(50.dp))

        Text(
            modifier = Modifier.padding(start = 16.dp),
            text = "是什么原因让您选择康康Need？",
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
        )
        Spacer(modifier = Modifier.height(13.dp))
        Text(
            modifier = Modifier.padding(start = 16.dp),
            text = "请选择一个或多个大标签",
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.titleMedium )
}
}
@Composable
@Preview
fun LabelScreenPreview() {
    KKNeedTheme {
        val navController = rememberNavController()
        LabelScreen(navController)
    }
}