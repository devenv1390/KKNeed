package com.example.kkneed.ui

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kkneed.R
import com.example.kkneed.screen.login.RandomPosition
import com.example.kkneed.ui.components.QuestionChip
import com.example.kkneed.ui.theme.KKNeedTheme
import com.example.kkneed.ui.theme.LevelA

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
            .padding(start = 16.dp, end = 16.dp, bottom = 8.dp) // 外边距
            .clickable { }
            .clip(RoundedCornerShape(12.dp))
            .height(160.dp),

        // 设置点击波纹效果，注意如果 CardDemo() 函数不在 MaterialTheme 下调用
        // 将无法显示波纹效果

        elevation = 1.dp, // 设置阴影
        onClick = {},
        backgroundColor = MaterialTheme.colorScheme.surfaceColorAtElevation(1.dp),
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
                    painter = painterResource(R.drawable.alevel),
                    contentDescription = "",
                    modifier = Modifier
                        .clip(RoundedCornerShape(12))
                        .height(45.dp)
                        .width(84.dp),
                    contentScale = ContentScale.Fit,
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
//其他诉求卡片
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
//用户评价卡片
@Composable
fun CommentCard(){
    Card(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp)
            .size(380.dp, 98.dp)
            .clickable { },
        backgroundColor = MaterialTheme.colorScheme.secondaryContainer,
        elevation =1.dp,
        shape = RoundedCornerShape(12.dp)
    ){
        Row(modifier = Modifier.padding(12.dp)) {
            Image(
                painter = painterResource(R.drawable.head),
                contentDescription = "",
                modifier = Modifier
                    .size(40.dp, 40.dp)
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop,
                alignment = Alignment.TopCenter,
            )
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp)){
                Row(modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween){
                    Text(
                        "康康need",
                        color=MaterialTheme.colorScheme.onBackground,
                        style=MaterialTheme.typography.titleSmall
                    )
                    Text(
                        "29八月",
                        color=MaterialTheme.colorScheme.outline,
                        style=MaterialTheme.typography.titleSmall
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Row(){
                    Icon(painter = painterResource(id = R.drawable.fillstar),null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(12.dp))
                    Icon(painter = painterResource(id = R.drawable.fillstar),null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(12.dp))
                    Icon(painter = painterResource(id = R.drawable.fillstar),null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(12.dp))
                    Icon(painter = painterResource(id = R.drawable.fillstar),null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(12.dp))
                    Icon(painter = painterResource(id = R.drawable.outlinestar),null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(12.dp))
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text("好喝是好喝，就是减肥期还是要少喝，真的会长胖的，无糖版本的或许对减肥人士更友好一些，超出的文字……",
                    maxLines =2,
                    color=MaterialTheme.colorScheme.onSecondaryContainer,
                    style=MaterialTheme.typography.bodySmall
                )



            }
        }
    }
}
//用户评价带图卡片
@Composable
fun ImageCommentCard(){
    Card(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp)
            .size(380.dp, 206.dp)
            .clickable { },
        backgroundColor = MaterialTheme.colorScheme.secondaryContainer,
        elevation =1.dp,
        shape = RoundedCornerShape(12.dp)
    ){
        Row(modifier = Modifier.padding(12.dp)) {
            Image(
                painter = painterResource(R.drawable.head),
                contentDescription = "",
                modifier = Modifier
                    .size(40.dp, 40.dp)
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop,
                alignment = Alignment.TopCenter,
            )
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp)){
                Row(modifier = Modifier
                    .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween){
                    Text(
                        "康康need",
                        color=MaterialTheme.colorScheme.onBackground,
                        style=MaterialTheme.typography.titleSmall
                    )
                    Text(
                        "29八月",
                        color=MaterialTheme.colorScheme.outline,
                        style=MaterialTheme.typography.titleSmall
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Row(){
                    Icon(painter = painterResource(id = R.drawable.fillstar),null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(12.dp))
                    Icon(painter = painterResource(id = R.drawable.fillstar),null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(12.dp))
                    Icon(painter = painterResource(id = R.drawable.fillstar),null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(12.dp))
                    Icon(painter = painterResource(id = R.drawable.fillstar),null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(12.dp))
                    Icon(painter = painterResource(id = R.drawable.outlinestar),null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(12.dp))
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text("好喝是好喝，就是减肥期还是要少喝，真的会长胖的，无糖版本的或许对减肥人士更友好一些，超出的文字……",
                    maxLines =2,
                    color=MaterialTheme.colorScheme.onSecondaryContainer,
                    style=MaterialTheme.typography.bodySmall
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text("展开v",
                    maxLines =2,
                    color=MaterialTheme.colorScheme.primary,
                    style=MaterialTheme.typography.bodySmall
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(12.dp)){
                    Image(
                        painter = painterResource(R.drawable.cola),
                        contentDescription = "",
                        modifier = Modifier
                            .size(80.dp),
                        contentScale = ContentScale.Crop,
                        alignment = Alignment.Center,
                    )
                    Image(
                        painter = painterResource(R.drawable.cola),
                        contentDescription = "",
                        modifier = Modifier
                            .size(80.dp),
                        contentScale = ContentScale.Crop,
                        alignment = Alignment.Center,
                    )
                    Image(
                        painter = painterResource(R.drawable.cola),
                        contentDescription = "",
                        modifier = Modifier
                            .size(80.dp),
                        contentScale = ContentScale.Crop,
                        alignment = Alignment.Center,
                    )
                }



            }
        }
    }
}
//康康有话说卡片
@Composable
fun DetailCard(title: String,description:String){
    Card(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp)
            .size(380.dp, 127.dp),
        backgroundColor = MaterialTheme.colorScheme.secondaryContainer,
        elevation =1.dp,
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(1.dp,brush = Brush.verticalGradient(
            listOf(
                MaterialTheme.colorScheme.primary, // 这里可以加无数个
                MaterialTheme.colorScheme.secondaryContainer,
            )
        ))
    ){
        Column(modifier = Modifier.padding(start = 16.dp,top=8.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text(
                title,
                color=MaterialTheme.colorScheme.onBackground,
                style=MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
            )
            Row() {
                Image(
                    painter = painterResource(R.drawable.dog),
                    contentDescription = "",
                    modifier = Modifier
                        .size(48.dp, 48.dp)
                        .clip(RoundedCornerShape(12.dp)),
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.CenterStart,
                )

                Surface(modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, end = 16.dp)
                    .clip(RoundedCornerShape(12.dp)),
                color = Color.White){
                    Text(
                        description,
                        modifier = Modifier.padding(8.dp),
                        color=MaterialTheme.colorScheme.onBackground,
                        style=MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
        }
    }

//详情页商城卡片
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DetailShopCard() {
    Card(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp)
            .size(380.dp, 98.dp)
            .clickable { }
            .clip(RoundedCornerShape(12.dp)),

        // 设置点击波纹效果，注意如果 CardDemo() 函数不在 MaterialTheme 下调用
        // 将无法显示波纹效果

        elevation = 0.dp, // 设置阴影
        onClick = {},
        backgroundColor = MaterialTheme.colorScheme.secondaryContainer,
    )
    {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(start = 16.dp, top = 8.dp,end=16.dp)
        )
        {
            Image(
                painter = painterResource(R.drawable.cola),
                contentDescription = "",
                modifier = Modifier
                    .clip(RoundedCornerShape(12))
                    .size(64.dp),
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center,
            )
            Column(
                modifier = Modifier
                    .padding(start = 8.dp, end = 8.dp)
            ) {

                    androidx.compose.material3.Text(
                        "麦维他全麦粗粮酥性消化饼原味400g",
                        modifier = Modifier.width(200.dp),
                        style = MaterialTheme.typography.titleSmall,
                        color = MaterialTheme.colorScheme.onBackground,
                        maxLines = 2
                    )
                Spacer(modifier = Modifier.height(8.dp))
                androidx.compose.material3.Text(
                    "￥34.6",
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                    color = MaterialTheme.colorScheme.error
                )
            }


                Column(
                    modifier = Modifier
                        .width(45.dp)
                        .fillMaxWidth(),
                    ) {

                    Image(
                        painter = painterResource(R.drawable.alevel),
                        contentDescription = "",
                        modifier = Modifier
                            .size(45.dp,26.dp),
                        contentScale = ContentScale.Fit
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    androidx.compose.material.Surface(shape = RoundedCornerShape(12),
                    modifier = Modifier.size(36.dp)) {
                        IconButton(
                            colors = IconButtonDefaults.iconButtonColors(
                                containerColor = Color.White),
                            onClick = { /*TODO*/ }) {
                            Icon(painter = painterResource(id = R.drawable.shoppingcart),null,
                                tint=MaterialTheme.colorScheme.primary)
                        }
                    }

                }

        }
    }
}
//同类商品卡片
@Composable
fun ProductCard(title: String){
    Card(
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .size(148.dp, 170.dp),
        backgroundColor = MaterialTheme.colorScheme.secondaryContainer,
        border = BorderStroke(1.dp, color = MaterialTheme.colorScheme.primary),
        elevation = 0.dp,
        shape = RoundedCornerShape(12.dp)
    ){
        Column(modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(R.drawable.baishi),
                contentDescription = "",
                modifier = Modifier
                    .size(132.dp, 102.dp)
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Fit,
                alignment = Alignment.TopCenter,
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                title,
                color=MaterialTheme.colorScheme.onBackground,
                style=MaterialTheme.typography.titleSmall
            )
            Spacer(modifier = Modifier.height(4.dp))
            Row(modifier = Modifier
                .padding(start = 8.dp, end = 8.dp)
                .fillMaxWidth()
                ,verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween)
            {
                Image(
                    painter = painterResource(R.drawable.alevel),
                    contentDescription = "",
                    modifier = Modifier
                        .size(43.dp, 24.dp),
                    contentScale = ContentScale.Fit,
                    alignment = Alignment.TopCenter,
                )
                GradientButton(modifier = Modifier
                    .height(24.dp)
                    .fillMaxWidth(0.6f),
                    textId = "对比", onClick = {

                    }
                )
            }
        }
    }
}
//营养成分卡片
@Composable
fun NutritionCard(){
    Card(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp)
            .size(360.dp, 280.dp),
        backgroundColor = MaterialTheme.colorScheme.secondaryContainer,
        elevation =1.dp,
        shape = RoundedCornerShape(12.dp)
    ){
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 12.dp, end = 16.dp),
            horizontalAlignment = Alignment.Start,) {
            Row(verticalAlignment = Alignment.CenterVertically){
                Box(modifier = Modifier.size(30.dp)
                    ){
                    Icon(painter = painterResource(id = R.drawable.balance),null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier
                            .size(24.dp)
                            .align(Alignment.Center))

                }
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    "营养成分",
                    color=MaterialTheme.colorScheme.onBackground,
                    style=MaterialTheme.typography.titleMedium
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween) {
                Column(){
                        Text(
                            "营养成分",
                            color=MaterialTheme.colorScheme.outline,
                            style=MaterialTheme.typography.titleMedium
                        )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        "能量",
                        color=MaterialTheme.colorScheme.onBackground,
                        style=MaterialTheme.typography.bodySmall
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        "蛋白质",
                        color=MaterialTheme.colorScheme.onBackground,
                        style=MaterialTheme.typography.bodySmall
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        "碳水化合物",
                        color=MaterialTheme.colorScheme.onBackground,
                        style=MaterialTheme.typography.bodySmall
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        "脂肪",
                        color=MaterialTheme.colorScheme.onBackground,
                        style=MaterialTheme.typography.bodySmall
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        "反式脂肪",
                        color=MaterialTheme.colorScheme.onBackground,
                        style=MaterialTheme.typography.bodySmall
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        "钠",
                        color=MaterialTheme.colorScheme.onBackground,
                        style=MaterialTheme.typography.bodySmall
                    )

                    }

                    Column(horizontalAlignment = Alignment.CenterHorizontally){
                        Text(
                            "100g",
                            color=MaterialTheme.colorScheme.outline,
                            style=MaterialTheme.typography.titleMedium
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            "276kj（66kcal）",
                            color=MaterialTheme.colorScheme.onBackground,
                            style=MaterialTheme.typography.bodySmall
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            "276kj（66kcal）",
                            color=MaterialTheme.colorScheme.onBackground,
                            style=MaterialTheme.typography.bodySmall
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            "276kj（66kcal）",
                            color=MaterialTheme.colorScheme.onBackground,
                            style=MaterialTheme.typography.bodySmall
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            "276kj（66kcal）",
                            color=MaterialTheme.colorScheme.onBackground,
                            style=MaterialTheme.typography.bodySmall
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            "276kj（66kcal）",
                            color=MaterialTheme.colorScheme.onBackground,
                            style=MaterialTheme.typography.bodySmall
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            "276kj（66kcal）",
                            color=MaterialTheme.colorScheme.onBackground,
                            style=MaterialTheme.typography.bodySmall
                        )
                    }
                Column(horizontalAlignment = Alignment.CenterHorizontally){
                    Text(
                        "与同类产品比较",
                        color=MaterialTheme.colorScheme.outline,
                        style=MaterialTheme.typography.titleMedium
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        "-64%",
                        color=MaterialTheme.colorScheme.primary,
                        style=MaterialTheme.typography.bodySmall
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        "-64%",
                        color=MaterialTheme.colorScheme.primary,
                        style=MaterialTheme.typography.bodySmall
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        "-64%",
                        color=MaterialTheme.colorScheme.primary,
                        style=MaterialTheme.typography.bodySmall
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        "+64%",
                        color=MaterialTheme.colorScheme.error,
                        style=MaterialTheme.typography.bodySmall
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        "+64%",
                        color=MaterialTheme.colorScheme.error,
                        style=MaterialTheme.typography.bodySmall
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        "+64%",
                        color=MaterialTheme.colorScheme.error,
                        style=MaterialTheme.typography.bodySmall
                    )
                }



                }
            }
        }

    }
//全成分表卡片
@Composable
fun ComponentCard(){
    Card(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp)
            .size(360.dp, 204.dp),
        backgroundColor = MaterialTheme.colorScheme.secondaryContainer,
        elevation =1.dp,
        shape = RoundedCornerShape(12.dp)
    ){
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 12.dp, end = 16.dp),
            horizontalAlignment = Alignment.Start,) {
            Row(verticalAlignment = Alignment.CenterVertically){
                Box(modifier = Modifier.size(30.dp)
                ){
                    Icon(painter = painterResource(id = R.drawable.reference),null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier
                            .size(24.dp)
                            .align(Alignment.Center))

                }
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    "全成分表（共8种成分）",
                    color=MaterialTheme.colorScheme.onBackground,
                    style=MaterialTheme.typography.titleMedium
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Column(){
                Text(
                    "水、果葡糖浆,白砂糖、焦糖色、二氧化碳、磷酸、咖啡因、食用香料",
                    color=MaterialTheme.colorScheme.outline,
                    style=MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.height(8.dp))
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .height(88.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(color = MaterialTheme.colorScheme.inverseOnSurface)){
                    Column(modifier = Modifier.padding(start = 16.dp,top=12.dp)) {
                        Text(
                            "结论",
                            color=MaterialTheme.colorScheme.onBackground,
                            style=MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            "含有3种添加剂、含有添加糖",
                            color=MaterialTheme.colorScheme.error,
                            style=MaterialTheme.typography.bodyMedium
                        )
                        Text(
                            "不含有反式脂肪酸可能来源、不含有色素",
                            color=MaterialTheme.colorScheme.primary,
                            style=MaterialTheme.typography.bodyMedium
                        )
                    }
                }




            }
        }
    }

}
//产品对比卡片
@Composable
fun CompareCard(title: String){
    Card(
        modifier = Modifier
            //.padding(start = 16.dp, end = 16.dp)
            .size(176.dp,300.dp),
        backgroundColor =Color.White,
        elevation =0.dp,
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(0.dp, color = Color.Transparent)
    ){
        Column(modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween) {
            Image(
                painter = painterResource(R.drawable.baishi),
                contentDescription = "",
                modifier = Modifier
                    .size(160.dp, 160.dp)
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop,
                alignment = Alignment.TopCenter,
            )
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, end = 8.dp),
            horizontalArrangement = Arrangement.Center){
                Text(
                    title,
                    color=MaterialTheme.colorScheme.onBackground,
                    style=MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold)
                )
            }

            Row(modifier = Modifier
                .fillMaxWidth()
                , horizontalArrangement = Arrangement.Center)
            {
                Image(
                    painter = painterResource(R.drawable.alevel),
                    contentDescription = "",
                    modifier = Modifier
                        .size(94.dp, 53.dp),
                    contentScale = ContentScale.Fit,
                    alignment = Alignment.TopCenter,
                )
            }
        }
    }
}
//营养元素对比卡片
@Composable
fun NutriCompareCard(){
    Card(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp)
            .size(380.dp, 300.dp),
        backgroundColor = MaterialTheme.colorScheme.secondaryContainer,
        elevation =1.dp,
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(1.dp,brush = Brush.verticalGradient(
            listOf(
                MaterialTheme.colorScheme.primary, // 这里可以加无数个
                MaterialTheme.colorScheme.secondaryContainer,
            )
        ))
    ){
        Column(modifier = Modifier.padding(top=8.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Row(
                modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically){
                Divider(modifier = Modifier.width(66.dp),
                color = MaterialTheme.colorScheme.primary)
                Text(
                    "营养元素对比",
                    modifier=Modifier.padding(start=4.dp,end=4.dp),
                    color=MaterialTheme.colorScheme.onBackground,
                    style=MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                )
                Divider(modifier = Modifier.width(66.dp),
                    color = MaterialTheme.colorScheme.primary)

            }
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
}
//成分表对比卡片
@Composable
fun ComponentCompareCard(){
    Card(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp)
            .size(380.dp, 394.dp),
        backgroundColor = MaterialTheme.colorScheme.secondaryContainer,
        elevation =1.dp,
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(1.dp,brush = Brush.verticalGradient(
            listOf(
                MaterialTheme.colorScheme.primary, // 这里可以加无数个
                MaterialTheme.colorScheme.secondaryContainer,
            )
        ))
    ){
        Column(modifier = Modifier.padding(top=8.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically){
                Divider(modifier = Modifier.width(66.dp),
                    color = MaterialTheme.colorScheme.primary)
                Text(
                    "成分表对比",
                    modifier=Modifier.padding(start=4.dp,end=4.dp),
                    color=MaterialTheme.colorScheme.onBackground,
                    style=MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                )
                Divider(modifier = Modifier.width(66.dp),
                    color = MaterialTheme.colorScheme.primary)
            }
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween){
                Text(
                    "20种",
                    color=MaterialTheme.colorScheme.onSurface,
                    style=MaterialTheme.typography.bodyLarge
                )
                Text(
                    "成分数量",
                    color=MaterialTheme.colorScheme.onBackground,
                    style=MaterialTheme.typography.bodyLarge
                )
                Text(
                    "20种",
                    color=MaterialTheme.colorScheme.onSurface,
                    style=MaterialTheme.typography.bodyLarge
                )
            }
            Divider()
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween){
                Text(
                    "20种",
                    color=MaterialTheme.colorScheme.onSurface,
                    style=MaterialTheme.typography.bodyLarge
                )
                Text(
                    "添加剂数量",
                    color=MaterialTheme.colorScheme.onBackground,
                    style=MaterialTheme.typography.bodyLarge
                )
                Text(
                    "20种",
                    color=MaterialTheme.colorScheme.onSurface,
                    style=MaterialTheme.typography.bodyLarge
                )
            }
            Divider()
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,verticalAlignment = Alignment.CenterVertically){
                Image(
                    painter = painterResource(id = R.drawable.ture),null
                )
                Text(
                    "是否含添加糖",
                    color=MaterialTheme.colorScheme.onBackground,
                    style=MaterialTheme.typography.bodyLarge
                )
                Image(
                    painter = painterResource(id = R.drawable.checkfalse),
                    null
                )
            }
            Divider()
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically){
                Image(
                    painter = painterResource(id = R.drawable.ture),null
                )
                Text(
                    "是否有反式脂肪可能来源",
                    color=MaterialTheme.colorScheme.onBackground,
                    style=MaterialTheme.typography.bodyLarge
                )
                Image(
                    painter = painterResource(id = R.drawable.ture),null
                )
            }
            Divider()
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,verticalAlignment = Alignment.CenterVertically){
                Image(
                    painter = painterResource(id = R.drawable.ture),null
                )
                Text(
                    "是否含色素",
                    color=MaterialTheme.colorScheme.onBackground,
                    style=MaterialTheme.typography.bodyLarge
                )
                Image(
                    painter = painterResource(id = R.drawable.checkfalse),null
                )
            }
            Divider()
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,verticalAlignment = Alignment.CenterVertically){
                Image(
                    painter = painterResource(id = R.drawable.ture),null
                )
                Text(
                    "是否含过敏原",
                    color=MaterialTheme.colorScheme.onBackground,
                    style=MaterialTheme.typography.bodyLarge
                )
                Image(
                    painter = painterResource(id = R.drawable.checkfalse),null
                )
            }
        }
    }
}
//搜索记录卡片
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HistoryCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp) // 外边距
            .clickable { }
            .clip(RoundedCornerShape(12.dp))
            .height(136.dp),

        // 设置点击波纹效果，注意如果 CardDemo() 函数不在 MaterialTheme 下调用
        // 将无法显示波纹效果

        elevation = 2.dp, // 设置阴影
        onClick = {},
        backgroundColor = MaterialTheme.colorScheme.surfaceColorAtElevation(1.dp),
    )
    {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(start = 16.dp)
        )
        {
            Image(
                painter = painterResource(R.drawable.head),
                contentDescription = "",
                modifier = Modifier
                    .clip(RoundedCornerShape(12))
                    .size(80.dp),
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center,
            )
            Column(
                modifier = Modifier
                    .padding(start = 8.dp, end = 8.dp, top = 8.dp)
                    .width(197.dp)
                    .fillMaxHeight()
            ) {
                androidx.compose.material3.Text(
                    "麦维他全麦粗粮酥性消化饼原味400g",
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Spacer(Modifier.height(8.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .width(197.dp)
                        .fillMaxWidth()
                        .height(20.dp),
                    horizontalArrangement = Arrangement.spacedBy(4.dp),

                    ) {
                    Box(modifier = Modifier
                    .clip(CircleShape)
                    .background(LevelA)
                    .size(20.dp))
                    androidx.compose.material3.Text(
                        "健康匹配度高",
                        style = MaterialTheme.typography.titleSmall,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }
                Spacer(Modifier.height(8.dp))
                Image(
                    painter = painterResource(R.drawable.alevel),
                    contentDescription = "",
                    modifier = Modifier
                        .clip(RoundedCornerShape(12))
                        .height(45.dp)
                        .width(84.dp),
                    contentScale = ContentScale.Fit,
                    alignment = Alignment.TopCenter,
                )
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Default.KeyboardArrowRight,null)
            }

        }
    }
}
//搜索记录卡片
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun EditCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp) // 外边距
            .clickable { }
            .clip(RoundedCornerShape(12.dp))
            .height(96.dp),

        // 设置点击波纹效果，注意如果 CardDemo() 函数不在 MaterialTheme 下调用
        // 将无法显示波纹效果

        elevation = 2.dp, // 设置阴影
        onClick = {},
        backgroundColor = MaterialTheme.colorScheme.surfaceColorAtElevation(1.dp),
    )
    {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(start = 16.dp,end=16.dp)
        )
        {
            Image(
                painter = painterResource(R.drawable.head),
                contentDescription = "",
                modifier = Modifier
                    .clip(RoundedCornerShape(12))
                    .size(60.dp),
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center,
            )
            Column(
                modifier = Modifier
                    .padding(start = 8.dp, end = 8.dp,top=8.dp, bottom =8.dp)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                androidx.compose.material3.Text(
                    "麦维他全麦粗粮酥性消化饼原味400g",
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Spacer(Modifier.height(8.dp))
                Image(
                    painter = painterResource(R.drawable.blevel),
                    contentDescription = "",
                    modifier = Modifier
                        .clip(RoundedCornerShape(12))
                        .height(45.dp)
                        .width(84.dp),
                    contentScale = ContentScale.Fit
                )
            }

        }
    }
}
@Preview
@Composable
fun CardScreen() {
    KKNeedTheme {
        EditCard()
    }
}

