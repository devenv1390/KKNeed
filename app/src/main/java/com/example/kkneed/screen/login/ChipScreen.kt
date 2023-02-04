package com.example.kkneed.screen.login

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.layout.layout
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kkneed.navigation.AllScreen
import com.example.kkneed.ui.GradientButton
import com.example.kkneed.ui.SmallChip
import com.example.kkneed.ui.theme.KKNeedTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ChipScreen(navController: NavController){
    Scaffold(
        bottomBar = {
            Column {
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center){
                    GradientButton(modifier = Modifier
                        .height(56.dp)
                        .fillMaxWidth(0.8f),
                        textId = "下一步", onClick = {
                            navController.navigate(AllScreen.Success.route)
                        }
                    )
                }
                Spacer(modifier = Modifier.height(40.dp))
            }
        }
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
            text = "您对哪些指标较为关注？",
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
        )
        Spacer(modifier = Modifier.height(13.dp))
        Text(
            modifier = Modifier.padding(start = 16.dp),
            text = "请选择一个或多个指标",
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.titleMedium )
        Spacer(modifier = Modifier.height(60.dp))

            Box(modifier = Modifier
                .fillMaxWidth()
                .height(210.dp)){
                SmallChip(state = true, title ="热量" ,
                    modifier =Modifier.RandomPosition(120,30))
                SmallChip(state = false, title ="脂肪" ,
                    modifier =Modifier.RandomPosition(450,60))
                SmallChip(state = false, title ="蛋白质" ,
                    modifier =Modifier.RandomPosition(800,0))
                SmallChip(state = true, title ="碳水化合物" ,
                    modifier =Modifier.RandomPosition(80,300))
                SmallChip(state = false, title ="添加剂" ,
                    modifier =Modifier.RandomPosition(430,500))
                SmallChip(state = false, title ="钠" ,
                    modifier =Modifier.RandomPosition(800,400))
                Text(text = "营养元素",
                    modifier=Modifier.align(Alignment.Center),
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold))
            }
            Spacer(modifier = Modifier.height(80.dp))
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(210.dp)){
                SmallChip(state = true, title ="添加糖" ,
                    modifier =Modifier.RandomPosition(150,80))
                SmallChip(state = true, title ="添加剂" ,
                    modifier =Modifier.RandomPosition(800,300))
                SmallChip(state = false, title ="过敏原" ,
                    modifier =Modifier.RandomPosition(650,20))
                SmallChip(state = true, title ="反式脂肪可能来源" ,
                    modifier =Modifier.RandomPosition(80,360))
                SmallChip(state = false, title ="色素" ,
                    modifier =Modifier.RandomPosition(500,520))
                Text(text = "食品成分",
                    modifier=Modifier.align(Alignment.Center),
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold))
            }
        }
}
}

fun Modifier.RandomPosition(
    ToLeft:Int,ToTop: Int
) = layout { measurable, constraints ->
    // Measure the composable
    val placeable = measurable.measure(constraints)

    layout(placeable.width, placeable.height) {
        // Where the composable gets placed
        placeable.placeRelative(ToLeft, ToTop)
    }
}

@Composable
@Preview
fun ChipScreenPreview() {
    KKNeedTheme {
        val navController = rememberNavController()
        ChipScreen(navController)
    }
}