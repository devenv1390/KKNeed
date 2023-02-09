package com.example.kkneed.ui

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times
import com.example.kkneed.ui.theme.KKNeedTheme


@Composable
fun BarChart(
    data:Map<Float,Float>,
) {
    val title: List<String> = listOf(
        "能量\n"+"/kcal",
        "脂肪\n" + "/mg",
        "蛋白质\n" + "/mg",
        "碳水化合物\n" + "/mg",
        "钠\n" + "/mg"
    )

    val context = LocalContext.current
    // BarGraph Dimensions
    val barGraphHeight by remember { mutableStateOf(200.dp) }
    val barGraphWidth by remember { mutableStateOf(20.dp) }
    // Scale Dimensions
    val scaleLineWidth by remember { mutableStateOf(2.dp) }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start=8.dp)
                .height(barGraphHeight),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.spacedBy(barGraphWidth)
        ) {

                data.forEach {
                    Row(modifier = Modifier.width(2*barGraphWidth),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.Bottom){
                        Box(
                            modifier = Modifier
                                .padding(bottom = 5.dp)
                                .clip(RoundedCornerShape(4.dp))
                                .width(18.dp)
                                .fillMaxHeight(it.key)
                                .background(MaterialTheme.colorScheme.primary)
                        ){
                            Text(
                                it.key.toString(),
                                style = MaterialTheme.typography.labelSmall,
                                color = MaterialTheme.colorScheme.onBackground,
                                modifier = Modifier.align(Alignment.Center)
                            )
                        }
                        Box(
                            modifier = Modifier
                                .padding(bottom = 5.dp)
                                .clip(RoundedCornerShape(4.dp))
                                .width(18.dp)
                                .fillMaxHeight(it.value)
                                .background(MaterialTheme.colorScheme.inversePrimary)
                        ){
                            Text(
                                it.key.toString(),
                                style = MaterialTheme.typography.labelSmall,
                                color = MaterialTheme.colorScheme.onBackground,
                                modifier = Modifier.align(Alignment.Center)
                            )
                        }
                    }
            }
            Column() {
                Row(verticalAlignment = Alignment.CenterVertically){
                    Box(modifier = Modifier
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.primary)
                        .size(12.dp))
                    Text("A产品",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onBackground)
                }
                Spacer(modifier = Modifier.height(4.dp))
                Row(verticalAlignment = Alignment.CenterVertically){Box(modifier = Modifier
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.inversePrimary)
                    .size(12.dp))
                    Text("B产品",style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onBackground)
                }
                
            }



        }



        // Scale X-Axis
        Row(
            modifier = Modifier
                .padding(start=8.dp,)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(barGraphWidth)
        ) {

            title.forEach {
                Text(
                    modifier = Modifier.width(2*barGraphWidth),
                    text = it,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.outline,
                    style = MaterialTheme.typography.bodySmall
                )
            }

        }

    }

}
@Preview
@Composable
fun BarChartcreen() {
    KKNeedTheme {
        BarChart(
            data= mapOf(
                Pair(0.5f,0.6f),
                Pair(0.6f,0.6f),
                Pair(0.2f,0.6f),
                Pair(0.7f,0.6f),
                Pair(0.8f,0.6f))

        )
    }
}
