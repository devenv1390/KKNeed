package com.example.kkneed.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kkneed.R
import com.example.kkneed.ui.components.CustomizeChip
import com.example.kkneed.ui.components.DetailChip
import com.example.kkneed.ui.theme.KKNeedTheme
import com.example.kkneed.ui.theme.LevelC
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


//搜索页底部栏
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ScanBottomSheet() {
    val state = rememberModalBottomSheetState(ModalBottomSheetValue.Expanded)
    //val scope = rememberCoroutineScope()
    ModalBottomSheetLayout(
        sheetState = state,
        sheetShape = RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp),
        sheetContent = {
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                Box(
                    modifier = Modifier
                        .background(LevelC)
                        .fillMaxWidth()
                        .height(64.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        "C等级食品",
                        color = MaterialTheme.colorScheme.onPrimary,
                        style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold)
                    )
                }
                ScanTopList("可口可乐300ml", "可口可乐公司")
                DetailChip(state = false, title = listOf("超级加工食品", "减脂期适量", "糖尿病适量"))
                Spacer(modifier = Modifier.height(12.dp))

            }
        }
    ) {

    }
}

//更换头像底部栏
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ChangePhotoBottomSheet(state: ModalBottomSheetState, scope: CoroutineScope) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            "设置头像",
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.outline,
            modifier = Modifier.padding(top = 12.dp)
        )

        Divider()
        IconButton(modifier = Modifier.height(40.dp),
            onClick = { /*TODO*/ }) {
            Text(
                "拍照",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
        Divider()
        IconButton(modifier = Modifier.height(40.dp),
            onClick = { /*TODO*/ }) {
            Text(
                "从本地图片读取",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
        Box(
            modifier = Modifier.height(12.dp)
                .background(MaterialTheme.colorScheme.outline.copy(0.7f))
                .fillMaxWidth()
        )
        IconButton(modifier = Modifier.height(40.dp),
            onClick = { scope.launch { state.hide() } }) {
            Text(
                "取消",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}
//编辑健康档案底部栏
@SuppressLint("ResourceType")
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ChoseBottomSheet(
    state:ModalBottomSheetState,scope:CoroutineScope
){
    Column(modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(12.dp)){
        Row(modifier= Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            , verticalAlignment = Alignment.CenterVertically){
            Box(modifier = Modifier.fillMaxWidth()){
                Text("编辑健康档案",
                    style =MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    modifier = Modifier.align(Alignment.Center)
                )
                TextButton(onClick = { scope.launch { state.hide() }},
                    modifier = Modifier.align(Alignment.CenterEnd)) {
                    Text("完成",
                        style =MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                        color = MaterialTheme.colorScheme.primary,

                    )
                }
            }
        }
        Text("已添加",
            style =MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
            color = MaterialTheme.colorScheme.onSecondaryContainer,
            modifier=Modifier
                .padding(horizontal = 16.dp)
        )
        HealthCard("健身记录", R.drawable.fire, R.drawable.sportpie,"177","千卡")
        HealthCard2("腹部绞痛", R.drawable.fire,"出现/轻微","")
        HealthCard("经期跟踪", R.drawable.fire, R.drawable.open,"月经量","三天前")
        Spacer(modifier = Modifier.height(12.dp))
        Text("待添加",
            style =MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
            color = MaterialTheme.colorScheme.onSecondaryContainer,
            modifier=Modifier
                .padding(horizontal = 16.dp)
        )
        HealthCard2("睡眠", R.drawable.fire,"7.1","小时")
        HealthCard2("腹泻", R.drawable.fire,"出现/轻微","")
        HealthCard3("健身记录", R.drawable.fire,"160","50")
        Spacer(modifier = Modifier.height(36.dp))
    }

}
//问卷页选择过敏原底部栏
@SuppressLint("ResourceType")
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun InfoBottomSheet(
    //state:ModalBottomSheetState,scope:CoroutineScope
){

    val sheetState = rememberBottomSheetState(
        initialValue = BottomSheetValue.Collapsed
    )
    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = sheetState
    )
    val scope = rememberCoroutineScope()
    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetShape = RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp),
        sheetContent = {
            Column(modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(12.dp)){
                    Box(modifier = Modifier.fillMaxWidth()){
                        Text("请选择您的过敏原类型",
                            style =MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                            color = MaterialTheme.colorScheme.onSecondaryContainer,
                            modifier = Modifier.align(Alignment.Center)
                        )
                        TextButton(onClick = { scope.launch { sheetState.collapse() }},
                            modifier = Modifier.align(Alignment.CenterEnd)) {
                            Text("完成",
                                style =MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                                color = MaterialTheme.colorScheme.primary,
                                )
                        }
                }
                Row(modifier=Modifier.fillMaxWidth()
                , horizontalArrangement = Arrangement.SpaceBetween){
                    CustomizeChip(false,"乳制品")
                    CustomizeChip(false,"麸质")
                    CustomizeChip(false,"坚果")
                    CustomizeChip(false,"花生")
                }
                Row(modifier=Modifier.fillMaxWidth()
                    , horizontalArrangement = Arrangement.SpaceBetween){
                    CustomizeChip(false,"二氧化硫")
                    CustomizeChip(false,"亚硫酸盐")
                    CustomizeChip(false,"大豆类制品")
                }
                Row(modifier=Modifier.fillMaxWidth()
                    , horizontalArrangement = Arrangement.SpaceBetween){
                    CustomizeChip(false,"芥末")
                    CustomizeChip(false,"芝麻")

                }

            }

        },
        sheetBackgroundColor = MaterialTheme.colorScheme.onPrimary,
        sheetPeekHeight = 0.dp
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Button(onClick = {
                scope.launch {
                    if(sheetState.isCollapsed) {
                        sheetState.expand()
                    } else {
                        sheetState.collapse()
                    }
                }
            }) {
                Text(text = "Bottom sheet fraction: ${sheetState.progress.fraction}")
            }
        }
    }

}
@Preview
@Composable
fun Pre() {
    KKNeedTheme {
        InfoBottomSheet()
    }
}