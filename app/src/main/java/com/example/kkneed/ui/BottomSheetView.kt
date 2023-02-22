package com.example.kkneed.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material.icons.filled.Public
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kkneed.R
import com.example.kkneed.model.Scan
import com.example.kkneed.model.ScanType
import com.example.kkneed.ui.components.CustomizeInfoChip
import com.example.kkneed.ui.components.DetailChip
import com.example.kkneed.ui.theme.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


//搜索页底部栏
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ScanBottomSheet(state: ModalBottomSheetState, scope: CoroutineScope) {
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
@Composable
fun ScanSheet(
    scan: Scan,
    onShareClicked: () -> Unit,
    onInfoClicked: () -> Unit,
    onWebClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(BaseDP),
        modifier = modifier
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_bottom_handle),
            contentDescription = null,
            tint = Color.LightGray,
            modifier = Modifier
                .padding(top = SpaceDP)
                .align(Alignment.CenterHorizontally)
        )
        Text(
            text = stringResource(id = scan.scanFormatId),
            style = androidx.compose.material.MaterialTheme.typography.h6,
            fontWeight = FontWeight.Bold
        )
        if (scan.displayValue.isNotBlank()) {
            Surface(
                shape = androidx.compose.material.MaterialTheme.shapes.medium,
                elevation = ElevationDP,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = scan.displayValue,
                    style = androidx.compose.material.MaterialTheme.typography.body1,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(SpaceDP)
                )
            }
        }
        Divider()
        Row(
            horizontalArrangement = Arrangement.spacedBy(BaseDP, Alignment.End),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            FloatingActionButton(
                onClick = onShareClicked,
                contentColor = Color.White,
                modifier = Modifier.requiredSize(48.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Share,
                    contentDescription = null
                )
            }
            FloatingActionButton(
                onClick = onInfoClicked,
                contentColor = Color.White,
                modifier = Modifier.requiredSize(48.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.ContentCopy,
                    contentDescription = null
                )
            }
            if (scan.scanType == ScanType.Url) {
                ExtendedFloatingActionButton(
                    contentColor = Color.White,
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Public,
                            contentDescription = null
                        )
                    },
                    text = {
                        Text(
                            text = stringResource(id = R.string.scan_sheet_web_action),
                            style = androidx.compose.material.MaterialTheme.typography.body1,
                            fontWeight = FontWeight.SemiBold
                        )
                    },
                    onClick = onWebClicked
                )
            }
        }
        Spacer(modifier = Modifier.height(2.dp))
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
            modifier = Modifier
                .height(12.dp)
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
        Spacer(modifier = Modifier.height(16.dp))
    }
}
//编辑产品底部栏
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun EditProductBottomSheet(state: ModalBottomSheetState, scope: CoroutineScope) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            "编辑产品",
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.outline,
            modifier = Modifier.padding(top = 12.dp)
        )

        Divider()
        IconButton(modifier = Modifier.height(40.dp),
            onClick = { /*TODO*/ }) {
            Text(
                "修改评价",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
        Divider()
        IconButton(modifier = Modifier.height(40.dp),
            onClick = { /*TODO*/ }) {
            Text(
                "删除",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
        Box(
            modifier = Modifier
                .height(12.dp)
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
        Spacer(modifier = Modifier.height(16.dp))
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
    sheetState:BottomSheetState,scaffoldState:BottomSheetScaffoldState,scope:CoroutineScope
){
    Column(modifier = Modifier
        .fillMaxWidth()
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
            , horizontalArrangement = Arrangement.spacedBy(8.dp)){
            CustomizeInfoChip(false,"乳制品")
            CustomizeInfoChip(false,"麸质")
            CustomizeInfoChip(false,"坚果")
            CustomizeInfoChip(false,"花生")
        }
        Row(modifier=Modifier.fillMaxWidth()
            , horizontalArrangement = Arrangement.spacedBy(8.dp)){
            CustomizeInfoChip(false,"二氧化硫")
            CustomizeInfoChip(false,"亚硫酸盐")
            CustomizeInfoChip(false,"大豆类制品")
        }
        Row(modifier=Modifier.fillMaxWidth()
            , horizontalArrangement = Arrangement.spacedBy(8.dp)){
            CustomizeInfoChip(false,"芥末")
            CustomizeInfoChip(false,"芝麻")

        }
        Spacer(modifier = Modifier.height(36.dp))
    }



}
@Preview
@Composable
fun Pre() {
    KKNeedTheme {

    }
}