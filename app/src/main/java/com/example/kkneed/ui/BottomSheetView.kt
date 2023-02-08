package com.example.kkneed.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kkneed.R
import com.example.kkneed.ui.components.DetailChip
import com.example.kkneed.ui.theme.LevelC
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ChangePhotoBottomSheet(){
    val state = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)
    val scope = rememberCoroutineScope()
    ModalBottomSheetLayout(
        sheetState = state,
        sheetContent = {
            Column{
                ListItem(
                    text = { Text("选择分享到哪里吧~") }
                )

                ListItem(
                    text = { Text("github") },
                    icon = {
                        Surface(
                            shape = CircleShape,
                            color = MaterialTheme.colorScheme.onPrimary
                        ) {
                            Icon(
                                painterResource(R.drawable.ic_launcher_foreground),
                                null,
                                tint = Color.Black,
                                modifier = Modifier.padding(4.dp)
                            )
                        }
                    },
                    modifier = Modifier.clickable {  }
                )

                ListItem(
                    text = { Text("微信") },
                    icon = {
                        Surface(
                            shape = CircleShape,
                            color = Color(0xFF07C160)
                        ) {
                            Icon(
                                painterResource(R.drawable.ic_launcher_foreground),
                                null,
                                tint = Color.Black,
                                modifier = Modifier.padding(4.dp)
                            )
                        }
                    },
                    modifier = Modifier.clickable {  }
                )
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = { scope.launch { state.show() } }
            ) {
                Text("点我展开")
            }
        }
    }
}
//搜索页底部栏
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ScanBottomSheet(){
    val state = rememberModalBottomSheetState(ModalBottomSheetValue.Expanded)
    //val scope = rememberCoroutineScope()
    ModalBottomSheetLayout(
        sheetState = state,
        sheetShape = RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp),
        sheetContent = {
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)){
                Box(modifier = Modifier
                    .background(LevelC)
                    .fillMaxWidth()
                    .height(64.dp),
                contentAlignment = Alignment.Center){
                    Text(
                        "C等级食品",
                        color=MaterialTheme.colorScheme.onPrimary,
                        style=MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold)
                    )
                }
                ScanTopList("可口可乐300ml","可口可乐公司")
                DetailChip(state = false, title = listOf("超级加工食品","减脂期适量","糖尿病适量"))
                Spacer(modifier = Modifier.height(12.dp))

            }
        }
    ) {

    }
}
@Preview
@Composable
fun Pre(){
    ScanBottomSheet()
}