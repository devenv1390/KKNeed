package com.example.kkneed.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.kkneed.R

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SmallInfoCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .height(108.dp)
            .clickable { },

        // 设置点击波纹效果，注意如果 CardDemo() 函数不在 MaterialTheme 下调用
        // 将无法显示波纹效果
        onClick = {},
        backgroundColor = Color.Transparent,
        elevation = 0.dp // 设置阴影
    ) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(start = 16.dp)) {
            Box(
                modifier = Modifier
                    .size(108.dp, 84.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.head),
                    contentDescription = "",
                    modifier = Modifier
                        .clip(RoundedCornerShape(12.dp))
                        .size(95.dp),
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.TopCenter,
                )
            }
            Column(
            ) {
                Text(
                    "糖尿病应该吃什么？注意事项？",
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    "糖尿病应该吃什么……",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.outline
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(40.dp, 35.dp),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Image(
                            painter = painterResource(R.drawable.head),
                            contentDescription = "",
                            modifier = Modifier
                                .clip(RoundedCornerShape(50))
                                .size(32.dp),
                            contentScale = ContentScale.Crop,
                            alignment = Alignment.TopCenter,
                        )
                    }
                    Text(
                        "康康Need",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }

    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun OrderInfoCard(){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .height(392.dp)
            .clickable { },

        // 设置点击波纹效果，注意如果 CardDemo() 函数不在 MaterialTheme 下调用
        // 将无法显示波纹效果
        onClick = {},
        backgroundColor = MaterialTheme.colorScheme.background,
        elevation = 0.dp // 设置阴影
    ){
        Column( modifier = Modifier.padding(start = 16.dp)){
            Spacer(Modifier.size(0.dp, 16.dp))
            Row(verticalAlignment = Alignment.CenterVertically,modifier = Modifier.padding(start = 16.dp, end = 16.dp)){
                Box(
                    contentAlignment = Alignment.CenterStart

                ) {
                    Text(
                    "订单号：12345678910111213",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.outline
                )
                }
                Box(
                    contentAlignment = Alignment.CenterEnd

                ) {
                Text(
                    "待支付",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.error
                )
                }
            }
            Spacer(Modifier.size(0.dp, 16.dp))
            SmallOrderInfoCard()
            Spacer(Modifier.size(0.dp, 16.dp))


        }

    }
}
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SmallOrderInfoCard(){Card(
    modifier = Modifier
        .fillMaxWidth()
        .clip(RoundedCornerShape(12.dp))
        .height(72.dp)
        .clickable { },

    // 设置点击波纹效果，注意如果 CardDemo() 函数不在 MaterialTheme 下调用
    // 将无法显示波纹效果
    onClick = {},
    backgroundColor = MaterialTheme.colorScheme.background,
    elevation = 0.dp // 设置阴影
){
    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(start = 16.dp)) {
        Box(
            modifier = Modifier
                .size(56.dp, 56.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.head),
                contentDescription = "",
                modifier = Modifier
                    .size(56.dp),
                contentScale = ContentScale.Crop,
                alignment = Alignment.TopCenter,
            )
        }
        Column() {
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(start = 16.dp)){
                Text(
                    "可口可乐",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    "x3",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )

            }
            Text(
                "规格：250ml",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.outline
            )
        }
    }


}

}

@Composable
fun TestCard() {
    Card(
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .fillMaxWidth()
            .height(208.dp),
        backgroundColor = Color(0xFFFFFF),
        border = BorderStroke(1.dp, color = Color(0x25FFFFFF)),
        elevation = 0.dp,
        shape = RoundedCornerShape(16.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .alpha(1f)
                .blur(
                    radius = 28.dp,
                    edgeTreatment = BlurredEdgeTreatment.Unbounded
                )
                .background(
                    Brush.radialGradient(
                        listOf(
                            Color(0x12FFFFFF),
                            Color(0xDFFFFFF),
                            Color(0x9FFFFFFF)
                        ),
                        radius = 2200f,
                        center = Offset.Infinite
                    )
                )
        ) {}
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(start = 16.dp)) {
            Box(
                modifier = Modifier
                    .size(108.dp, 84.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.head),
                    contentDescription = "",
                    modifier = Modifier
                        .clip(RoundedCornerShape(12.dp))
                        .size(95.dp),
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.TopCenter,
                )
            }
            Column(
            ) {
                Text(
                    "糖尿病应该吃什么？注意事项？",
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    "糖尿病应该吃什么……",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.outline
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(40.dp, 35.dp),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Image(
                            painter = painterResource(R.drawable.head),
                            contentDescription = "",
                            modifier = Modifier
                                .clip(RoundedCornerShape(50))
                                .size(32.dp),
                            contentScale = ContentScale.Crop,
                            alignment = Alignment.TopCenter,
                        )
                    }
                    Text(
                        "康康Need",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }
}