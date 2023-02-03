package com.example.kkneed.ui

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.FilterChip
import androidx.compose.material.Chip
import androidx.compose.material.ChipDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
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

//订单状态卡片
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun OrderInfoCard(
    orderNumber:String,
    state: String
){
    Card(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp)
            .clip(RoundedCornerShape(12.dp))
            .height(392.dp)
            .clickable { },

        // 设置点击波纹效果，注意如果 CardDemo() 函数不在 MaterialTheme 下调用
        // 将无法显示波纹效果
        onClick = {},
        backgroundColor = MaterialTheme.colorScheme.background,
        elevation = 0.dp // 设置阴影
    ){
        Column( ){
            Row( verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp)
                    .size(380.dp, 39.dp)){
                Box(
                    contentAlignment = Alignment.CenterStart,

                ) {
                    Text(
                    "订单号：$orderNumber",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.outline
                )
                }
                Box(
                    contentAlignment = Alignment.CenterEnd

                ) {
                Text(
                    text = state,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.error
                )
                }
            }
            SmallOrderInfoCard("可口可乐",3,"规格:250ml","￥3.50")
            SmallOrderInfoCard("可口可乐",3,"规格:250ml","￥3.50")
            SmallOrderInfoCard("可口可乐",3,"规格:250ml","￥3.50")
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ){
                IconButton(
                    modifier = Modifier.size(24.dp),
                onClick = { /*TODO*/ }
            ) {
                Icon(Icons.Default.MoreVert, null)
            }
            }
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ){
                Divider(modifier = Modifier.size(320.dp, 1.dp))
            }
            Box(modifier = Modifier.fillMaxSize())
            {
                Column(modifier = Modifier.padding(top = 16.dp)) {
                    Text(
                        text = "共4件商品",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onTertiaryContainer,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                    Text(
                        text = "小计：￥100.00",
                        style = MaterialTheme.typography.titleSmall,
                        color = MaterialTheme.colorScheme.onTertiaryContainer,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Bottom)
                    {
                        Text(
                            text = "订单将于9分钟后关闭",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.outline
                        )
                        Button(
                            colors = ButtonDefaults.buttonColors(
                               containerColor = MaterialTheme.colorScheme.error.copy(alpha=0.9f)
                            ),
                            onClick = { /*TODO*/ }) {
                            Text(
                                "立即支付",
                                style = MaterialTheme.typography.titleSmall,
                                color = MaterialTheme.colorScheme.onError,
                            )
                        }
                    }
                }

            }


        }

    }
}
//商品小卡片
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SmallOrderInfoCard(
    title:String,
    number:Int,
    configuration:String,
    price:String
){Card(
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
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
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
        Column(
            modifier = Modifier.size(188.dp,56.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .size(188.dp, 24.dp)
            ){
                Box(){
                    Text(
                    text=title,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )
                }
                Spacer(modifier = Modifier.height(12.dp))
                Box() {
                    Text(
                        text = "x$number",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }
            Text(
                text=configuration,
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.outline
            )
        }
        Box(modifier = Modifier.size(64.dp,56.dp), contentAlignment = Alignment.CenterEnd){
            Text(
                text=price,
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onTertiaryContainer
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
//商城界面主卡片
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ShopScreenMainCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp) // 外边距
            .clickable { }
            .clip(RoundedCornerShape(12.dp))
            .background(MaterialTheme.colorScheme.surface)
            .height(160.dp),

        // 设置点击波纹效果，注意如果 CardDemo() 函数不在 MaterialTheme 下调用
        // 将无法显示波纹效果

        elevation = 0.dp, // 设置阴影
        onClick = {},

        )
    {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(start = 0.dp)
        )
        {
            Image(
                painter = painterResource(R.drawable.head),
                contentDescription = "",
                modifier = Modifier
                    .clip(RoundedCornerShape(12))
                    .size(160.dp),
                contentScale = ContentScale.Crop,
                alignment = Alignment.TopCenter,
            )
            Column(
                modifier = Modifier
                    .padding(start = 8.dp, end = 8.dp)
                    .height(131.dp)
                    .width(197.dp)
                    .fillMaxHeight()
            ) {
                androidx.compose.material3.Text(
                    "麦维他全麦粗粮酥性消化饼原味400g",
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Spacer(Modifier.height(9.dp))
                Image(
                    painter = painterResource(R.drawable.head),
                    contentDescription = "",
                    modifier = Modifier
                        .clip(RoundedCornerShape(12))
                        .size(45.dp),
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.TopCenter,
                )
                Spacer(Modifier.height(9.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .width(197.dp)
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .height(28.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,

                    ) {
                    androidx.compose.material3.Text(
                        "￥34.6",
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.error
                    )
                    androidx.compose.material3.Text(
                        "已售1.6w+",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.outline
                    )
                }
            }
        }
    }
}

//基础病卡片
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun LabelCard1(){
    Card(
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .size(184.dp, 266.dp),
        backgroundColor = Color(0xFFFFFF),
        border = BorderStroke(1.dp, color = MaterialTheme.colorScheme.primary),
        elevation = 0.dp,
        shape = RoundedCornerShape(16.dp)
    ){
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
            painter = painterResource(R.drawable.jichubing),
            contentDescription = "",
            modifier = Modifier
                .size(184.dp, 134.dp),
            contentScale = ContentScale.Fit,
            alignment = Alignment.TopCenter,
        )
            Row(
            verticalAlignment = Alignment.CenterVertically){
                Text(
                    "基础疾病",
                    color=MaterialTheme.colorScheme.onBackground,
                    style=MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
                )
            }
            Row(){
                QuestionChip(state = false, title ="糖尿病" )
                Spacer(modifier = Modifier.width(4.dp))
                QuestionChip(state = true, title ="高血压" )
            }
            Row(){
                QuestionChip(state = true, title ="血脂异常" )
                Spacer(modifier = Modifier.width(4.dp))
                QuestionChip(state = true, title ="痛风" )
            }


        }
    }
}
//减肥卡片
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun LabelCard2(){
    Card(
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .size(184.dp, 210.dp),
        backgroundColor = Color(0xFFFFFF),
        border = BorderStroke(1.dp, color = MaterialTheme.colorScheme.primary),
        elevation = 0.dp,
        shape = RoundedCornerShape(16.dp)
    ){
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(R.drawable.jianfei),
                contentDescription = "",
                modifier = Modifier
                    .size(184.dp, 124.dp),
                contentScale = ContentScale.Fit,
                alignment = Alignment.TopCenter,
            )
            Row(
                verticalAlignment = Alignment.CenterVertically){
                Text(
                    "营养诉求",
                    color=MaterialTheme.colorScheme.onBackground,
                    style=MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
                )
            }
            Row(){
                QuestionChip(state = false, title ="减脂" )
                Spacer(modifier = Modifier.width(4.dp))
                QuestionChip(state = false, title ="健身" )
            }
        }
    }
}
//女性关键期卡片
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun LabelCard3(){
    Card(
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .size(184.dp, 210.dp),
        backgroundColor = Color(0xFFFFFF),
        border = BorderStroke(1.dp, color = MaterialTheme.colorScheme.primary),
        elevation = 0.dp,
        shape = RoundedCornerShape(16.dp)
    ){
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(R.drawable.nvxing),
                contentDescription = "",
                modifier = Modifier
                    .size(184.dp, 124.dp),
                contentScale = ContentScale.Fit,
                alignment = Alignment.TopCenter,
            )
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "女性关键期",
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
                )
            }
            Row() {
                QuestionChip(state = true, title = "备孕/孕期")
                Spacer(modifier = Modifier.width(4.dp))
                QuestionChip(state = false, title = "哺乳期")
            }

        }
    }
}

@Composable
fun LabelCard4(){
    Card(
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .size(184.dp, 266.dp),
        backgroundColor = Color(0xFFFFFF),
        border = BorderStroke(1.dp, color = MaterialTheme.colorScheme.primary),
        elevation = 0.dp,
        shape = RoundedCornerShape(16.dp)
    ){
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(R.drawable.other),
                contentDescription = "",
                modifier = Modifier
                    .size(184.dp, 134.dp),
                contentScale = ContentScale.Fit,
                alignment = Alignment.TopCenter,
            )
            Row(
                verticalAlignment = Alignment.CenterVertically){
                Text(
                    "其他诉求",
                    color=MaterialTheme.colorScheme.onBackground,
                    style=MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
                )
            }
            Row(){
                QuestionChip(state = true, title ="过敏" )
                Spacer(modifier = Modifier.width(4.dp))
                QuestionChip(state = false, title ="睡眠问题" )
            }
            Row(){
                QuestionChip(state = false, title ="肠道健康" )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuestionChip(state:Boolean,title: String){
    var selected by remember { mutableStateOf(state) }
    FilterChip(
        selected = selected,
        onClick = { selected = !selected },
        label = { Text(title,
        color=if(selected) Color.White else Color.Black) },
        colors = FilterChipDefaults.filterChipColors(
           containerColor = MaterialTheme.colorScheme.outline.copy(0.7f),
            selectedContainerColor =MaterialTheme.colorScheme.primary,

        ),

        border = FilterChipDefaults.filterChipBorder(borderWidth = 0.dp),
    )
}