package com.example.kkneed.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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

@Preview
@Composable
fun Pre() {
    KKNeedTheme {

    }
}