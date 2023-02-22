package com.example.kkneed.screen.home

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kkneed.R
import com.example.kkneed.ui.CommentCard
import com.example.kkneed.ui.GradientButton
import com.example.kkneed.ui.NoteTopAppBar
import com.example.kkneed.ui.theme.KKNeedTheme

@OptIn(ExperimentalMaterialApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun NoteDetailScreen(navController: NavController) {
    Scaffold(
        backgroundColor = MaterialTheme.colorScheme.background,
        topBar = {
            NoteTopAppBar(64.dp, navController)
        },
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .verticalScroll(
                    rememberScrollState()
                ),
        ) {
            //顶部信息
            Row() {
                Image(
                    painter = painterResource(R.drawable.head),
                    contentDescription = "",
                    modifier = Modifier
                        .clip(RoundedCornerShape(12))
                        .size(40.dp),
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.Center,
                )
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(start = 8.dp),
                    horizontalAlignment = Alignment.Start,
                ) {
                    androidx.compose.material3.Text(
                        "康康顾问",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    androidx.compose.material3.Text(
                        "6小时前",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.outline
                    )
                }
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.End,
                ) {
                    GradientButton(
                        modifier = Modifier
                            .height(40.dp)
                            .width(70.dp),
                        textId = "关注",
                        onClick = { }
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            //文字部分
            Column(modifier = Modifier.fillMaxWidth()) {
                androidx.compose.material3.Text(
                    "健康食品知多少？",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Spacer(modifier = Modifier.height(8.dp))
                androidx.compose.material3.Text(
                    "你真的了解健康食品吗？你知道怎样的包装食品才算是真健康吗？\n" +
                            "对食品成分进行分类：\n" +
                            "理想的营养素和食物：纤维、蛋白质、水果、蔬菜等\n" +
                            "应限制的营养素：卡路里、饱和脂肪、糖、盐等\n" +
                            "通过营养分数计算系统进行计算，为不同分数的产品分配对应的字母和颜色：\n" +
                            "最有营养的为A级\n" +
                            "营养最少的为E级",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Spacer(modifier = Modifier.height(16.dp))
                //图片部分
                Row(modifier = Modifier.fillMaxWidth()
                , horizontalArrangement = Arrangement.Center) {
                    Image(
                        painter = painterResource(R.drawable.head),
                        contentDescription = "",
                        modifier = Modifier
                            .clip(RoundedCornerShape(12))
                            .size(140.dp),
                        contentScale = ContentScale.Crop,
                        alignment = Alignment.Center,
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Image(
                        painter = painterResource(R.drawable.head),
                        contentDescription = "",
                        modifier = Modifier
                            .clip(RoundedCornerShape(12))
                            .size(140.dp),
                        contentScale = ContentScale.Crop,
                        alignment = Alignment.Center,
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                    Image(
                        painter = painterResource(R.drawable.head),
                        contentDescription = "",
                        modifier = Modifier
                            .clip(RoundedCornerShape(12))
                            .size(140.dp),
                        contentScale = ContentScale.Crop,
                        alignment = Alignment.Center,
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Image(
                        painter = painterResource(R.drawable.head),
                        contentDescription = "",
                        modifier = Modifier
                            .clip(RoundedCornerShape(12))
                            .size(140.dp),
                        contentScale = ContentScale.Crop,
                        alignment = Alignment.Center,
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                androidx.compose.material3.Text(
                    "最新评论",
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                    color = MaterialTheme.colorScheme.onBackground
                )
                Spacer(modifier = Modifier.height(8.dp))
                CommentCard()
            }
        }


    }
}

@Preview
@Composable
fun PreviewNoteDetailScreen() {
    KKNeedTheme {
        val navController = rememberNavController()
        NoteDetailScreen(navController)
    }
}
