package com.example.kkneed.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kkneed.R
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

@Preview
@Composable
fun Pre(){
    ChangePhotoBottomSheet()
}