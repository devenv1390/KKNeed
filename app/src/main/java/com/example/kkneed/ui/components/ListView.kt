package com.example.kkneed.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.kkneed.R
import com.example.kkneed.ui.theme.KKNeedTheme
import com.example.kkneed.ui.theme.LevelA
import com.example.kkneed.ui.theme.LevelE

//关注列表
@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
@Composable
fun WatchList(){
    Column (){
        ListItem(
            headlineText = { Text(
                "康康",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
            },
            supportingText = { Text(
                "30000粉丝 3w+赞",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.outline
            ) },
            trailingContent = {
                //取消关注按钮
                Button(
                    onClick = { /* Do something! */ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.outline
                    ),
                ) {

                    Text("取消关注",
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                }
            },
            leadingContent = {
                Image(
                    painter = painterResource(R.drawable.head),
                    contentDescription = "",
                    modifier = Modifier
                        .clip(RoundedCornerShape(12.dp))
                        .size(32.dp),
                    contentScale = ContentScale.Crop
                )
            },

            )
        Divider()
}
}

@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
@Composable
fun FanList(){
    Column (){
        ListItem(
            headlineText = { Text(
                "康康",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
            },
            supportingText = { Text(
                "30000粉丝 3w+赞",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.outline
            ) },
            trailingContent = {
                Button(
                    onClick = { /* Do something! */ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.inversePrimary
                    ),
                ) {
                    Icon(
                    Icons.Filled.Add,
                    contentDescription = "",
                    modifier = Modifier.size(ButtonDefaults.IconSize)
                )
                    Spacer(Modifier.size(ButtonDefaults.IconSpacing))

                    Text("关注",
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                }
            },
            leadingContent = {
                Image(
                    painter = painterResource(R.drawable.head),
                    contentDescription = "",
                    modifier = Modifier
                        .clip(RoundedCornerShape(12.dp))
                        .size(32.dp),
                    contentScale = ContentScale.Crop
                )
            },

            )
        Divider()
    }
}
//详情页顶部列表
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailList(title:String,company:String){
    ListItem(
        headlineText = {
            androidx.compose.material3.Text(
                title,
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
            )
        },
        supportingText = { androidx.compose.material3.Text(company,
        style = MaterialTheme.typography.titleSmall,
        color = MaterialTheme.colorScheme.outline) },
        trailingContent = {
            Row(){
                Image(
                    painter = painterResource(R.drawable.alevel),
                    contentDescription = "",
                    modifier = Modifier
                        .size(80.dp,50.dp),
                    contentScale = ContentScale.Fit
                )
                DetailDialog()

            }

        },
        leadingContent = {
            Image(
                painter = painterResource(R.drawable.cola),
                contentDescription = "",
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .size(56.dp),
                contentScale = ContentScale.Crop
            )
        }
    )
}
//搜索页顶部列表
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScanTopList(title:String,company:String){
    ListItem(
        headlineText = {
            androidx.compose.material3.Text(
                title,
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
            )
        },
        supportingText = { androidx.compose.material3.Text(company,
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.outline) },
        trailingContent = {
            Row(){
                Image(
                    painter = painterResource(R.drawable.alevel),
                    contentDescription = "",
                    modifier = Modifier
                        .size(80.dp,50.dp),
                    contentScale = ContentScale.Fit
                )

            }

        },
        leadingContent = {
            Image(
                painter = painterResource(R.drawable.cola),
                contentDescription = "",
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .size(56.dp),
                contentScale = ContentScale.Crop
            )
        }
    )
}
//详情页优缺点列表
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VantageList(title:String,color:Color,navController: NavController,route:String){
    ListItem(
        headlineText = { Text(title,
            style = MaterialTheme.typography.bodyMedium,
        color = MaterialTheme.colorScheme.onBackground) },
        leadingContent = {
                         Box(modifier = Modifier
                             .clip(CircleShape)
                             .background(color)
                             .size(40.dp)){}
        },
        trailingContent = {
            IconButton(onClick = { navController.navigate(route) }) {
                Icon(
                    Icons.Filled.KeyboardArrowRight,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp),
                )
            }

        },
    )
}
//点击优缺点后详情页顶部列表
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailList(title:String,color:Color){
    ListItem(
        headlineText = { Text(title,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onBackground) },
        leadingContent = {
            Box(modifier = Modifier
                .clip(CircleShape)
                .background(color)
                .size(40.dp)){}
        }
    )
}
//详情页优缺点展开列表
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VantageList2(title:String){
    ListItem(
        headlineText = { Text(title,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onBackground) },

        trailingContent = {
            Icon(
                Icons.Filled.KeyboardArrowDown,
                contentDescription = null,
                modifier = Modifier.size(24.dp),
            )
        },
    )
}
//我的记录列表
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecordList(title:String,color:Color){
    ListItem(
        colors = ListItemDefaults.colors(
        containerColor = MaterialTheme.colorScheme.secondaryContainer
        ),
        headlineText = {
                Text(title+"等级食品",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.primary)
                       },
        leadingContent = {
            Box(modifier = Modifier
                .clip(CircleShape)
                .background(color)
                .size(40.dp)){
                Text(title,
                    modifier=Modifier.align(Alignment.Center),
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onPrimary)
            }
        },

        trailingContent = {
            Row(){
                Text("21",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.outline)
                Icon(
                    Icons.Filled.KeyboardArrowRight,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp),
                )
            }

        },
    )
}
@Preview
@Composable
fun ChipScreen() {
    KKNeedTheme {
        RecordList("A", LevelA)

    }
}
