package com.example.kkneed.screen.profile

import android.annotation.SuppressLint
import android.graphics.Paint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kotlin.math.PI
import kotlin.math.atan
import kotlin.math.atan2
import com.example.kkneed.ui.*
import com.example.kkneed.ui.components.PieChart
import com.example.kkneed.ui.components.PieChartInput
import com.example.kkneed.ui.theme.*

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun RecordScreen(navController: NavController) {
    Scaffold(
        topBar = {
            SecondRecordTopAppBar(appBarHeight = 64.dp, navController =navController )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.onPrimary)
            ,
            horizontalAlignment = Alignment.CenterHorizontally,
        ){
            Text(
                "1月1日-1月30日",
                style=MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 16.dp)
            )
            Box(
            ){
                PieChart(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(400.dp),
                    input = listOf(
                        PieChartInput(
                            color = LevelA,
                            value = 29,
                            description = "A等级食品"
                        ),
                        PieChartInput(
                            color = LevelB,
                            value = 21,
                            description = "B等级食品"
                        ),
                        PieChartInput(
                            color = LevelC,
                            value = 32,
                            description = "C等级食品"
                        ),
                        PieChartInput(
                            color = LevelD,
                            value = 18,
                            description = "D等级食品"
                        ),
                        PieChartInput(
                            color = LevelE,
                            value = 37,
                            description = "E等级食品"
                        ),
                    ),
                    centerText = "健康评分90分"
                )
                Text(
                    "商品概览",
                    style=MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.padding(start = 16.dp, bottom = 12.dp)
                        .align(Alignment.BottomStart)
                )
            }
            RecordList("A", LevelA)
            RecordList("B", LevelB)
            RecordList("C", LevelC)
            RecordList("D", LevelD)
            RecordList("E", LevelE)
            Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start){
                Text(
                "3种未知等级商品 >",
                style=MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.outline,
                modifier = Modifier.padding(top = 12.dp, start = 16.dp))
            }


    }
}
}

@Preview
@Composable
fun RecordPreview() {
    KKNeedTheme {
        val navController = rememberNavController()
        RecordScreen(navController)
    }
}