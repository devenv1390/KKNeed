package com.example.kkneed.screen.login

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kkneed.navigation.AllScreen
import com.example.kkneed.ui.GradientButton
import com.example.kkneed.ui.MyTopAppBar2
import com.example.kkneed.ui.theme.KKNeedTheme
import java.util.*

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SuccessScreen(navController: NavController){
    Scaffold(
        bottomBar = {
            Column {
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center){
                    GradientButton(modifier = Modifier
                        .height(56.dp)
                        .fillMaxWidth(0.8f),
                        textId = "进入首页", onClick = {
                            navController.navigate(AllScreen.Home.route)
                        }
                    )}
                Spacer(modifier = Modifier.height(40.dp))
            }
            },
        topBar = {
            MyTopAppBar2{}
        },
    ){
        Column(
        verticalArrangement=Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(color = MaterialTheme.colorScheme.onPrimary)
    ) {


        Spacer(modifier = Modifier.height(65.dp))

        Text(
            text = "您已完成所有设置",
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
        )
        Spacer(modifier = Modifier.height(13.dp))
        Text(text = "让我们开始畅享健康生活吧！", color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.titleMedium )


    }}


}


@Composable
@Preview
fun SuccessScreenPreview() {
    KKNeedTheme {
        val navController = rememberNavController()
        SuccessScreen(navController)
    }
}