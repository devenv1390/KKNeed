package com.example.kkneed.ui

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
    onCopyClicked: () -> Unit,
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
                onClick = onCopyClicked,
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