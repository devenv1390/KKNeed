package com.example.kkneed.screen.login

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
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
import com.example.kkneed.navigation.AllScreen
import com.example.kkneed.ui.*
import com.example.kkneed.ui.theme.KKNeedTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun LabelScreen(navController: NavController) {
    Scaffold(
        bottomBar = {
            Column {
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center){
                    GradientButton(modifier = Modifier
                        .height(56.dp)
                        .fillMaxWidth(0.8f),
                        textId = "下一步 >", onClick = {
                            navController.navigate(AllScreen.Chip.route)

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
            text = "请选择大标签中的小标签，无对应需求不勾选即可",
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.titleMedium )
        Spacer(modifier = Modifier.height(50.dp))

        Row(modifier= Modifier
            .fillMaxSize()
            .padding(start = 8.dp, end = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween){
            Column(){
            LabelCard1()
            Spacer(modifier = Modifier.height(30.dp))
            LabelCard3()
        }
            Column(){
                LabelCard2()
                Spacer(modifier = Modifier.height(30.dp))
                LabelCard4()
            }}
        Spacer(modifier = Modifier.height(40.dp))
        Row(modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center){

        }
    }
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